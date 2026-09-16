import java.util.Scanner;

public class BankManagementSystem{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("===== BANKING MANAGEMENT SYSTEM =====");
        

        Bank bank = new Bank();
        try{
            BankAccount account1 = new BankAccount(101, "Sourav", 5000);
            BankAccount account2 = new BankAccount(102, "Rahul", 8000);
    
    
            bank.addAccount(account1);
            bank.addAccount(account2);
        }catch(BankException e){
            System.out.println("Error : " + e.getMessage());
        }

        int choice = 0;
        while(choice != 10){
        System.out.println("===== BANK MENU =====");
        System.out.println("1. Deposit Money");
        System.out.println("2. Withdraw Money");
        System.out.println("3. Check Balance");
        System.out.println("4. View Transactions");
        System.out.println("5. Account Details");
        System.out.println("6. Create Account");
        System.out.println("7. Total Account");
        System.out.println("8. Search Account");
        System.out.println("9. Transfer Money");
        System.out.println("10. Exit");
        System.out.println();

        System.out.print("Enter your choice : ");
        choice = scanner.nextInt();
        System.out.println("You Selected : " + choice);
        System.out.println();

        switch (choice) {
            case 1:{
                System.out.println("===== DEPOSIT MONEY =====");
                System.out.print("Enter Account Number : ");
                int accountNumber = scanner.nextInt();

                System.out.println("Enter Deposit Amount : ");
                double amount = scanner.nextDouble();

                bank.deposit(accountNumber, amount);
                break;
            }
                case 2:{
                    System.out.println("===== WITHDRAW MONEY =====");
                    System.out.print("Enter Account Number : ");
                    int accountNumber = scanner.nextInt();

                    System.out.println("Enter Withdraw Amount : ");
                    double amount = scanner.nextDouble();

                    bank.withdraw(accountNumber, amount);
                    break;
                }
                    case 3:{
                        System.out.println("===== CHECK BALANCE =====");
                        System.out.print("Enter Account Number : ");
                        int accountNumber = scanner.nextInt();
                        
                        System.out.println("Current Balance : " + bank.getBalance(accountNumber));
                        break;
                    }
                        case 4:{
                            System.out.println("===== VIEW TRANSACTIONS =====");
                            System.out.print("Enter Account Number : ");
                            int accountNumber = scanner.nextInt();
                            bank.displayTransactions(accountNumber);
                            break;
                        }
                            case 5:{
                                System.out.println("===== ACCOUNT DETAILS =====");
                                System.out.print("Enter Account Number : ");
                                int accountNumber = scanner.nextInt();
                                
                                bank.displayAccount(accountNumber);
                                break;
                            }
                                case 6:{
                                    System.out.print("Enter Account Number : ");
                                    int accountNumber = scanner.nextInt();
                                    if(bank.accountExists(accountNumber)){
                                        System.out.println("Account Number already exists.");
                                    }else{
                                        System.out.println("===== CREATE ACCOUNT =====");
                                        
                                        System.out.print("Enter Account Holder Name : ");
                                        String name = scanner.next();
                                        System.out.print("Enter initial Balance : ");
                                        double balance = scanner.nextDouble();
                                        
                                        try{
                                            BankAccount account = new BankAccount(accountNumber, name, balance);
                                            bank.addAccount(account);
                                            System.out.println("Account created successfully");
                                        }catch(BankException e){
                                            System.out.println("Error : " + e.getMessage());
                                        }
                                    }
                                    break;

                                }
                                    case 7:{
                                        System.out.println("===== TOTAL ACCOUNTS =====");
                                        System.out.println("Total Accounts : " + bank.getAccountCount());
                                        break;
                                    }
                                        case 8:{
                                            System.out.println("===== SEARCH ACCOUNT =====");

                                            System.out.println("Enter Account Number : ");
                                            int accountNumber = scanner.nextInt();

                                            if(bank.accountExists(accountNumber)){
                                                System.out.println("Account Found");
                                            }else{
                                                System.out.println("Account does not exist");
                                            }
                                            break;
                                        }
                                            case 9:{
                                                System.out.println("===== TRANSFER MONEY =====");

                                                System.out.println("Enter Sender Account Number : ");
                                                int senderAccountNumber = scanner.nextInt();
                                                System.out.println("Enter Reciever Account Number : ");
                                                int receiverAccountNumber = scanner.nextInt();
                                                System.out.println("Enter Transfer Money Amount : ");
                                                double amount = scanner.nextDouble();

                                                bank.transferMoney(senderAccountNumber, receiverAccountNumber, amount);
                                                break;
                                            }
                                                case 10:
                                                    System.out.println("===== EXIT =====");
                                                    break;
            default:
                System.out.println("Invalid choice");
                break;
            }
        }

        

        

        

       
        scanner.close();
    }
}