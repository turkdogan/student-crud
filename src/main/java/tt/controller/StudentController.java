package tt.controller;

import tt.model.City;
import tt.model.District;
import tt.model.Student;
import tt.service.ICityService;
import tt.service.IStudentService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.ViewScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ViewScoped
public class StudentController {

    // current student in view scope
    private Student student;

    @ManagedProperty(value = "#{studentService}")
    private IStudentService studentService;

    @ManagedProperty(value = "#{cityService}")
    private ICityService cityService;

    public List<Student> getStudents() {
        return studentService.findAll();
    }

    private List<City> cityList;

    public List<City> getCityList() {
        return cityList;
    }

    @PostConstruct
    public void setup() {
        cityList = cityService.findAll();
    }

    public IStudentService getStudentService() {
        return studentService;
    }

    public void setStudentService(final IStudentService studentService) {
        this.studentService = studentService;
    }

    public ICityService getCityService() {
        return this.cityService;
    }

    public void setCityService(final ICityService cityService) {
        this.cityService = cityService;
    }

    public void saveOrUpdate() {
        if (student != null) {
            if (cityId != null) {
                final City city = cityService.findCity(cityId);
                student.setCity(city);
            }
            if (districtId != null) {
                final District district = cityService.findDistrict(districtId);
                student.setDistrict(district);
            }
            if (student.getId() != null) {
                studentService.update(student);
            } else {
                studentService.create(student);
            }
        }
    }

    public void create() {
        student = new Student();
        districtId = cityId = null;
    }

    public void delete(Student student) {
        studentService.delete(student);
    }

    public Student find(Long id) {
        return studentService.find(id);
    }

    public List<Student> findAll() {
        return studentService.findAll();
    }

    public void setStudent(Student student) {
        this.student = student;
        if (student == null) {
            cityId = districtId = null;
        } else {
            if (student.getCity() != null) {
                cityId = student.getCity().getId();
                City city = new City();
                city.setId(cityId);
                districtList = cityService.findDistrictsForCity(city);
            } else {
                cityId = null;
            }
            if (student.getDistrict() != null) {
                districtId = student.getDistrict().getId();
            } else {
                districtId = null;
            }
        }
    }

    public Student getStudent() {
        return student;
    }

    private Long cityId;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(final Long cityId) {
        this.cityId = cityId;
    }

    private Long districtId;

    public Long getDistrictId() {
        return districtId;
    }

    public void setDistrictId(final Long districtId) {
        this.districtId = districtId;
    }

    private List<District> districtList;

    public List<District> getDistrictList() {
        return districtList;
    }

    public void setDistrictList(final List<District> districtList) {
        this.districtList = districtList;
    }

    public void onCityChange() {
        if (cityId != null) {
            City city = new City();
            city.setId(cityId);
            districtList = cityService.findDistrictsForCity(city);
        } else {
            districtList = new ArrayList<District>();
        }
    }
}
