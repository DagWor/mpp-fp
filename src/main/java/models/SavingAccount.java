package models;

public class SavingAccount extends  Account{

    @SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "unused"})
    private double interestRate;

    public SavingAccount(int accountNumber, double currentBalance, double interestRate) {
        super(accountNumber, currentBalance);
        this.interestRate = interestRate;
    }
}
