import java.util.ArrayList;


public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    private ArrayList<Transaction> transactions = new ArrayList<>();

    public BankAccount(int accountNumber, String accountHolderName, double balance) throws BankException{
        if(accountNumber <= 0){
            throw new BankException("Account Number Must be greater than 0");
        }

        if(accountHolderName == null || accountHolderName.trim().isEmpty()){
            throw new BankException("Account Holder Name can not be empty");
        }
        
        if(balance < 0){
           throw new BankException("Balance can not be negative");
        }
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;
    }

    public int getAccountNumber(){
        return accountNumber;
    }

    public String getAccountHolderName(){
        return accountHolderName;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount){
        if(amount >= 0){
            balance = amount;
        }else{
            System.out.println("Balance can not be negative");
        }
    }

    public void displayAccount(){
        System.out.println("Account Number : " + accountNumber);
        System.out.println("Account Holder : " + accountHolderName);
        System.out.println("Balance : " + balance);
        System.out.println("Total Transaction : " + transactions.size());
    }

    public void deposit(double amount) throws BankException{
        if(amount > 0){
            balance += amount;
            Transaction transaction = new Transaction("DEPOSIT", amount, "Money deposited");
            transactions.add(transaction);
        }else{
            throw new BankException("Deposit amount must be greater than 0");
        }
    }

    public void withdraw(double amount) throws BankException{
        if(amount > 0 && amount <= balance){
            balance -= amount;
            Transaction transaction = new Transaction("WITHDRAW", amount, "Money withdrawn");
            transactions.add(transaction);
        }else{
            throw new BankException("Withdraw amount must be greater than 0 and less than or equal to balance");
        }
    }

    public void displayTransactions(){
        if(transactions.isEmpty()){
            System.out.println("No transactions found.");
            return;
        }

        for(Transaction transaction : transactions){
            transaction.displayTransaction();
        }

    }

    public int getTransactionCount(){
        return transactions.size();
    }

    public void addTransaction(Transaction transaction){
         transactions.add(transaction);
    }
}
