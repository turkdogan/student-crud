package tt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tt.model.City;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class CityDao implements ICityDao {

    public City findCity(final Long id) {
        String sql = "SELECT * FROM City WHERE id = ?";

        return (City) jdbcTemplate.queryForObject(
                sql, new Object[]{id}, new CityRowMapper());
    }

    public List<City> findAllCities() {
        return this.jdbcTemplate.query("SELECT * FROM City ", new CityRowMapper());
    }

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
