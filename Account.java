
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Account {
    public static void createAccount(String holderName, String accountNumber, double initialBalance, String accountType) throws SQLException {
        try (Connection conn = Database.getConnection()) {
            String query = "INSERT INTO Accounts (account_holder_name, account_number, balance, account_type) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, holderName);
            stmt.setString(2, accountNumber);
            stmt.setDouble(3, initialBalance);
            stmt.setString(4, accountType);
            stmt.executeUpdate();
            System.out.println("Account created successfully!");
        }
    }

    public static double getBalance(String accountNumber) throws SQLException {
        double balance = 0.0;
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT balance FROM Accounts WHERE account_number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                balance = rs.getDouble("balance");
            }
        }
        return balance;
    }

    public static void updateBalance(String accountNumber, double newBalance) throws SQLException {
        try (Connection conn = Database.getConnection()) {
            String query = "UPDATE Accounts SET balance = ? WHERE account_number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setDouble(1, newBalance);
            stmt.setString(2, accountNumber);
            stmt.executeUpdate();
            System.out.println("Balance updated successfully!");
        }
    }
}

