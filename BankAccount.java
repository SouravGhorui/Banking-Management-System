import java.util.ArrayList;


public class BankAccount {
    private int accountNumber;
    private String accountHolderName;
    private double balance;

    private ArrayList<Transaction> transactions = new ArrayList<>();

    public BankAccount(int accountNumber, String accountHolderName, double balance){
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
    }

    public void deposit(double amount){
        if(amount > 0){
            balance += amount;
            Transaction transaction = new Transaction("DEPOSIT", amount, "Money deposited");
            transactions.add(transaction);
        }else{
            System.out.println("Deposit amount can not be Negative.");
        }
    }

    public void withdraw(double amount){
        if(amount > 0 && amount <= balance){
            balance -= amount;
            Transaction transaction = new Transaction("WITHDRAW", amount, "Money withdrawn");
            transactions.add(transaction);
        }else{
            System.out.println("Withdraw amount can not be less than or equal to zero and greater than balance");
        }
    }

    public void displayTransactions(){
        for(Transaction transaction : transactions){
            transaction.displayTransaction();
        }

    }

    public int getTransactionCount(){
        return transactions.size();
    }
}
