
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Transaction {

    public static void addTransaction(int accountId, double amount, String type, String description) throws SQLException {
        try (Connection conn = Database.getConnection()) {
            String query = "INSERT INTO Transactions (account_id, amount, transaction_type, description) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, accountId);
            stmt.setDouble(2, amount);
            stmt.setString(3, type);
            stmt.setString(4, description);
            stmt.executeUpdate();
            System.out.println("Transaction recorded: " + description);
        }
    }

    public static void transferFunds(String fromAccount, String toAccount, double amount) throws SQLException {
        Connection conn = Database.getConnection();
        try {
            conn.setAutoCommit(false);
            
            // Debit from source account
            double fromBalance = Account.getBalance(fromAccount);
            if (fromBalance < amount) {
                System.out.println("Insufficient balance.");
                return;
            }
            Account.updateBalance(fromAccount, fromBalance - amount);
            int fromAccountId = getAccountId(fromAccount);
            addTransaction(fromAccountId, amount, "debit", "Transfer to " + toAccount);

            // Credit to destination account
            double toBalance = Account.getBalance(toAccount);
            Account.updateBalance(toAccount, toBalance + amount);
            int toAccountId = getAccountId(toAccount);
            addTransaction(toAccountId, amount, "credit", "Transfer from " + fromAccount);

            conn.commit();
            System.out.println("Transfer successful!");

        } catch (SQLException e) {
            conn.rollback();
            e.printStackTrace();
        } finally {
            conn.setAutoCommit(true);
            conn.close();
        }
    }

    private static int getAccountId(String accountNumber) throws SQLException {
        int accountId = 0;
        try (Connection conn = Database.getConnection()) {
            String query = "SELECT account_id FROM Accounts WHERE account_number = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, accountNumber);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                accountId = rs.getInt("account_id");
            }
        }
        return accountId;
    }
}
