package tt.service;

import tt.model.Student;
import tt.model.StudentFile;

import java.util.List;

public interface IFileService {

    void addFileToStudent(final Student student, final StudentFile file);

    void deleteFile(StudentFile file);

    List<StudentFile> findStudentFiles(Student student);
}
