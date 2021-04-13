package queries;

import models.Account;
import models.Customer;
import models.HQ;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class AdminUtils {
    public static Function<HQ, Account> accountWithMostTransactions = hq ->
            Stream.of(hq)
                    .flatMap(hq1 -> hq1.getBranch().stream())
                    .flatMap(branch -> branch.getUsers().stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer) user)
                    .flatMap(customer -> customer.getAccountList().stream())
                    .min((account1, account2) -> account2.getTransactionList().size() - account1.getTransactionList().size())
                    .orElse(null);

}
