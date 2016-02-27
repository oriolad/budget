import org.sqlite.SQLiteDataSource;

import javax.sql.DataSource;
import java.sql.Connection;

/**
 * A factory class to get DataSource.
 *
 * Created by Oriola Dhamo on 2016-01-07.
 */
public class DataSourceFactory {

    public static DataSource getSQLITEDataSource(){
        SQLiteDataSource sqliteDS = null;
        String url = "jdbc:sqlite:BUDGET_CATEGORIES.db";

        sqliteDS = new SQLiteDataSource();
        sqliteDS.setUrl(url);

        return sqliteDS;
    }

}
