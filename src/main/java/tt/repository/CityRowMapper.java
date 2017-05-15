
package tt.repository;

import org.springframework.jdbc.core.RowMapper;
import tt.model.City;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CityRowMapper implements RowMapper<City> {

    public City mapRow(final ResultSet resultSet, final int rowIndex) throws SQLException {
        City city = new City();
        city.setId(resultSet.getLong("id"));
        city.setName(resultSet.getString("city_name"));
        return city;
    }
}
