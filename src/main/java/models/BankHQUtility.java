package models;

import models.Customer;
import models.HQ;
import models.TiFunction;
import models.Transactions;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class BankHQUtility {
    /*
    Function that populates to k deposit for the given year
    */
    public static TiFunction<HQ,Integer,Integer, List<Transactions>> topKDeposit=(hq, year,k)->
            Stream.of(hq)
            .flatMap(_hq->_hq.getBranch().stream())
            .flatMap(branch -> branch.getUsers().stream())
            .filter(user -> user instanceof Customer)
            .map(user -> (Customer)user)
            .flatMap(customer -> customer.getAccountList().stream())
                    .flatMap(account -> account.getTransactionList().stream())
            .filter(transactions -> transactions.getDate().getYear()==year && transactions.getTransactionType().equals("DEPOSIT"))
            .sorted((t1,t2)->(int)(t2.getAmount() - t1.getAmount()))
            .limit(k)
            .collect(Collectors.toList());
}
