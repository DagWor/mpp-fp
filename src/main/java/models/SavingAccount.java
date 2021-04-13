package models;

public class SavingAccount extends  Account{

    private double interestRate;

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }

    public SavingAccount(int accountNumber, double currentBalance, double interestRate) {
        super(accountNumber, currentBalance);
        this.interestRate = interestRate;
    }

    @Override
    public double getInterest() {
        return 0;
    }

    public  double viewTransactions()
    {
        return  0;
    }
}
