import java.sql.SQLException;
import java.util.Scanner;

public class BankApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Welcome to the Online Banking System!");
            System.out.println("1. Create Account");
            System.out.println("2. Check Balance");
            System.out.println("3. Transfer Funds");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter account holder name: ");
                    String name = scanner.next();
                    System.out.print("Enter account number: ");
                    String accNum = scanner.next();
                    System.out.print("Enter initial balance: ");
                    double balance = scanner.nextDouble();
                    System.out.print("Enter account type: ");
                    String type = scanner.next();
                    Account.createAccount(name, accNum, balance, type);
                    break;

                case 2:
                    System.out.print("Enter account number: ");
                    String accNumToCheck = scanner.next();
                    double currentBalance = Account.getBalance(accNumToCheck);
                    System.out.println("Current Balance: " + currentBalance);
                    break;

                case 3:
                    System.out.print("Enter source account number: ");
                    String fromAcc = scanner.next();
                    System.out.print("Enter destination account number: ");
                    String toAcc = scanner.next();
                    System.out.print("Enter transfer amount: ");
                    double transferAmount = scanner.nextDouble();
                    Transaction.transferFunds(fromAcc, toAcc, transferAmount);
                    break;

                default:
                    System.out.println("Invalid choice.");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            scanner.close();
        }
    }
}
