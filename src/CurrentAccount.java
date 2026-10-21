public class CurrentAccount extends Account{

    public CurrentAccount(String accountNumber, String accountHolderName, double balance) {
        super(accountNumber, accountHolderName, balance);
    }

    @Override
    public double calculateMonthBenefit() {
        return addMonthlyBenefits(0.01);
    }

    @Override
    public double calculateLoanOffer() {
        if(calculateCredits() > 20000){
            return getBalance() * 0.10;
        }
        return 0;
    }
}
