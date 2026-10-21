import java.util.ArrayList;
import java.util.List;

public abstract class Account {

     private  String accountNumber;
     private  String accountHolderName;
     private double balance;

     private  double totalDeposits;
     private  double totalWithdrawals;

     private List<String> activity = new ArrayList<>();

    public Account(String accountNumber, String accountHolderName, double balance) {

        if(balance < 0 ){
            throw new IllegalArgumentException("Initial balance cannot be negative.");
        }

        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.balance = balance;

        activity.add("Account opened with "+ balance + "  RwF");
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public double getBalance() {
        return balance;
    }

    public void deposit(double amount){
        if(amount <=0){
            System.out.println("Deposit must be greater than zero.");
            return;
        }

        balance += amount;
        totalDeposits +=amount;

        activity.add("Deposited: " +amount +" RWF");

        System.out.println("Deposit successfully!");
    }

    public void withddraw(double amount){
        if(amount <= 0){
            System.out.println("Withdraw must be greater than zero");
            return;
        }

        if(amount >  balance){
            System.out.println("Insufficient funds. Your balance is " + balance + " RWF");
            return;
        }
        balance -= amount;
        totalWithdrawals += amount;

        activity.add("Withdraw: "+ amount +" RWF");
        System.out.println("Withdrawal successfully!");

    }

    public double calculateCredits(){
        return  totalDeposits + Math.abs(totalWithdrawals);
    }

    public void displayAccountInfo(){
        System.out.println("Account Number: "+ accountNumber);
        System.out.println("Account Holder: "+ accountHolderName);
        System.out.println("Balance: "+balance + " RWF");
        System.out.println("Money Movement: " + calculateCredits() + " RWF");
    }

    public void viewActivity(){
        System.out.println("\n   account activity");

        for(String record : activity){
            System.out.println(record);
        }
    }

    public abstract  double calculateMonthBenefit();
    public abstract double calculateLoanOffer();
}
