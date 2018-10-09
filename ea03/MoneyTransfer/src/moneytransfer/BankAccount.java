package moneytransfer;

public class BankAccount {

    private final String accountNumber;
    private int balance;
    private final String owner;
    
    public BankAccount(String accountNumber, String owner) {
        this.accountNumber = accountNumber;
        this.owner = owner;
        this.balance = 0;
    }
    
    public String accountNumber() {
        return this.accountNumber;
    }

    public int balance() {
        return this.balance;
    }

    public String owner() {
        return owner;
    }
    
    public synchronized void deposit(int amount) throws NegativeAmountException {
        if(amount < 0) {
            throw new NegativeAmountException();
        }
        balance += amount;
    }
    
    public synchronized void withdraw(int amount) throws NotEnoughMoneyException, NegativeAmountException {
        if(amount < 0) {
            throw new NegativeAmountException();
        }
        if(balance < amount) {
            throw new NotEnoughMoneyException(this, amount);
        }
        balance -= amount;
    }
    
}
