import javax.sql.DataSource;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Test creation of multiple budget categories.
 *
 * Created by Oriola Dhamo on 2016-01-07.
 */

public class CreateBudget {

    public static void main(String args[]){

        DataSource DS = DataSourceFactory.getSQLITEDataSource();
        try {
            Connection connection = DS.getConnection();

            String sql = new String(Files.readAllBytes(Paths.get("/Users/oriola/Workspace/budget/src/main/resources/sqliteSetup.sql")));

            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        }catch(SQLException e){
            System.out.println(e.getMessage());
        }catch(IOException e){
            System.out.println(e.getMessage());
        }

        // dbConnection.disconnectDB();

    }

}
