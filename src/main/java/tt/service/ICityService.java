package tt.service;

import tt.model.City;
import tt.model.District;

import java.util.List;

public interface ICityService {

    List<City> findAll();
    List<District> findDistrictsForCity(final City city);

    City findCity(Long cityId);
    District findDistrict(Long districtId);
}
