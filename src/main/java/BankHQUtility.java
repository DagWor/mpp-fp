import models.Customer;
import models.HQ;
import models.Transactions;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BankHQUtility {
//    public static BiFunction<HQ,Integer, List<Transactions>> topKDeposit=(hq,year)->
//            Stream.of(hq)
//            .flatMap(_hq->_hq.getBranch().stream())
//            .flatMap(branch -> branch.getUsers().stream())
//            .filter(user -> user instanceof Customer)
//            .map(user -> (Customer)user)
//            .flatMap(customer -> customer.getAccountList().stream())
//                    .map(account -> account.getTransactionList())

//                    .collect(Collectors.groupingBy(transactions -> transactions)))
//            .map(account -> account.getTransactionList())
//            .

//    ;
}
