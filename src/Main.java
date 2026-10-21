//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


import java.util.Scanner;
void main() {



            Scanner input = new Scanner(System.in);

            System.out.println("===== JAVA BANKING SYSTEM =====");
            System.out.println("1. Savings Account");
            System.out.println("2. Current Account");

            int type = readInt(input, "Choose account type: ");

            System.out.print("Enter account number: ");
            String number = input.nextLine();

            System.out.print("Enter account holder name: ");
            String name = input.nextLine();

            double initialBalance =
                    readDouble(input, "Enter initial balance (RWF): ");

            while (initialBalance < 0) {
                System.out.println("Balance cannot be negative.");
                initialBalance =
                        readDouble(input, "Enter initial balance (RWF): ");
            }

            Account account;

            if (type == 1) {
                account = new SavingsAccount(
                        number, name, initialBalance);
            } else {
                account = new CurrentAccount(
                        number, name, initialBalance);
            }

            int choice;

            do {
                System.out.println("\n===== BANK MENU =====");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Check Balance");
                System.out.println("4. View Account Activity");
                System.out.println("5. Calculate Money Movement");
                System.out.println("6. Request Loan");
                System.out.println("7. Apply Monthly Benefit");
                System.out.println("8. Account Details");
                System.out.println("9. Exit");

                choice = readInt(input, "Choose an option: ");

                switch (choice) {

                    case 1:
                        double deposit =
                                readDouble(input, "Enter deposit amount: ");
                        account.deposit(deposit);
                        break;

                    case 2:
                        double withdrawal =
                                readDouble(input, "Enter withdrawal amount: ");
                        account.withdraw(withdrawal);
                        break;

                    case 3:
                        System.out.println(
                                "Balance: " + account.getBalance() + " RWF");
                        break;

                    case 4:
                        account.viewActivity();
                        break;

                    case 5:
                        System.out.println(
                                "Total money movement: "
                                        + account.calculateCredits() + " RWF");
                        break;

                    case 6:
                        double loan = account.calculateLoanOffer();

                        if (loan > 0) {
                            System.out.println(
                                    "You qualify for a loan offer of "
                                            + loan + " RWF");
                        } else {
                            System.out.println(
                                    "Sorry, you do not qualify for a loan.");
                        }
                        break;

                    case 7:
                        double benefit =
                                account.calculateMonthBenefit();

                        System.out.println(
                                "Monthly benefit added: "
                                        + benefit + " RWF");

                        System.out.println(
                                "New balance: "
                                        + account.getBalance() + " RWF");
                        break;

                    case 8:
                        account.displayAccountInfo();
                        break;

                    case 9:
                        System.out.println(
                                "Thank you for using our banking system.");
                        break;

                    default:
                        System.out.println(
                                "Invalid choice. Please select 1 to 9.");
                }

            } while (choice != 9);

            input.close();
        }

        private static int readInt(Scanner input, String message) {
            while (true) {
                try {
                    System.out.print(message);
                    return Integer.parseInt(input.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Please enter a whole number.");
                }
            }
        }

        private static double readDouble(Scanner input, String message) {
            while (true) {
                try {
                    System.out.print(message);

                    double amount = Double.parseDouble(input.nextLine());

                    if (Double.isNaN(amount) || Double.isInfinite(amount)) {
                        System.out.println("Enter a valid amount.");
                        continue;
                    }

                    return amount;

                } catch (NumberFormatException e) {
                    System.out.println("Please enter a valid number.");
                }
            }
        }



