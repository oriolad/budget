import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * @author Oriola Dhamo
 */


public class TransactionRecord {

    /**
     * There are currently two types of transactions: debit and credit.
     * Debit transactions increase the balance of the "To" account and decrease the balance of the "From" account.
     * Credit transactions decrease the balance of the "To" account and increase the balance of the "From" account.
     */
    public enum Type{
        DEBIT, CREDIT
    }

    LocalDateTime transactionDate;
    Account from;
    Account to;
    BigDecimal amount;
    Type transactionType;
    String memo;

    /**
     * Constructs a new TransactionRecord given to and from Accounts, as well as the amount and type of transaction.
     * @param from
     * @param to
     * @param amount
     * @param transactionType
     */
    public TransactionRecord(Account from, Account to, BigDecimal amount, Type transactionType){
        transactionDate = LocalDateTime.now();
        this.from = from;
        this.to = to;
        this.amount = amount;
        this.transactionType = transactionType;
    }

    public TransactionRecord(Account from, Account to, BigDecimal amount, Type transactionType, String memo) {
        this(from, to, amount, transactionType);
        this.memo = memo;
    }

}
