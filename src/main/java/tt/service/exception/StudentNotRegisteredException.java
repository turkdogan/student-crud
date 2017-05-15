package tt.service.exception;

import tt.model.Student;

public class StudentNotRegisteredException extends RuntimeException {
    public StudentNotRegisteredException(Student student) {
    }
}
