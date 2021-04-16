package utility;

import models.Branch;
import models.Customer;
import models.Transactions;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CommonUtils {


    public static Function<Branch, List<Transactions>> listOfTransactions = (branch) ->
            Stream.ofNullable(branch)
                    .flatMap(branch1 -> Optional.ofNullable(branch1.getUsers()).orElseGet(ArrayList::new).stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer)user)
                    .flatMap(customer -> Optional.ofNullable(customer.getAccountList()).orElseGet(ArrayList::new).stream())
                    .flatMap(account -> account.getTransactionList().stream())
                    .collect(Collectors.toList());
}
