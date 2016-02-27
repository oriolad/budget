import java.math.BigDecimal;

/**
 * PersonalAccount represents accounts that the belong to the User of the application, for example: credit cards, bank accounts,
 * cash, etc.
 *
 * @author Oriola Dhamo
 */
public class PersonalAccount implements Account {

    String name;
    Type accountType;
    BigDecimal balance;

    public PersonalAccount(String name, Type accountType, BigDecimal balance){
        this.name = name;
        this.accountType = accountType;
        this.balance = balance;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public Type getType(){
        return accountType;
    }

    public void setType(Type accountType){
        this.accountType = accountType;
    }

    public BigDecimal getBalance(){
        return balance;
    }

}
