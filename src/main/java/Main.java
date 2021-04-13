import models.*;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Address address = new Address("1000", "Fairfield", 52556, 10231, "IA", "USA");
        HQ hq = new HQ(
                "Don't Trust Bank",
                new Date(),
                address);

        Branch branch = new Branch("First", new Date(), address);
        Branch branch1 = new Branch("Second", new Date(), address);

        User admin = new Admin(1000, "admin", "xyz@gmail.com", "John", "Doe");
        User customer = new Customer("customer", "customer@gmail.com", "Susan", "Doe");
        User teller = new Teller(1000, "teller", "teller@gmail.com", "Alice", "Doe");

        User admin1 = new Admin(1000, "admin1", "xyz1@gmail.com", "Dave", "George");
        User customer1 = new Customer("customer1", "Lily", "Hugh", "customer1@gmail.com");
        User teller1 = new Teller(1000, "teller1", "teller1@gmail.com", "Carl", "Junior");

        branch.setUsers(Arrays.asList(admin, customer, teller));
        branch1.setUsers(Arrays.asList(admin1, customer1, teller1));

        hq.setBranch(Arrays.asList(branch, branch1));


    }
}
