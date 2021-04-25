public class Customer {
    private final String firstName;
    private final String lastName;
    private final int customerID;
    private Account account;

    public Customer(String firstName, String lastName, int customerID) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.customerID = customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getCustomerID() { return customerID; }

    public Account getAccount() {
        return account;
    }

    public void setAccount() { this.account = new Account(); }
}
