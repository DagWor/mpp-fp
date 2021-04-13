package models;

import models.Customer;
import models.HQ;
import models.TiFunction;
import models.Transactions;

import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class HQUtility {
    /*
    Function that populates to k deposit for the given year
    */
    public static TiFunction<HQ,Integer,Integer, List<Transactions>> topKDeposit=(hq, year,k)->
            HQUtility.lstOfTransaction.apply(hq).stream()
                    .flatMap(account -> account.getTransactionList().stream())
                    .filter(transactions -> transactions.getDate().getYear()==year && transactions.getTransactionType().equals("DEPOSIT"))
                    .sorted((t1,t2)->(int)(t2.getAmount() - t1.getAmount()))
                    .limit(k)
                    .collect(Collectors.toList());

    /*
    * Top K accounts
    */
    public static  BiFunction<HQ,Integer,List<Account>> topKAccounts = (hq,k)->
            HQUtility.lstOfTransaction.apply(hq).stream()
            .sorted((acc1,acc2)-> (int) (acc2.getCurrentBalance() - acc1.getCurrentBalance()))
            .limit(k)
            .collect(Collectors.toList());









    public static Function<HQ,List<Account>> lstOfTransaction=(hq)->
            Stream.of(hq)
                    .flatMap(_hq->_hq.getBranch().stream())
                    .flatMap(branch -> branch.getUsers().stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer)user)
                    .flatMap(customer -> customer.getAccountList().stream())
                    .collect(Collectors.toList());

}
