package in;

import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {

    String accountHolder;
    int accountNumber;
    double balance;
    ArrayList<String> history = new ArrayList<>();

    // Constructor
    BankAccount(String name, double initialBalance) {
        accountHolder = name;
        balance = initialBalance;
        accountNumber = (int)(Math.random() * 100000);

        history.add("Account Created with Balance: " + initialBalance);
    }

    // Deposit
    void deposit(double amount) {
        balance += amount;
        history.add("Deposited: " + amount);
        System.out.println("₹" + amount + " Deposited Successfully");
    }

    // Withdraw
    void withdraw(double amount) {

        if(amount <= balance) {
            balance -= amount;
            history.add("Withdrawn: " + amount);
            System.out.println("₹" + amount + " Withdrawal Successful");
        } 
        else {
            System.out.println("Insufficient Balance");
        }
    }

    // Check Balance
    void checkBalance() {
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Current Balance: ₹" + balance);
    }

    // Transaction History
    void showHistory() {
        System.out.println("\nTransaction History:");
        for(String h : history) {
            System.out.println(h);
        }
    }
}

public class BankAccountSimulator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Account Holder Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        BankAccount account = new BankAccount(name, balance);

        int choice;

        do {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Deposit Money");
            System.out.println("2. Withdraw Money");
            System.out.println("3. Check Balance");
            System.out.println("4. Transaction History");
            System.out.println("5. Exit");

            System.out.print("Enter Choice: ");
            choice = sc.nextInt();

            switch(choice) {

                case 1:
                    System.out.print("Enter Amount to Deposit: ");
                    double deposit = sc.nextDouble();
                    account.deposit(deposit);
                    break;

                case 2:
                    System.out.print("Enter Amount to Withdraw: ");
                    double withdraw = sc.nextDouble();
                    account.withdraw(withdraw);
                    break;

                case 3:
                    account.checkBalance();
                    break;

                case 4:
                    account.showHistory();
                    break;

                case 5:
                    System.out.println("Thank you for using the Bank System!");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while(choice != 5);

        sc.close();
    }
}