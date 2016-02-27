import java.math.BigDecimal;

/**
 * Created by oriola on 2015-11-22.
 */
public class CounterpartyAccount implements Account {

    String name;
    Type accountType;
    BigDecimal balance;

    public CounterpartyAccount(String name, Type accountType, BigDecimal balance){
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
