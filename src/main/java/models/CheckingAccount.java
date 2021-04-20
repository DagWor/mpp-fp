package models;

public class CheckingAccount extends Account {

    @SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "unused"})
    private double interestRate;

    public CheckingAccount(int accountNumber, double currentBalance, double interestRate) {
        super(accountNumber, currentBalance);
        this.interestRate = interestRate;
    }
}

