package services;

import models.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class AdminServices {

    public static List<Object> prepareData(){

        Address address = new Address("1000", "Fairfield", 52556, 10231, "IA", "USA");
        HQ hq = new HQ(
                "Don't Trust Bank",
                LocalDate.of(2021, 5, 2),
                address);

        // BRANCH 1
        Branch branch = new Branch("First", LocalDate.of(2021, 5, 2), address);

        User admin = new Admin(1000, "admin", "xyz@gmail.com", "John", "Doe", address);
        Teller teller = new Teller(1000, "teller", "teller@gmail.com", "Alice", "Doe", address);
        Customer customer = new Customer("customer", "customer@gmail.com", "Susan", "Doe", address);

        branch.setUsers(Arrays.asList(admin, customer, teller));

        Account account = new SavingAccount(123, 100, 5.5);
        Transactions transactions = new Transactions("withdrawal", 123, 321, 160.0, LocalDate.of(2021, 5, 2));
        Transactions transactions1 = new Transactions("deposit", 0, 123, 30.0, LocalDate.of(2021, 5, 2));

        Account account1 = new CheckingAccount(321, 2541.2, 7.5);
        account.setCustomer(customer);
        account1.setCustomer(customer);
        customer.setAccountList(Arrays.asList(account, account1));


        account.setTransactionList(Arrays.asList(transactions, transactions1));
        account1.setTransactionList(Collections.singletonList(transactions));

        // Branch 2

        Branch branch1 = new Branch("Second", LocalDate.of(2021, 5, 2), address);

        User admin1 = new Admin(1000, "admin1", "xyz1@gmail.com", "Dave", "George", address);
        Customer customer1 = new Customer("customer1", "Lily", "Hugh", "customer1@gmail.com", address);
        Customer customer2 = new Customer("customer2", "John", "Tom", "customer2@gmail.com", address);
        Customer customer3 = new Customer("customer3", "Dagi", "Pierre", "customer3@gmail.com", address);
        Customer customer4 = new Customer("customer4", "Wende", "ed", "customer4@gmail.com", address);
        Teller teller1 = new Teller(1100, "teller1", "teller1@gmail.com", "Carl", "Junior", address);



        Account account2 = new SavingAccount(1234, 1500, 5.5);
        Transactions transactions2 = new Transactions("withdrawal", 1234, 321, 150.0, LocalDate.of(2021, 5, 2));
        Transactions transactions3 = new Transactions("deposit", 0, 123, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions4 = new Transactions("withdrawal", 1234, 321, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions5 = new Transactions("deposit", 0, 123, 150.0, LocalDate.of(2021, 5, 2));
        Transactions transactions6 = new Transactions("withdrawal", 1234, 321, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions7 = new Transactions("deposit", 0, 123, 320.0, LocalDate.of(2021, 5, 2));

        Account account3 = new CheckingAccount(321, 2541.2, 7.5);
        Account account4 = new CheckingAccount(321, 2541.2, 7.5);
        Account account5 = new CheckingAccount(321, 2541.2, 7.5);
        Account account6 = new CheckingAccount(321, 2541.2, 7.5);
        Account account7 = new CheckingAccount(321, 2541.2, 7.5);


        account7.setCustomer(customer4);
        account6.setCustomer(customer4);
        account5.setCustomer(customer3);
        account4.setCustomer(customer2);
        account3.setCustomer(customer1);
        account2.setCustomer(customer1);
        customer1.setAccountList(Arrays.asList(account3, account2));


        account2.setTransactionList(Arrays.asList(transactions2, transactions3, transactions4, transactions5, transactions6, transactions7));
        account3.setTransactionList(Collections.singletonList(transactions3));



        branch1.setUsers(Arrays.asList(admin1, customer1, customer2, customer3, customer4, teller1));
        hq.setBranch(Arrays.asList(branch, branch1));

        return Arrays.asList(hq, branch1);
    }

    public static Customer expectedCustomer_whenHQGiven_provideMostActiveCustomer(){
        Address address = new Address("1000", "Fairfield", 52556, 10231, "IA", "USA");

        Customer customer = new Customer("customer1", "Lily", "Hugh", "customer1@gmail.com", address);

        Account account = new SavingAccount(123, 100, 5.5);
        Transactions transactions = new Transactions("transfer", 123, 321, 30.0, LocalDate.of(2021, 5, 2));

        Account account3 = new CheckingAccount(321, 2541.2, 7.5);
        Account account2 = new SavingAccount(1234, 1500, 5.5);
        account3.setCustomer(customer);
        account2.setCustomer(customer);
        customer.setAccountList(Arrays.asList(account3, account2));

        Transactions transactions2 = new Transactions("withdrawal", 1234, 321, 150.0, LocalDate.of(2021, 5, 2));
        Transactions transactions3 = new Transactions("deposit", 0, 123, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions4 = new Transactions("withdrawal", 1234, 321, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions5 = new Transactions("deposit", 0, 123, 150.0, LocalDate.of(2021, 5, 2));
        Transactions transactions6 = new Transactions("withdrawal", 1234, 321, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions7 = new Transactions("deposit", 0, 123, 320.0, LocalDate.of(2021, 5, 2));


        account2.setTransactionList(Arrays.asList(transactions2, transactions3, transactions4, transactions5, transactions6, transactions7));
        account.setTransactionList(Collections.singletonList(transactions));

        return customer;
    }

    public static Teller expectedTeller_whenBranchGiven_provideHighestPaidTeller(){
        Address address = new Address("1000", "Fairfield", 52556, 10231, "IA", "USA");

        return new Teller(1100, "teller1", "teller1@gmail.com", "Carl", "Junior", address);
    }

    public static Double expectedRevenue_whenBranchGiven_calculateBranchRevenue(){
        return 320.0D;
    }
    public static Double expectedWithdrawal_whenBranchGiven_totalWithdrawal(){
        return 210.0D;
    }
    public static Double expectedDeposit_whenBranchGiven_totalWithdrawal(){
        return 530.0D;
    }
}
