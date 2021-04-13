import models.Customer;
import models.HQ;
import models.Transactions;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Stream;

public abstract class BankHQUtility {
//    public static BiFunction<HQ,Integer, List<Transactions>> topKDeposit=(hq, year)->
//            Stream.of(hq)
//            .flatMap(_hq->_hq.getBranch().stream())
//            .flatMap(branch -> branch.getUsers().stream())
//            .filter(user -> user instanceof Customer)
//            .map(user -> (Customer)user)
//            .flatMap(customer -> customer.getAccountList().stream())
//                    .flatMap(account -> account.getTransactionList().stream())
//            .filter(transactions -> transactions.getDate().getYear()==year)
//            .sorted((Comparator.comparing(tr->tr)).reversed())
//            .


//                    .collect(Collectors.groupingBy(transactions -> transactions)))
//            .map(account -> account.getTransactionList())
//            .

//    ;
}
