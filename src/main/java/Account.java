import java.math.BigDecimal;

/**
 *
 * @author Oriola Dhamo
 */

public interface Account {

    public enum Type{
        CASH, DEBT
    }

    String getName();

    void setName(String name);

    Type getType();

    void setType(Type accountType);

    BigDecimal getBalance();

}
