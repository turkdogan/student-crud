
package tt.repository;

import org.springframework.jdbc.core.RowMapper;
import tt.model.District;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistrictRowMapper implements RowMapper<District> {

    public District mapRow(final ResultSet resultSet, final int rowIndex) throws SQLException {
        District district = new District();
        district.setId(resultSet.getLong("id"));
        district.setName(resultSet.getString("district_name"));
        return district;
    }
}
