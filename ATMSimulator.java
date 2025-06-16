import java.util.Scanner;

public class ATMSimulator {
    private static int balance = 10000;
    private static final int PIN = 1234;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your ATM PIN: ");
        int enteredPin = scanner.nextInt();  // Corrected variable name

        if (enteredPin != PIN) {
            System.out.println("Incorrect PIN! Exiting...");
            return;
        }

        int choice;
        do {
            System.out.println("\n=== ATM MENU ===");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    deposit(scanner);
                    break;
                case 3:
                    withdraw(scanner);
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }

        } while (choice != 4);

        scanner.close();
    }

    // ✅ These methods are now placed **outside** main()

    private static void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private static void deposit(Scanner scanner) {
        System.out.print("Enter amount to deposit: $");
        int amount = scanner.nextInt();
        if (amount > 0) {
            balance += amount;
            System.out.println("$" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid amount.");
        }
    }

    private static void withdraw(Scanner scanner) {
        System.out.print("Enter amount to withdraw: $");
        int amount = scanner.nextInt();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Please collect your cash: $" + amount);
        } else {
            System.out.println("Insufficient balance or invalid amount.");
        }
    }
}
