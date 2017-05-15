package tt.repository;

import tt.model.Student;

import java.util.List;

public interface IStudentDao {

    void createStudent(Student student);

    void updateStudent(Student student);

    void deleteStudent(Student student);

    List<Student> findAllStudents();

    Student findStudent(Long id);
}
