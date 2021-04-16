package models;

import java.time.LocalDate;

public class Transactions {

    private  String transactionType;
    private  int fromAccount;
    private int toAccount;
    private double amount;
    private LocalDate date;
    private Teller teller;
    private Account account;

    public Transactions( String transactionType, int fromAccount, int toAccount, double amount, LocalDate date) {
        this.transactionType = transactionType;
        this.fromAccount = fromAccount;
        this.toAccount = toAccount;
        this.amount = amount;
        this.date = date;
    }

    public Teller getTeller() {
        return teller;
    }

    public Account getAccount() {
        return account;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public int getFromAccount() {
        return fromAccount;
    }

    public int getToAccount() {
        return toAccount;
    }


    public double getAmount() {
        return amount;
    }

    public LocalDate getDate() {
        return date;
    }



    public void setTeller(Teller teller) {
        this.teller = teller;
    }

    public void setTransactionType(String transactionType) {
        this.transactionType = transactionType;
    }

    public void setFromAccount(int fromAccount) {
        this.fromAccount = fromAccount;
    }

    public void setToAccount(int toAccount) {
        this.toAccount = toAccount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Transaction Info: " + "Transaction Type: " + transactionType + ", amount: " + getAmount() + ", Amount:" + getAmount() +
                ",From Account:" + getFromAccount() + " ,To Account: " + getToAccount();
    }


}
