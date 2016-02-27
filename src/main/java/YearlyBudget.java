/**
 * Created by Oriola Dhamo on 15-10-06.
 */

import java.sql.*;

public class YearlyBudget {

    public static void main(String args[]) {
        YearlyBudget yearlyBudget = new YearlyBudget();
        yearlyBudget.printBudget();

        Connection connection = yearlyBudget.connectDB();
        yearlyBudget.initDB(connection);
        yearlyBudget.disconnectDB(connection);
    }

    public void printBudget() {
        System.out.println("Yearly Budget Class Finally");
    }

    public Connection connectDB() {
        Connection c = null;

        try {
            Class.forName("org.sqlite.JDBC");
            c = DriverManager.getConnection("jdbc:sqlite:budget.db");
            System.out.println("Successful Database Connection");
            return c;
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
        return null;
    }

    public void disconnectDB(Connection c){
        try{
            c.close();
        }catch (SQLException e) {
            System.err.println("Failed to close connection:");
            System.err.println(e.getMessage());
        }
    }

    public void initDB(Connection c) {

        try{
            Statement stmt = c.createStatement();
            String sqlString = "CREATE TABLE TEST (ID INT PRIMARY KEY NOT NULL)";
            stmt.executeUpdate(sqlString);
            stmt.close();
        } catch (SQLException e) {
            System.err.println(e.getMessage());
        }
    }


}
