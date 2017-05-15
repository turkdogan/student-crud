package tt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import tt.model.Student;
import tt.model.StudentFile;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class FileDao implements IFileDao {

    public List<StudentFile> findStudentFiles(final Student student) {
        return this.jdbcTemplate.query("SELECT * FROM StudentFile where student_id = ? and deleted=false ",
                new Long[]{student.getId()}, new FileRowMapper());
    }

    public void addFileToStudent(final Student student, final StudentFile file) {
        Map<String, Object> parameters = new HashMap<String, Object>(2);
        parameters.put("file_name", file.getName());
        parameters.put("description", file.getDescription());
        parameters.put("content", file.getContent());
        parameters.put("content_type", file.getContentType());
        parameters.put("student_id", student.getId());
        parameters.put("deleted", false);
        Number newId = fileCreator.executeAndReturnKey(parameters);
        file.setId(newId.longValue());
    }

    public void deleteFile(StudentFile file) {
        this.jdbcTemplate.update("UPDATE StudentFile set deleted = true WHERE id = ? ", file.getId());
    }

    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert fileCreator;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.fileCreator =
                new SimpleJdbcInsert(dataSource)
                        .withTableName("StudentFile")
                        .usingGeneratedKeyColumns("id");
    }

}
