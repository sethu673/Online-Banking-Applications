Online Banking Application


An Online Banking Application built with Java and JDBC that enables users to manage their bank accounts digitally. The application provides essential banking features such as account management, secure fund transfers, transaction history tracking, and account balance inquiry.


Table of Contents:-

1)Project Overview

2)Features

3)Technologies Used

4)Database Design

5)Installation

6)Usage

7)Contributing

8)License

Project Overview:-

This Online Banking Application simulates basic banking operations for individual users, offering a secure, user-friendly platform to handle financial transactions and manage bank accounts. The project aims to provide experience in building real-world applications with Java and JDBC, highlighting the importance of data security and database integration.

Features:-

Account Management: Register, update, and delete user accounts.

Fund Transfers: Transfer funds between accounts, both within and outside the bank, with secure verification.

Transaction History: View and filter detailed transaction records, including deposits, withdrawals, and transfers.

Account Balance Inquiry: Check account balance and recent transactions in real-time.

Technologies Used:-

Java: Core programming language for application logic.

JDBC (Java Database Connectivity): Interface for connecting Java to the MySQL database.

MySQL: Database for storing user accounts, transactions, and related information.

Swing/AWT (optional): For the graphical user interface (GUI), if applicable.

Database Design:-

Tables

Accounts

Columns: account_id, customer_name, address, contact_number, email, account_balance, account_type, creation_date
Transactions

Columns: transaction_id, account_id, transaction_type (Deposit, Withdrawal, Transfer), amount, transaction_date, recipient_account (for transfers)
Users

Columns: user_id, username, password, role (Admin, Customer)
Fund Transfers

Columns: transfer_id, from_account_id, to_account_id, amount, transfer_date.

Installation:-

Prerequisites

Java Development Kit (JDK): Version 8 or higher.

MySQL: Ensure MySQL server is installed and running.

IDE: Any Java IDE like Eclipse, IntelliJ IDEA, or NetBeans.

Steps:-

Clone this repository to your local machine:

git clone https://github.com/your-username/online-banking-application.git

Open the project in your preferred IDE.

Set up the MySQL database:

Create a new database named online_banking.

Run the SQL scripts provided in the database folder to create tables and insert sample data.

Update the database connection parameters in the code:

Modify the JDBC URL, username, and password in the configuration file or connection class to match your local MySQL setup.

Run the application from your IDE.

Usage:-

Login: Use admin or customer credentials to access different levels of functionalities.

Account Management: Manage your personal details or create/delete accounts (admin only).

Fund Transfers: Transfer funds by entering the recipient’s account information and amount.

Transaction History: View or filter past transactions.

Balance Inquiry: Check your current balance and latest transactions.

Contributing:-

Contributions are welcome! Please fork this repository, make your changes, and submit a pull request. Ensure code quality and follow naming conventions.

License:-

This project is licensed under the MIT License. See the LICENSE file for details.

Screenshots (Optional):-

You can add screenshots of the application screens here to give users a visual idea of the project.

