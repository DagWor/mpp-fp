package models;

import java.util.List;

public  abstract class Account {

    private  int accountNumber;
    private double currentBalance;
    private Customer customer;
    private List<Transactions> transactionList;

    public Account(int accountNumber, double currentBalance) {
        this.accountNumber = accountNumber;
        this.currentBalance = currentBalance;
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

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Transactions> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<Transactions> transactionList) {
        this.transactionList = transactionList;
    }

    //abstract methods

    public abstract double getInterest();

    @Override
    public String toString() {
        return "Account Info: " + "Account Number: " + getAccountNumber()+ ", Current Balance: " + getCurrentBalance() ;
    }
}
