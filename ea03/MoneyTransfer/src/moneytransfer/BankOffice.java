package moneytransfer;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class BankOffice {
    private final Map<String, BankAccount> accounts;
    
    public BankOffice() {
        this.accounts = new HashMap<>();
    }
    
    public Collection<BankAccount> accounts() {
        return accounts.values();
    }
    
    public void newAccount(BankAccount account) {
        accounts.put(account.accountNumber(), account);
    }
    
    public void deleteAccount(BankAccount account) {
        accounts.remove(account.accountNumber());
    }
    
    public void transfer(String accountOfWithdrawal, String accountOfDeposit, int amount)
            throws NotEnoughMoneyException, AccountDoesntExistException, NegativeAmountException {
        
        BankAccount accOfWithdrawal = accounts.get(accountOfWithdrawal);
        if(accOfWithdrawal == null) {
            throw new AccountDoesntExistException(accountOfWithdrawal);
        }
        BankAccount accOfDeposit = accounts.get(accountOfDeposit);
        if(accOfDeposit == null) {
            throw new AccountDoesntExistException(accountOfDeposit);
        }
        
        accOfWithdrawal.withdraw(amount);
        accOfDeposit.deposit(amount);
    }
    
    public void deposit(String accountOfDeposit, int amount) throws AccountDoesntExistException, NegativeAmountException{
        BankAccount accOfDeposit = accounts.get(accountOfDeposit);
        if(accOfDeposit == null) {
            throw new AccountDoesntExistException(accountOfDeposit);
        }
        accOfDeposit.deposit(amount);
    }
}
