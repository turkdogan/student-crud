package tt.service;

import tt.model.Student;

import java.util.List;

public interface IStudentService {

    void create(Student student);

    void update(Student student);

    void delete(Student student);

    Student find(Long id);

    List<Student> findAll();
}
