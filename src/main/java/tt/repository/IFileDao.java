package tt.repository;

import tt.model.Student;
import tt.model.StudentFile;

import java.util.List;

public interface IFileDao {
    List<StudentFile> findStudentFiles(Student student);

    void addFileToStudent(Student student, StudentFile file);

    void deleteFile(StudentFile file);
}
