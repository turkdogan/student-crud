package tt.repository;

import tt.model.City;

import java.util.List;

public interface ICityDao {
    City findCity(Long id);
    List<City> findAllCities();
}
