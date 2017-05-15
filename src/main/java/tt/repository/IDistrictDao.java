package tt.repository;

import tt.model.City;
import tt.model.District;

import java.util.List;

public interface IDistrictDao {
    District findDistrict(final Long id);
    List<District> findDistrictsForCity(final City city);
}
