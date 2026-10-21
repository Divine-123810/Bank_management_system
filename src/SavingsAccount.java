public class SavingsAccount extends  Account{

    public SavingsAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public double calculateMonthBenefit() {
        return addMonthlyBenefits(0.02);
    }

    @Override
    public double calculateLoanOffer() {
        if (getBalance() >= 35000) {
            return getBalance() * 0.05;
        }

        return 0;
    }
}
