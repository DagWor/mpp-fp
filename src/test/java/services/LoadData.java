package services;

import models.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class LoadData {
    public static HQ hq;
    public static Branch branch;
    public static Branch branch1;
    public static User admin;
    public static User teller;
    public static User teller1;
    public static User customer;
    public static User customer1;
    static User customer2;
    static Account account;
    static Account account1;

    static Account account2;
    static Account account3;
    static Account account4;

    static Transactions transactions;
    static Transactions transactions1;
    static Transactions transactions2;
    static Transactions transactions3;
    static Transactions transactions4;
    static Transactions transactions5;
    static Transactions transactions6;
    static Transactions transactions7;
    static Transactions transactions8;
    static Transactions transactions9;
    static Transactions transactions10;
    static Transactions transactions11;
    static Transactions transactions12;
    static Transactions transactions13;
    static Transactions transactions14;
    static Transactions transactions15;
    static Transactions transactions16;
    static Transactions transactions17;
    static Transactions transactions18;
    static Transactions transactions19;
    static Transactions transactions20;

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

        account2 = new SavingAccount(126, 100500, 5.5);
        account3 = new CheckingAccount(128, 2540.6, 7.5);
        account4 = new SavingAccount(130, 100888, 5.5);

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
        LoadData.testDataOne();

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


        transactions14 = new Transactions("TRANSFER", 126, 128, 500.0, LocalDate.of(2021, 5, 3));

        transactions15 = new Transactions("TRANSFER", 130, 128, 1000.0, LocalDate.of(2021, 4, 7));
        transactions16 = new Transactions("TRANSFER", 130, 126, 1500.0, LocalDate.of(2021, 5, 5));

        transactions17 = new Transactions("TRANSFER", 126, 130, 200.0, LocalDate.of(2021, 5, 9));
//        transactions18 = new Transactions("TRANSFER", 0, 321, 100.0, LocalDate.of(2019, 4, 2));
//
//        transactions19 = new Transactions("TRANSFER", 0, 123, 400.0, LocalDate.of(2020, 4, 2));
//        transactions20 = new Transactions("TRANSFER", 0, 321, 250.0, LocalDate.of(2020, 3, 2));



        account.setTransactionList(Arrays.asList(transactions,transactions2,transactions5,transactions7,transactions9,transactions11,transactions13));
        account1.setTransactionList(Arrays.asList(transactions1,transactions3,transactions4,transactions6,transactions8,transactions10,transactions12,transactions14));

        account2.setTransactionList(Arrays.asList(transactions14,transactions16,transactions17));
        account3.setTransactionList(Arrays.asList(transactions14,transactions15));
        account4.setTransactionList(Arrays.asList(transactions17,transactions15,transactions16));
    }

    public static void transactionLoader1(){
        LoadData.testDataOne();

        transactions = new Transactions("WITHDRAW", 123, 0, 3000.0, LocalDate.of(2018, 2, 2));
        transactions1 = new Transactions("WITHDRAW", 321, 0, 500.0, LocalDate.of(2018, 4, 2));

        transactions2 = new Transactions("WITHDRAW", 123, 0, 200.0, LocalDate.of(2019, 4, 2));
        transactions3 = new Transactions("WITHDRAW", 321, 0, 100.0, LocalDate.of(2019, 4, 2));

        transactions4 = new Transactions("WITHDRAW", 123, 0, 400.0, LocalDate.of(2020, 4, 2));
        transactions5 = new Transactions("WITHDRAW", 321, 0, 250.0, LocalDate.of(2020, 3, 2));

        transactions6 = new Transactions("WITHDRAW", 123, 0, 1000.0, LocalDate.of(2021, 5, 2));
        transactions7 = new Transactions("WITHDRAW", 321, 0, 1500.0, LocalDate.of(2021, 4, 2));

        transactions8 = new Transactions("WITHDRAW", 123, 0, 3000.0, LocalDate.of(2018, 5, 2));
        transactions9 = new Transactions("WITHDRAW", 321, 0, 500.0, LocalDate.of(2018, 4, 2));

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
        LoadData.testDataOne();

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
