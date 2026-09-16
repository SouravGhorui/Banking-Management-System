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

    public void displayAccount(int accountNumber){
        BankAccount account = getAccount(accountNumber);

        if(account != null){
            account.displayAccount();
        }else{
            System.out.println("Account does not exist");
        }
    }

    public void deposit(int accountNumber, double amount){
        BankAccount account = getAccount(accountNumber);
        if(account != null){
            try{
                account.deposit(amount);
            }catch(BankException e){
                System.out.println("Error : " + e.getMessage());
            }
        }else{
            System.out.println("Account does not exist");
        }
    }

    public void withdraw(int accountNumber, double amount){
        BankAccount account = getAccount(accountNumber);

        if(account != null){
            try{
                account.withdraw(amount);
            }catch(BankException e){
                System.out.println("Error : " + e.getMessage());
            }
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

    public int getAccountCount(){
        return accounts.size();
    }

    public void transferMoney(int senderAccountNumber, int recieverAccountNumber, double amount){
        BankAccount sender = getAccount(senderAccountNumber);
        BankAccount reciever = getAccount(recieverAccountNumber);

        if(sender == null){
            System.out.println("Sender account does not exist.");
            return ;
        }

        if(reciever == null){
            System.out.println("Reciever account does not exist");
            return ;
        }

        if(amount <= 0){
            System.out.println("Transfer money amount must be greater than 0");
            return ;
        }

        if(amount > getBalance(senderAccountNumber)){
            System.out.println("Insufficient balance");
            return ;
        }

        try{
            sender.withdraw(amount);
            reciever.deposit(amount);
            System.out.println("Monet transfered successfully");
        }catch(BankException e){
            System.out.println("Error : " + e.getMessage());
        }
    }
}


