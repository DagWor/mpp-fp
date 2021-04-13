package models;

public class CheckingAccount extends Account {

    private double interestRate;

    public CheckingAccount(int accountNumber, double currentBalance, double interestRate) {
        super(accountNumber, currentBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(double interestRate) {
        this.interestRate = interestRate;
    }


    @Override
    public double getInterest() {
        return 0;
    }

    public  double viewTransaction()
    {
        return  0;
    }
}

