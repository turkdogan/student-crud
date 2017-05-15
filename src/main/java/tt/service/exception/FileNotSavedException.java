package tt.service.exception;

import tt.model.StudentFile;

public class FileNotSavedException extends RuntimeException {
    public FileNotSavedException(StudentFile file) {
    }
}
