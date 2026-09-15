import java.util.ArrayList;

public class Bank {
    private ArrayList<BankAccount> accounts = new ArrayList<>();

    public void addAccount(BankAccount account){
        accounts.add(account);
    }

    public BankAccount getAccount(int accountNumber){
        for(BankAccount account : accounts){
            if(accountNumber == account.getAccountNumber()){
                return account;
            }
        }
        return null;
    }

    public void deposit(int accountNumber, double amount){
        BankAccount account = getAccount(accountNumber);
        if(account != null){
            account.deposit(amount);
        }else{
            System.out.println("Account does not exist");
        }
    }

    public void withdraw(int accountNumber, double amount){
        BankAccount account = getAccount(accountNumber);

        if(account != null){
            account.withdraw(amount);
        }else{
            System.out.println("Account does not exist");
        }
    }

    public void displayTransactions(int accountNumber){
        BankAccount account = getAccount(accountNumber);

        if(account != null){
            account.displayTransactions();
        }else{
            System.out.println("Account does not exist");
        }
    }

    public int getTransactionCount(int accountNumber){
        BankAccount account = getAccount(accountNumber);
        if(account != null){
            return account.getTransactionCount();
        }else{
            System.out.println("Account does not exist");
            return 0;
        }
    }

    public double getBalance(int accountNumber){
        BankAccount account = getAccount(accountNumber);
        if(account != null){
            return account.getBalance();
        }else{
            System.out.println("Account does not exist");
            return 0;
        }
    }

    public String getAccountHolderName(int accountNumber){
        BankAccount account = getAccount(accountNumber);
        if(account != null){
            return account.getAccountHolderName();
        }else{
            System.out.println("Account does not exist");
            return null;
        }
    }

    public boolean accountExists(int accountNumber){
        for(BankAccount account : accounts){
            if(accountNumber == account.getAccountNumber()){
                return true;
            }
        }
        return false;
    }
}


