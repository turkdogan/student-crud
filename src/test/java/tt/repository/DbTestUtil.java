package tt.repository;

import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;

import javax.sql.DataSource;

public class DbTestUtil {

    private static DbTestUtil instance = null;

    private DbTestUtil() {
    }

    public static DbTestUtil getInstance() {
        if (instance == null) {
            instance = new DbTestUtil();
        }
        return instance;
    }

    DataSource getMockedDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/create.sql")
                .addScript("db/insert.sql")
                .build();
    }

    DataSource getEmptyDataSource() {
        EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
        return builder
                .setType(EmbeddedDatabaseType.HSQL)
                .addScript("db/create.sql")
                .addScript("db/insert_base_only.sql")
                .build();
    }
}
