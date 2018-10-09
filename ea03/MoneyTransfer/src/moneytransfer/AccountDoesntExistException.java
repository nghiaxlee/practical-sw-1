package moneytransfer;


public class AccountDoesntExistException extends Exception {

    private final String accountNumber;
    public AccountDoesntExistException(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    public String sz�mlasz�m() {
        return this.accountNumber;
    }
    
}
