package tt.controller;

import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.DefaultStreamedContent;
import tt.model.Student;
import tt.model.StudentFile;
import tt.service.IFileService;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

@ManagedBean
@ViewScoped
public class FileController {

    @ManagedProperty(value = "#{fileService}")
    private IFileService fileService;

    private Student student;

    private List<StudentFile> fileList;

    public void upload(final FileUploadEvent event) {
        StudentFile file = new StudentFile();
        file.setName(event.getFile().getFileName());
        file.setContentType(event.getFile().getContentType());
        file.setContent(event.getFile().getContents());
        fileService.addFileToStudent(student, file);

        getStudentFiles();
    }

    public DefaultStreamedContent download(final StudentFile file) {
        InputStream stream = FacesContext.getCurrentInstance().getExternalContext().getResourceAsStream("/resources/demo/images/optimus.jpg");
        ByteArrayInputStream bis = new ByteArrayInputStream(file.getContent());
        return new DefaultStreamedContent(bis, file.getContentType(), file.getName());
    }

    private void getStudentFiles() {
        fileList = fileService.findStudentFiles(student);
    }

    public void deleteFile(final StudentFile file) {
        fileService.deleteFile(file);
        getStudentFiles();
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
        getStudentFiles();
    }

    public List<StudentFile> getFileList() {
        return fileList;
    }

    public void setFileList(List<StudentFile> fileList) {
        this.fileList = fileList;
    }

    public IFileService getFileService() {
        return fileService;
    }

    public void setFileService(IFileService fileService) {
        this.fileService = fileService;
    }
}
