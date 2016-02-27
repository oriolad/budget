import java.math.BigDecimal;
import java.time.Period;

/**
 *
 * Represents a user defined category, e.g. Income, Savings and Expenses such as Housing, Food, Utilities, etc.
 *
 * Created by Oriola Dhamo on 2015-11-22.
 */
public class Category {

    Category parent;
    String name;
    BigDecimal amount;
    Period period;

//    public enum PeriodPreset {
//        WEEKLY(Period.ofWeeks(1)),
//        BIWEEKLY(Period.ofWeeks(2)),
//        MONTHLY(Period.ofMonths(1)),
//        YEARLY(Period.ofYears(1));
//
//        private final Period period;
//
//        PeriodPreset(Period period){
//            this.period = period;
//        }
//
//        Period getPeriod(){
//            return period;
//        }
//    }

    public Category(String name, Period period, BigDecimal amount, Category parent){
        this.name = name;
        this.period = period;
        this.amount = amount;
        this.parent = parent;
    }

//    public BigDecimal getPeriodAmount(PeriodPreset periodPreset){
//        return getPeriodAmount(periodPreset.getPeriod());
//    }

    public String getName(){
        return name;
    }

    public Period getPeriod(){
        return period;
    }

    public BigDecimal getAmountGivenPeriod(Period targetPeriod){
        BigDecimal originalPeriod = new BigDecimal(String.valueOf(period));
        BigDecimal givenPeriod = new BigDecimal(String.valueOf(targetPeriod));

        BigDecimal periodRatio = givenPeriod.divide(originalPeriod);

        return amount.divide(periodRatio);
    }

    public BigDecimal getAmount(){
        return amount;
    }

    public Category getParent(){
        return parent;
    }


}
