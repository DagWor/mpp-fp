import models.*;

import java.time.LocalDate;
import java.time.Month;
import java.time.MonthDay;
import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("1000", "Fairfield", 52556, 10231, "IA", "USA");
        HQ hq = new HQ(
                "Don't Trust Bank",
                new Date(),
                address);

        // BRANCH 1
        Branch branch = new Branch("First", new Date(), address);

        User admin = new Admin(1000, "admin", "xyz@gmail.com", "John", "Doe");
        User teller = new Teller(1000, "teller", "teller@gmail.com", "Alice", "Doe");
        User customer = new Customer("customer", "customer@gmail.com", "Susan", "Doe");

        branch.setUsers(Arrays.asList(admin, customer, teller));

        Account account = new SavingAccount(123, 100, 5.5);
        Transactions transactions = new Transactions("transfer", 123, 321, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions1 = new Transactions("deposit", 0, 123, 30.0, LocalDate.of(2021, 5, 2));

        Account account1 = new CheckingAccount(321, 2541.2, 7.5);
        Customer customer2 = (Customer) customer;
        customer2.setAccountList(Arrays.asList(account, account1));


        account.setTransactionList(Arrays.asList(transactions, transactions1));




        // Branch 2

        Branch branch1 = new Branch("Second", new Date(), address);

        User admin1 = new Admin(1000, "admin1", "xyz1@gmail.com", "Dave", "George");
        User customer1 = new Customer("customer1", "Lily", "Hugh", "customer1@gmail.com");
        User teller1 = new Teller(1000, "teller1", "teller1@gmail.com", "Carl", "Junior");

        branch1.setUsers(Arrays.asList(admin1, customer1, teller1));



        Account account2 = new SavingAccount(123, 100, 5.5);
        Transactions transactions2 = new Transactions("transfer", 123, 321, 30.0, LocalDate.of(2021, 5, 2));
        Transactions transactions3 = new Transactions("deposit", 0, 123, 30.0, LocalDate.of(2021, 5, 2));

        Account account3 = new CheckingAccount(321, 2541.2, 7.5);
        Customer customer3 = (Customer) customer1;
        customer3.setAccountList(Arrays.asList(account3, account2));


        account.setTransactionList(Arrays.asList(transactions2, transactions3));


        hq.setBranch(Arrays.asList(branch, branch1));

        System.out.println(hq);


    }
}
