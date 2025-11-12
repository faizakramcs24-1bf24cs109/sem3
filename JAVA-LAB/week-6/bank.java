import java.util.Scanner;
abstract class Account {
    
    protected String customerName;
    protected long accountNumber;
    protected String accountType;
    protected double balance;

    
    private static long accountCounter = 1000;

    
    public Account(String name, String type, double initialBalance) {
        this.customerName = name;
        this.accountNumber = ++accountCounter;   // GOOD FOR COUNTING STUFF IN A APROGRAM

        this.accountType = type;
        this.balance = initialBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid deposit amount. Must be positive.");
            return;
        }
        balance += amount;
        System.out.println("Successfully deposited $" + String.format("%.2f", amount));
        displayBalance();
    }

     public void displayBalance() {
        System.out.println("-------------------------------------");
        System.out.println("Account Holder: " + this.customerName);
        System.out.println("Account Number: " + this.accountNumber);
        System.out.println("Account Type:   " + this.accountType);
        System.out.printf("Balance:    %2f  \n ",this.balance);
        System.out.println("-------------------------------------");
    }

    public abstract void computeAndDepositInterest();

   
    public abstract void withdraw(double amount);
}
class Sav_acct extends Account {
     private double interestRate; 
      public Sav_acct(String name, double initialBalance) {
        super(name, "Savings", initialBalance);
         this.interestRate = 5.0; 
    }

     public void computeAndDepositInterest() {
         double monthlyRate = interestRate / 12 / 100;
        double interest = balance * monthlyRate;
        balance += interest;
        System.out.println("Interest of $" + String.format("%.2f", interest) + " credited.");
        System.out.println("New balance after interest: $" + String.format("%.2f", balance));
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal denied.");
        } else {
            balance -= amount;
            System.out.println("Successfully withdrew $" + String.format("%.2f", amount));
            displayBalance();
        }
    }
}

class Cur_acct extends Account {
     private double minBalance;
    private double penalty;
public Cur_acct(String name, double initialBalance) {
        super(name, "Current", initialBalance);
        this.minBalance = 1000.0;
        this.penalty = 100.0;
    }

    public void computeAndDepositInterest() {
        System.out.println("No interest is applicable for Current Accounts.");
    }

    public void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("Invalid withdrawal amount.");
        } else if (amount > balance) {
            System.out.println("Insufficient funds. Withdrawal denied.");
        } else {
             balance -= amount;
            System.out.println("Successfully withdrew $" + String.format("%.2f", amount));

            checkMinimumBalance();
            displayBalance();
        }
    }

     private void checkMinimumBalance() {
        if (balance < minBalance) {
            System.out.println("Warning: Balance is below the minimum of $" + String.format("%.2f", minBalance));
            System.out.println("Applying penalty of $" + String.format("%.2f", penalty));
            balance -= penalty;
            System.out.println("New balance after penalty: $" + String.format("%.2f", balance));
        }
    }
}

public class bank {
    public static void main(String[] args) {
        System.out.println("--- Welcome to the Banking System ---");

        System.out.println("\n*** Creating Savings Account for Alice... ***");
        Account alice = new Sav_acct("Alice Smith", 5000.00);
        alice.displayBalance();

        System.out.println("\n*** Alice deposits $1,000 ***");
        alice.deposit(1000.00);

        System.out.println("\n*** Alice withdraws $2,000 ***");
        alice.withdraw(2000.00);

        System.out.println("\n*** Alice tries to withdraw $5,000 (Insufficient) ***");
        alice.withdraw(5000.00);

        System.out.println("\n*** Computing interest for Alice ***");
        alice.computeAndDepositInterest();

        System.out.println("\n\n*** Creating Current Account for Bob... ***");
        Account bob = new Cur_acct("Bob Johnson", 2000.00);
        bob.displayBalance();

        System.out.println("\n*** Bob deposits $1,000 ***");
        bob.deposit(1000.00);

        System.out.println("\n*** Bob withdraws $500 (No penalty) ***");
        bob.withdraw(500.00); 
        System.out.println("\n*** Bob withdraws $1,600 (Triggers penalty) ***");
         bob.withdraw(1600.00);

        System.out.println("\n*** Computing interest for Bob ***");
        bob.computeAndDepositInterest();
    }
}