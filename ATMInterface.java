import java.util.Scanner;

class ATM {
  private double balance;

  ATM() {
    Scanner sc = new Scanner(System.in);
    System.out.print("Enter your pin: ");
    int pin = sc.nextInt();
    UserAccount ua = new UserAccount(pin);
    balance = ua.getAccountBalance();
    double amount;
    boolean running = true;
    while (running) {
      System.out.println("Enter your choice: ");
      System.out.println("1. Withdraw Amount");
      System.out.println("2. Deposit Amount");
      System.out.println("3. Check Account Balance");
      System.out.println("4. Exit");
      int choice = sc.nextInt();
      switch (choice) {
        case 1:
          System.out.println("Enter amount: ");
          amount = sc.nextDouble();
          withdraw(amount);
          break;
        case 2:
          System.out.println("Enter amount: ");
          amount = sc.nextDouble();
          deposit(amount);
          break;
        case 3:
          checkBalance();
          break;
        case 4:
          running = false;
          break;
        default:
          System.out.println("Invalid choice. Please try again.");
      }
    }
  }

  public void withdraw(double amount) {
    if (amount > balance) {
      System.out.println("You have not enough balance.");
      return;
    }
    balance -= amount;
    System.out.println("Successfully withdrawn");
  }

  public void deposit(double amount) {
    balance += amount;
    System.out.println("Successfully deposited");
  }

  public void checkBalance() {
    System.out.println(balance);
  }
}

class UserAccount {
  private final int correctpin = 2654;
  private double accountBalance;

  UserAccount(int pin) {
    if (this.correctpin != pin) {
      System.out.print("Your entered pin is wrong");
      System.exit(0);
    }
    accountBalance = 5000;
  }

  public double getAccountBalance() {
    return accountBalance;
  }

}

public class ATMInterface {
  public static void main(String[] args) {
    new ATM();

  }
}
