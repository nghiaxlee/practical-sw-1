package moneytransfer;


public class NotEnoughMoneyException extends Exception {

    private final BankAccount account;
    private final int amount;
    
    public NotEnoughMoneyException(BankAccount account, int amount) {
        this.account = account;
        this.amount = amount;
    }

    public BankAccount account() {
        return account;
    }

    public int amount() {
        return amount;
    }
    
    
    
}
