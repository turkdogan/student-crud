package tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tt.model.Student;
import tt.repository.IStudentDao;

import java.util.List;

@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDao studentDao;

    @Transactional
    public void create(final Student student) {
        studentDao.createStudent(student);
    }

    @Transactional
    public void update(final Student student) {
        studentDao.updateStudent(student);
    }

    @Transactional
    public void delete(final Student student) {
        studentDao.deleteStudent(student);
    }

    @Transactional(readOnly=true)
    public Student find(final Long id) {
        return studentDao.findStudent(id);
    }

    @Transactional(readOnly=true)
    public List<Student> findAll() {
        return studentDao.findAllStudents();
    }
}
