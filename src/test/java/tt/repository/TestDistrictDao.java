package tt.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tt.model.City;
import tt.model.District;

import javax.sql.DataSource;
import java.util.List;

/**
 * District table is read-only
 */
public class TestDistrictDao {

    private DataSource dataSource;

    @Before
    public void initialize() {
        dataSource = DbTestUtil.getInstance().getMockedDataSource();
    }

    @Test
    public void testFindDistrictById() {
        DistrictDao districtDao = new DistrictDao();
        districtDao.setDataSource(dataSource);

        final District district = districtDao.findDistrict(1L);
        Assert.assertEquals("Cankaya", district.getName());
    }

    @Test
    public void testFindDistrictsByCityId() {
        CityDao cityDao = new CityDao();
        cityDao.setDataSource(dataSource);

        // city is Ankara
        final City city = cityDao.findCity(1L);

        DistrictDao districtDao = new DistrictDao();
        districtDao.setDataSource(dataSource);
        final List<District> districtList = districtDao.findDistrictsForCity(city);
        Assert.assertEquals(3, districtList.size());
    }
}
