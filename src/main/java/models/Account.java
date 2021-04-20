package models;

import java.util.ArrayList;
import java.util.List;

public  abstract class Account {

    private final int accountNumber;
    @SuppressWarnings("FieldMayBeFinal")
    private double currentBalance;
    private Customer customer;
    private List<Transactions> transactionList;

    public Account(int accountNumber, double currentBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
        transactionList = new ArrayList<>();
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Transactions> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transactions> transactionList) {
        this.transactionList = transactionList;
    }

    @Override
    public String toString() {
        return "Account Info: " + "Account Number: " + getAccountNumber()+ ", Current Balance: " + getCurrentBalance() ;
    }
}
