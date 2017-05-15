package tt.repository;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import tt.model.City;

import javax.sql.DataSource;

/**
 * City table is read-only
 */
public class TestCityDao {

    private DataSource dataSource;

    @Before
    public void initialize() {
        dataSource = DbTestUtil.getInstance().getEmptyDataSource();
    }

    @Test
    public void testFindAllCities() {
        CityDao cityDao = new CityDao();
        cityDao.setDataSource(dataSource);
        Assert.assertEquals(2, cityDao.findAllCities().size());
    }

    @Test
    public void testFindCityById() {
        CityDao cityDao = new CityDao();
        cityDao.setDataSource(dataSource);

        final City city = cityDao.findCity(1L);
        Assert.assertEquals("Ankara", city.getName());
    }
}
