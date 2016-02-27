import java.math.BigDecimal;
import java.time.Period;
import java.util.List;

/**
 * This interface defines the standard Data Access operations to be performed on the Category object.
 *
 * Created by Oriola Dhamo on 2016-01-07.
 */

public interface CategoryDAO {

    // create
    public void insertCategory(Category category);

    // read
    Category selectCategoryByName(String name);
    List<Category> selectCategoryByPeriod(Period period);
    List<Category> selectCategoryByAmount(BigDecimal amount);
    List<Category> selectCategoryByParent(Category parentCategory);
    List<Category> selectAllCategories();

    // update
    void updateCategory(Category category);

    // delete
    void deleteCategory(Category category);
}
