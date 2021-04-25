import java.util.ArrayList;

public class Bank {
    private java.util.ArrayList<Customer> customers = new java.util.ArrayList<>();
    private int numberOfCustomers = 0;
    private final String bankName ;

    public Bank(String bankName) {
        this.bankName = bankName;
    }

    public void addCustomer(String firstName, String lastName, int customerID) {
        customers.add(new Customer(firstName, lastName, customerID));
        numberOfCustomers++;
    }

    public int getNumberOfCustomers() {
        return numberOfCustomers;
    }

    public ArrayList<Customer> getCustomers() {
        return customers;
    }
}
