package utility;

import models.Account;
import models.Customer;
import models.HQ;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.*;

public abstract class AdminUtils {
    public static BiFunction<HQ, Integer, List<Customer>> mostActiveCustomers = (hq, k) ->
            Stream.ofNullable(hq)
                    .flatMap(hq1 -> Optional.ofNullable(hq1.getBranch()).get().stream())
                    .flatMap(branch -> Optional.ofNullable(branch.getUsers()).get().stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer) user)
                    .flatMap(customer -> Optional.ofNullable(customer.getAccountList()).get().stream())
                    .sorted((account1, account2) -> account2.getTransactionList().size() - account1.getTransactionList().size())
                    .limit(k)
                    .map(Account::getCustomer)
                    .collect(Collectors.toList());

//    public abstract

}
