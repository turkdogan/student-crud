package tt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tt.model.City;
import tt.model.District;
import tt.repository.ICityDao;
import tt.repository.IDistrictDao;

import java.util.List;

@Service
@Transactional(readOnly=true)
public class CityService implements ICityService {

    @Autowired
    private ICityDao cityDao;

    @Autowired
    private IDistrictDao districtDao;

    public List<City> findAll() {
        return cityDao.findAllCities();
    }

    public List<District> findDistrictsForCity(final City city) {
        return districtDao.findDistrictsForCity(city);
    }

    public City findCity(final Long cityId) {
        return cityDao.findCity(cityId);
    }

    public District findDistrict(final Long districtId) {
        return districtDao.findDistrict(districtId);
    }
}
