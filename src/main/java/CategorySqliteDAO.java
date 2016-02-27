import javax.sql.DataSource;
import javax.xml.transform.Result;
import java.math.BigDecimal;
import java.sql.*;
import java.time.Period;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Maintains connection to database.
 * <p/>
 * Created by Oriola Dhamo on 2016-01-07.
 */

public class CategorySqliteDAO implements CategoryDAO {

    private Connection connection = null;

    public CategorySqliteDAO() {
        DataSource DS = DataSourceFactory.getSQLITEDataSource();

        try {
            connection = DS.getConnection();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void runUpdate(String sql) {
        try {
            Statement stmt = connection.createStatement();
            stmt.executeUpdate(sql);
            stmt.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public ResultSet runQuery(String sql) {

        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            stmt.close();
            return rs;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    // create
    public void insertCategory(Category category) {

        String parent = category.getParent().getName();
        String name = category.getName();
        String period = category.getPeriod().toString();
        String amount = category.getAmount().toString();


        String sql = "INSERT INTO BUDGET_CATEGORIES " +
                "(PARENT_CATEGORY, CATEGORY_NAME, CATEGORY_PERIOD, AMOUNT) " +
                "VALUES (%s, %s, %s, %s);";
        sql = String.format(sql, parent, name, period, amount);
        runUpdate(sql);

    }

    // read
    public Category selectCategoryByName(String name) throws DAOException {

        String sql = "SELECT * FROM BUDGET_CATEGORIES WHERE CATEGORY_NAME = '%s'";
        sql = String.format(sql, name);
        ResultSet rs = runQuery(sql);

        try {
            while (rs.next()) {
                String name = rs.getString("CATEGORY_NAME");
                Period period = new Period.parse((CharSequence) rs.getString("CATEGORY_PERIOD"));
            }
        } catch (SQLException e) {
            throw new DAOException(e);
        }
    }

    public List<Category> selectCategoryByPeriod(Period period) {
        String periodString = period.toString();

        String sql = "SELECT * FROM BUDGET_CATEGORIES WHERE CATEGORY_NAME = '%s'";
        sql = String.format(sql, periodString);
        runQuery(sql);
    }

    public List<Category> selectCategoryByAmount(BigDecimal amount);

    public List<Category> selectCategoryByParent(Category parentCategory);

    public List<Category> selectAllCategories();

    // update
    public void updateCategory(Category category);

    // delete
    public void deleteCategory(Category category);


}
