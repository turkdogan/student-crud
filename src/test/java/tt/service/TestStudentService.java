package tt.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tt.model.City;
import tt.model.District;
import tt.model.Student;
import tt.repository.ICityDao;
import tt.repository.IDistrictDao;

import java.sql.SQLException;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testApplicationContext.xml")
public class TestStudentService {

    @Autowired
    private IStudentService studentService;

    @Autowired
    private ICityDao cityDao;

    @Autowired
    private IDistrictDao districtDao;

    @Test
    public void testEmptyStudents() {
        final List<Student> allStudents = studentService.findAll();
        Assert.assertEquals(0, allStudents.size());
    }

    @Test
    public void testNewStudent() throws SQLException {
        Student student = createStudent();
        Assert.assertNotNull(student.getId());

        Long id = student.getId();
        Student studentFromDb = studentService.find(id);

        Assert.assertEquals(student.getFirstname(), studentFromDb.getFirstname());
        Assert.assertEquals(student.getCity(), studentFromDb.getCity());
        Assert.assertEquals(student.getDistrict(), studentFromDb.getDistrict());

        Assert.assertNull(student.getDescription());

        final List<Student> allStudents = studentService.findAll();
        Assert.assertEquals(1, allStudents.size());

        studentService.delete(student);
        Assert.assertEquals(0, studentService.findAll().size());
    }

    private Student createStudent() {
        Student student = new Student();
        student.setFirstname("Yuruyen");
        student.setLastname("Coni");

        City city = cityDao.findCity(1L);
        final List<District> districtsForCity = districtDao.findDistrictsForCity(city);

        student.setCity(city);
        student.setDistrict(districtsForCity.get(0));

        studentService.create(student);
        return student;
    }


    @Test(expected = EmptyResultDataAccessException.class)
    public void testNonExistentStudent() {
        studentService.find(2L);
    }
}
