import models.Address;
import models.Branch;
import models.HQ;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        HQ hq = new HQ(
                "Don't Trust Bank",
                new Date(),
                new Address("1000", "Fairfield", 52556, 10231, "IA", "USA"));

//        Branch branch = new Branch()
    }
}
