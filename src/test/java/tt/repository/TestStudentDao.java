package tt.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tt.model.City;
import tt.model.District;
import tt.model.Student;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;


public class TestStudentDao {

    private DataSource dataSource;

    @Before
    public void initialize() {
        dataSource = DbTestUtil.getInstance().getEmptyDataSource();
    }

    @Test
    public void testEmptyStudents() {
        StudentDao studentDao = new StudentDao();
        studentDao.setDataSource(dataSource);

        Assert.assertEquals(0, studentDao.findAllStudents().size());
    }

    @Test
    public void testNewStudent() throws SQLException {
        StudentDao studentDao = new StudentDao();
        studentDao.setDataSource(dataSource);

        Student student = new Student();
        student.setFirstname("Yuruyen");
        student.setLastname("Coni");

        CityDao cityDao = new CityDao();
        cityDao.setDataSource(dataSource);
        City city = cityDao.findCity(1L);

        DistrictDao districtDao = new DistrictDao();
        districtDao.setDataSource(dataSource);
        final List<District> districtsForCity = districtDao.findDistrictsForCity(city);

        student.setCity(city);
        student.setDistrict(districtsForCity.get(0));

        studentDao.createStudent(student);
        Assert.assertNotNull(student.getId());

        Long id = student.getId();
        Student studentFromDb = studentDao.findStudent(id);

        Assert.assertEquals(student.getFirstname(), studentFromDb.getFirstname());
        Assert.assertEquals(student.getCity(), studentFromDb.getCity());
        Assert.assertEquals(student.getDistrict(), studentFromDb.getDistrict());

        Assert.assertNull(student.getDescription());

        final List<Student> allStudents = studentDao.findAllStudents();
        Assert.assertEquals(1, allStudents.size());

        studentDao.deleteStudent(student);
        Assert.assertEquals(0, studentDao.findAllStudents().size());
    }
}
