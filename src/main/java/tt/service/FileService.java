package tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tt.model.Student;
import tt.model.StudentFile;
import tt.repository.IFileDao;
import tt.service.exception.FileNotSavedException;
import tt.service.exception.StudentNotRegisteredException;

import java.util.List;

@Service
public class FileService implements IFileService {

    @Autowired
    private IFileDao fileDao;

    public void addFileToStudent(final Student student, final StudentFile file) {
        if (student.getId() == null) {
            throw new StudentNotRegisteredException(student);
        }
        fileDao.addFileToStudent(student, file);
    }

    public void deleteFile(final StudentFile file) {
        if (file.getId() == null) {
            throw new FileNotSavedException(file);
        }
        fileDao.deleteFile(file);
    }

    public List<StudentFile> findStudentFiles(final Student student) {
        if (student.getId() == null) {
            throw new StudentNotRegisteredException(student);
        }
        return fileDao.findStudentFiles(student);
    }
}
