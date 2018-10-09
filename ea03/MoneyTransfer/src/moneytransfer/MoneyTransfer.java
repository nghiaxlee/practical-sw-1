package moneytransfer;

public class MoneyTransfer {

    public static void main(String[] args) throws AccountDoesntExistException, NotEnoughMoneyException, NegativeAmountException {
        BankOffice office = new BankOffice();
        
        office.newAccount(new BankAccount("12345678", "Tom Novy"));
        office.newAccount(new BankAccount("87654321", "John Doe"));
        office.newAccount(new BankAccount("12348765", "Jane Doe"));
        office.deposit("12345678", 100000);
        office.deposit("87654321", 150000);
        office.deposit("12348765", 170000);
        printBalances(office, "initially");
        
        office.transfer("12345678", "87654321", 57891);
        printBalances(office, "from 12345678 to 87654321 after transferring 57891");
        
        office.transfer("87654321", "12345678", 57891);
        printBalances(office, "from 87654321 to 12345678  after transferring 57891");
        
        try{
            office.transfer("87654321", "12348765", 500000);
        }catch(NotEnoughMoneyException e) {
            System.out.println("Not enough money.");
            System.out.println("");
        }
        
        printBalances(office, "after transfer cancelled due to not enough money");
    }
    
    private static void printBalances(BankOffice office, String address) {
        System.out.println(address);
        System.out.println("----------------------------");
        office.accounts().forEach(
            (account) -> {
                 System.out.println(account.owner() + "\t" + account.accountNumber() +
                         ": " + account.balance());
            }
        );
        System.out.println();
    }
    
}
