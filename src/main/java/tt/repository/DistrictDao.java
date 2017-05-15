package tt.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import tt.model.City;
import tt.model.District;

import javax.sql.DataSource;
import java.util.List;

@Repository
public class DistrictDao implements IDistrictDao {

    public List<District> findDistrictsForCity(final City city) {
        return this.jdbcTemplate.query("SELECT * FROM District where city_id = ? ", new Long[]{city.getId()}, new DistrictRowMapper());
    }

    public District findDistrict(final Long id) {
        String sql = "SELECT * FROM District WHERE id = ?";

        return (District) jdbcTemplate.queryForObject(
                sql, new Object[]{id}, new DistrictRowMapper());
    }

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }
}
