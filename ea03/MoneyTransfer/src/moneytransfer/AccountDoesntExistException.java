package moneytransfer;


public class AccountDoesntExistException extends Exception {

    private final String accountNumber;
    public AccountDoesntExistException(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String számlaszám() {
        return this.accountNumber;
    }
    
}
