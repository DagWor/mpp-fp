import models.*;
import utility.AdminUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("1000", "Fairfield", 52556, 10231, "IA", "USA");
        HQ hq;
        hq = new HQ(
                "Don't Trust Bank",
                LocalDate.of(2021,1, 1),
                address);

        // BRANCH 1
        Branch branch = new Branch("First",  LocalDate.of(2021,1,1), address);

        User admin = new Admin(1000, "admin", "xyz@gmail.com", "John", "Doe", address);
        Teller teller = new Teller(1000, "teller", "teller@gmail.com", "Alice", "Doe", address);
        Customer customer = new Customer("customer", "customer@gmail.com", "Susan", "Doe", address);


        Account account = new SavingAccount(123, 100, 5.5);
        Transactions transactions = new Transactions("withdrawal", 123, 0, 160, LocalDate.of(2021, 5, 2));
        transactions.setTeller(teller);
        Transactions transactions1 = new Transactions("deposit", 0, 123, 30.0, LocalDate.of(2021, 5, 2));
        transactions1.setTeller(teller);

        Account account1 = new CheckingAccount(321, 2541.2, 7.5);
        account.setCustomer(customer);
        account1.setCustomer(customer);
        customer.setAccountList(Arrays.asList(account, account1));


        account.setTransactionList(Arrays.asList(transactions, transactions1));
        account1.setTransactionList(Collections.singletonList(transactions));

        branch.setUsers(Arrays.asList(admin, customer, teller));



        // Branch 2

        Branch branch1 = new Branch("Second",  LocalDate.of(2021,1,1), address);

        User admin1 = new Admin(1000, "admin1", "xyz1@gmail.com", "Dave", "George", address);
        Customer customer1 = new Customer("customer1", "Lily", "Hugh", "customer1@gmail.com", address);
        Teller teller1 = new Teller(1000, "teller1", "teller1@gmail.com", "Carl", "Junior", address);

        branch1.setUsers(Arrays.asList(admin1, customer1, teller1));



        Account account2 = new SavingAccount(1234, 1500, 5.5);
        Transactions transactions2 = new Transactions("deposit", 1234, 321, 30.0, LocalDate.of(2021, 5, 2));
        transactions2.setTeller(teller1);
        Transactions transactions3 = new Transactions("withdrawal", 0, 123, 150, LocalDate.of(2021, 5, 2));
        transactions3.setTeller(teller1);

        Account account3 = new CheckingAccount(3212, 2541.2, 7.5);
        account3.setCustomer(customer1);
        account2.setCustomer(customer1);
        customer1.setAccountList(Arrays.asList(account3, account2));


        account2.setTransactionList(Arrays.asList(transactions2, transactions3));
        account3.setTransactionList(Collections.singletonList(transactions3));


        hq.setBranch(Arrays.asList(branch, branch1));

        List<Customer> c = AdminUtils.mostActiveCustomers.apply(null, 1);
        System.out.println(c.toString());
        System.out.println(hq);

        System.out.println("Total withdrawal : $" + AdminUtils.withdrawal.apply(branch, 2021, 5));
        System.out.println("Total deposit : $" + AdminUtils.deposit.apply(branch, 2021, 5));
        System.out.println("Branch Revenue : $" + AdminUtils.MonthlyBranchDepositWithdrawalDifference.apply(branch, 2021, 5));




    }
}
