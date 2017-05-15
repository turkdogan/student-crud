package tt.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import tt.model.City;
import tt.model.District;

import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:testApplicationContext.xml")
public class TestCityService {

    @Autowired
    private ICityService cityService;

    @Test
    public void testMockCities() {
        final List<City> all = cityService.findAll();
        Assert.assertEquals(2, all.size());
    }

    @Test
    public void testMockAnkara() {
        final City city = cityService.findCity(1L);
        Assert.assertEquals("Ankara", city.getName());
    }

    @Test
    public void testMockCankaya() {
        final District district = cityService.findDistrict(1L);
        Assert.assertEquals("Cankaya", district.getName());
    }

    @Test
    public void testMockAnkaraDistricts() {
        final City city = cityService.findCity(1L);
        final List<District> districtsForCity = cityService.findDistrictsForCity(city);
        Assert.assertEquals(3, districtsForCity.size());
        Assert.assertEquals("Cankaya", districtsForCity.get(0).getName());
        Assert.assertEquals("Yenimahalle", districtsForCity.get(1).getName());
        Assert.assertEquals("Mamak", districtsForCity.get(2).getName());
    }

}
