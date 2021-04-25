import java.util.Scanner;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        Bank aBank = new Bank("A-BANK");
        Bank bBank = new Bank("B-BANK");

        int bankChoice;
        int choice;

        do {
            bankChoice = bankMenu(input);
            System.out.println();

            if (bankChoice == 1) {
                do {
                    System.out.println("Welcome to A-BANK");
                    choice = menu(input);
                    System.out.println();

                    if (choice == 1) {
                        createAccount(input, aBank);
                    } else if (choice == 2) {
                        doDeposit(input, aBank);
                    } else if (choice == 3) {
                        doWithdraw(input, aBank);
                    } else if (choice == 4) {
                        checkBalance(input, aBank);
                    } else {
                        System.out.println("GoodBye!");
                    }
                    System.out.println();
                } while (choice != 5);

            } else if (bankChoice == 2) {
                do {
                    System.out.println("Welcome to B-BANK");
                    choice = menu(input);
                    System.out.println();

                    if (choice == 1) {
                        createAccount(input, bBank);
                    } else if (choice == 2) {
                        doDeposit(input, bBank);
                    } else if (choice == 3) {
                        doWithdraw(input, bBank);
                    } else if (choice == 4) {
                        checkBalance(input, bBank);
                    } else {
                        System.out.println("GoodBye!");
                    }
                    System.out.println();
                } while (choice != 5);
            } else {
                System.out.println("GoodBye!");
            }
            System.out.println();
        } while (bankChoice != 3);
    }

    public static void checkBalance(Scanner input, Bank bankName) {
        System.out.print("\nPlease enter account ID: ");
        int accountNumber = input.nextInt();

        int index = searchAccount(bankName, accountNumber);

        int balance = (int) bankName.getCustomers().get(index).getAccount().getBalance();
        System.out.println("Your Current Balance is: " + balance);
    }

    public static int searchAccount(Bank bankName, int customerID) {
        for (int i = 0; i < bankName.getNumberOfCustomers(); i++)
            if (bankName.getCustomers().get(i).getCustomerID() == customerID) {
                return i;
            }

        return -1;
    }

    public static boolean isAccount(Bank bankName, int customerID) {
        for (int i = 0; i < bankName.getNumberOfCustomers(); i++)
            if (bankName.getCustomers().get(i).getCustomerID() == customerID) {
                return true;
            }
        return false;
    }

    //    Method to deposit on a selected account
    public static void doDeposit(Scanner input, Bank bankName) {
        // Get account ID
        System.out.print("\nPlease enter account ID: ");
        int accountNumber = input.nextInt();

        int index = searchAccount(bankName, accountNumber);

        if (index >= 0) {
            System.out.println("Please enter Deposit Amount: ");
            double amount = input.nextDouble();

            if (amount < 0) {
                System.out.println("Please enter a positive number");
            }

            bankName.getCustomers().get(index).getAccount().deposit(amount);

        } else {
            System.out.println("No account exist with Account ID: " + accountNumber);
        }
    }

    //    Method to withdraw on a selected account
    public static void doWithdraw(Scanner input, Bank bankName) {
        // Get account ID
        System.out.print("\nPlease enter account ID: ");
        int accountNumber = input.nextInt();

        int index = searchAccount(bankName, accountNumber);

        if (index >= 0) {
            System.out.println("Please enter Withdraw Amount: ");
            double amount = input.nextDouble();

            if (amount > bankName.getCustomers().get(index).getAccount().getBalance() || amount < 0) {
                System.out.println("Insufficient Balance");
            }

            bankName.getCustomers().get(index).getAccount().withdraw(amount);
        } else {
            System.out.println("No account exist with Account ID: " + accountNumber);
        }
    }

    //    Method to create a new account
    public static void createAccount(Scanner input, Bank bankName) {
        System.out.print("Enter Account ID: ");
        int accountNumber = input.nextInt();
        input.nextLine();

        if (isAccount(bankName, accountNumber)) {
            System.out.println("ID " + accountNumber + " already exist.");
        }

        String fName;
        System.out.print("Enter First Name: ");
        fName = input.nextLine();

        String lName;
        System.out.print("Enter Last Name: ");
        lName = input.nextLine();

        bankName.addCustomer(fName, lName, accountNumber);
        Customer newCustomer = bankName.getCustomers().get(bankName.getNumberOfCustomers() - 1);
        newCustomer.setAccount();

        System.out.println("Account creation successful");
        System.out.println("Welcome " + fName + "!");
        System.out.println("Your account ID is " + accountNumber);
    }

    //    Menu to display options and get user's selection
    public static int menu(Scanner keyboard) {
        System.out.println("Bank Account Menu");
        System.out.println("1. Create New Account");
        System.out.println("2. Deposit Funds");
        System.out.println("3. Withdraw Funds");
        System.out.println("4. Check Balance");
        System.out.println("5. Quit");

        int choice;

        do {
            System.out.print("Enter choice: ");
            choice = keyboard.nextInt();
        } while (choice < 1 || choice > 5);

        return choice;
    }

    //    Menu to choose bank
    public static int bankMenu(Scanner input) {
        System.out.println("Choose a bank");
        System.out.println("1. A-BANK");
        System.out.println("2. B-BANK");
        System.out.println("3. Quit");

        int choice;

        do {
            System.out.println("Enter Choice: ");
            choice = input.nextInt();
        } while (choice < 1 || choice > 3);

        return choice;
    }

}
