package services;

import models.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;


public class LoadData1 {
    public static HQ hq;
    public static Branch branch;
    public static Branch branch1;
    public static User admin;
    public static User teller;
    public static User teller1;
    public static User customer;
    public static User customer1;
    public static User customer2;
    public static Account account;
    public static Account account1;
    public static Account account2;
    public static Transactions transactions;
    public static Transactions transactions1;
    public static Transactions transactions2;
    public static Transactions transactions3;
    public static Transactions transactions4;
    public static Transactions transactions5;
    public static Transactions transactions6;
    public static Transactions transactions7;
    public static Transactions transactions8;
    public static Transactions transactions9;
    public static Transactions transactions10;
    public static Transactions transactions11;
    public static Transactions transactions12;
    public static Transactions transactions13;
    public static Transactions transactions14;

    public static void testDataOne(){
        Address address = new Address("1000 N. 4th street","Fairfield",0101,0101,"IOWA","USA");
        hq = new HQ("TrustBank", LocalDate.of(2000,01,01),address);
        branch = new Branch("First", LocalDate.of(2005,01,01),address);
        branch1 = new Branch("Second", LocalDate.of(2006,01,01), address);

        admin = new Admin(10000, "admin", "xyz@gmail.com", "John", "Doe", address);
        teller = new Teller(10000, "teller", "teller@gmail.com", "Alice", "Doe", address);
        teller1 = new Teller(50000, "teller1", "teller1@gmail.com", "Bob", "Alice", address);
        customer = new Customer("customer", "customer@gmail.com", "Susan", "Doe", address);
        customer1 = new Customer("customer1", "customer@gmail.com", "Dadi", "Doe", address);

        account = new SavingAccount(123, 100000, 5.5);
        account1 = new CheckingAccount(321, 25410.2, 7.5);

        hq.setBranch(List.of(branch,branch1));
        branch.setUsers(List.of(admin, teller,customer,customer1));

        Customer _customer = (Customer)customer;
        Customer _customer1 = (Customer)customer1;

        _customer.setAccount(account);
        //_customer.setAccountList(List.of(account1));

        // _customer1.setAccount(account);
        _customer1.setAccount(account1);

        account.setCustomer(_customer);
        account1.setCustomer(_customer1);
    }

    public static void transactionLoader(){
        LoadData1.testDataOne();

        transactions = new Transactions("WITHDRAW", 123, 0, 3000.0, LocalDate.of(2021, 5, 2));
        transactions1 = new Transactions("WITHDRAW", 321, 0, 500.0, LocalDate.of(2021, 4, 2));

        transactions2 = new Transactions("WITHDRAW", 123, 0, 200.0, LocalDate.of(2021, 5, 2));
        transactions3 = new Transactions("WITHDRAW", 321, 0, 100.0, LocalDate.of(2021, 4, 2));

        transactions4 = new Transactions("WITHDRAW", 123, 0, 400.0, LocalDate.of(2021, 4, 2));
        transactions5 = new Transactions("WITHDRAW", 321, 0, 250.0, LocalDate.of(2021, 3, 2));

        transactions6 = new Transactions("WITHDRAW", 123, 0, 1000.0, LocalDate.of(2021, 4, 2));
        transactions7 = new Transactions("WITHDRAW", 321, 0, 1500.0, LocalDate.of(2021, 5, 2));

        transactions8 = new Transactions("DEPOSIT", 0, 123, 1000.0, LocalDate.of(2021, 4, 2));
        transactions9 = new Transactions("DEPOSIT", 0, 321, 1500.0, LocalDate.of(2021, 5, 2));

        transactions10 = new Transactions("DEPOSIT", 0, 123, 200.0, LocalDate.of(2019, 5, 2));
        transactions11 = new Transactions("DEPOSIT", 0, 321, 100.0, LocalDate.of(2019, 4, 2));

        transactions12 = new Transactions("DEPOSIT", 0, 123, 400.0, LocalDate.of(2020, 4, 2));
        transactions13 = new Transactions("DEPOSIT", 0, 321, 250.0, LocalDate.of(2020, 3, 2));

        transactions13 = new Transactions("DEPOSIT", 0, 123, 1000.0, LocalDate.of(2021, 4, 2));
        transactions14 = new Transactions("DEPOSIT", 0, 321, 1500.0, LocalDate.of(2021, 5, 2));

        account.setTransactionList(Arrays.asList(transactions,transactions2,transactions5,transactions7,transactions9,transactions11,transactions13));
        account1.setTransactionList(Arrays.asList(transactions1,transactions3,transactions4,transactions6,transactions8,transactions10,transactions12,transactions14));
    }

    public static void SetTeller(){
        LoadData1.testDataOne();

        Teller _teller = (Teller)teller;
        Teller _teller1 = (Teller)teller1;

        transactions1.setTeller(_teller1);
        transactions2.setTeller(_teller);
        transactions3.setTeller(_teller1);
        transactions4.setTeller(_teller);
        transactions5.setTeller(_teller1);
        transactions6.setTeller(_teller);
        transactions7.setTeller(_teller);
        transactions8.setTeller(_teller1);
        transactions9.setTeller(_teller);
        transactions10.setTeller(_teller);
        transactions11.setTeller(_teller);
        transactions12.setTeller(_teller1);
        transactions13.setTeller(_teller);
        transactions14.setTeller(_teller);
    }
}
