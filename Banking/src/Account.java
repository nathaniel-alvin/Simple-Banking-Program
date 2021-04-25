public class Account {
    private double balance;

    public Account() {this.balance= 0;}
    public Account(double balance) {
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean deposit(double amount) {
        if (amount <= 0) return false;
        balance += amount;
        return true;
    }

    public boolean withdraw(double amount) {
        if(amount > balance || amount == 0) return false;
        balance -= amount;
        return true;
    }
}

