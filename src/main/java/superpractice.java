import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Class representing a single Bank Account.
 */
class Account {

    private String accountNumber;
    private String accountHolderName;
    private double balance;

    // Constructor
    public Account(String accountNumber, String accountHolderName, double initialBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = initialBalance;
    }

    // Getters
    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    // Deposit Method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Invalid Deposit Amount");
        }
    }

    // Withdraw Method
    public boolean withdraw(double amount) {

        if (amount > 0 && balance >= amount) {
            balance -= amount;
            return true;
        } else {
            System.out.println("Insufficient Balance");
            return false;
        }
    }

    @Override
    public String toString() {
        return "Account Number: " + accountNumber
                + "\nAccount Holder: " + accountHolderName
                + "\nBalance: $" + balance;
    }
}

/**
 * Bank Manager Class
 */
class BankManager {

    private Map<String, Account> accounts;

    public BankManager() {
        accounts = new HashMap<>();
    }

    // Create Account
    public void createAccount(Account account) {

        if (accounts.containsKey(account.getAccountNumber())) {
            System.out.println("Account Already Exists");
        } else {
            accounts.put(account.getAccountNumber(), account);
            System.out.println("Account Created Successfully");
        }
    }

    // Deposit
    public void deposit(String accountNumber, double amount) {

        Account account = accounts.get(accountNumber);

        if (account != null) {
            account.deposit(amount);

            System.out.println("Deposit Successful");
            System.out.println("New Balance: $" + account.getBalance());

        } else {
            System.out.println("Account Not Found");
        }
    }

    // Withdraw
    public void withdraw(String accountNumber, double amount) {

        Account account = accounts.get(accountNumber);

        if (account != null) {

            if (account.withdraw(amount)) {

                System.out.println("Withdrawal Successful");
                System.out.println("Remaining Balance: $" + account.getBalance());
            }

        } else {
            System.out.println("Account Not Found");
        }
    }

    // Check Balance
    public void checkBalance(String accountNumber) {

        Account account = accounts.get(accountNumber);

        if (account != null) {
            System.out.println(account);
        } else {
            System.out.println("Account Not Found");
        }
    }

    // Display All Accounts
    public void displayAllAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Found");
        } else {

            for (Account acc : accounts.values()) {
                System.out.println("-------------------");
                System.out.println(acc);
            }
        }
    }
}

/**
 * Main Class
 */
public class superpractice {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        BankManager bank = new BankManager();

        int choice;

        do {

            System.out.println("\n===== BANK MANAGEMENT SYSTEM =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter Choice: ");
            choice = input.nextInt();

            switch (choice) {

                case 1:

                    input.nextLine();

                    System.out.print("Enter Account Number: ");
                    String accNo = input.nextLine();

                    System.out.print("Enter Account Holder Name: ");
                    String name = input.nextLine();

                    System.out.print("Enter Initial Balance: ");
                    double balance = input.nextDouble();

                    Account acc = new Account(accNo, name, balance);

                    bank.createAccount(acc);

                    break;

                case 2:

                    input.nextLine();

                    System.out.print("Enter Account Number: ");
                    String depAcc = input.nextLine();

                    System.out.print("Enter Deposit Amount: ");
                    double depAmount = input.nextDouble();

                    bank.deposit(depAcc, depAmount);

                    break;

                case 3:

                    input.nextLine();

                    System.out.print("Enter Account Number: ");
                    String withAcc = input.nextLine();

                    System.out.print("Enter Withdraw Amount: ");
                    double withAmount = input.nextDouble();

                    bank.withdraw(withAcc, withAmount);

                    break;

                case 4:

                    input.nextLine();

                    System.out.print("Enter Account Number: ");
                    String checkAcc = input.nextLine();

                    bank.checkBalance(checkAcc);

                    break;

                case 5:

                    bank.displayAllAccounts();

                    break;

                case 6:

                    System.out.println("Exiting System...");

                    break;

                default:

                    System.out.println("Invalid Choice");
            }

        } while (choice != 6);

        input.close();
    }
}