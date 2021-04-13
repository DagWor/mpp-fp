import models.Customer;
import models.HQ;
import models.Transactions;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Stream;

public abstract class BankHQUtility {
//    BiFunction<HQ,Integer, List<Transactions>> topKDeposit=(hq,year)->
//            Stream.of(hq)
//            .flatMap(_hq->_hq.getBranch().stream())
//            .flatMap(branch -> branch.getUsers().stream())
//            .filter(user -> user instanceof Customer)
//            .map(user -> (Customer)user)
//            .filter(customer -> customer.getEmail().isEmpty())
//            .collect()
//
//    ;
}
