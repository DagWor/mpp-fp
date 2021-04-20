package utility;

import models.*;

import java.util.ArrayList;
import java.time.Month;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public abstract class HQUtility {
    //    Function that returns list of transactions

    public static Function<HQ,List<Account>> lstOfTransaction=(hq)->
            Stream.of(hq)
                    .flatMap(_hq->_hq.getBranch().stream())
                    .flatMap(branch -> branch.getUsers().stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer)user)
                    .flatMap(customer -> customer.getAccountList().stream())
                    .collect(Collectors.toList());

    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static Function<HQ, List<Account>> lstOfAccount = (hq) ->
            Stream.of(hq)
                    .flatMap(_hq -> Optional.ofNullable(_hq.getBranch()).get().stream())
                    .flatMap(branch -> Optional.ofNullable(branch.getUsers()).get().stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer) user)
                    .flatMap(customer -> customer.getAccountList().stream())
                    .collect(Collectors.toList());

    /*
    Function that populates top k deposit for the given year
    */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static TriFunction<HQ, Integer, Integer, List<String>> topKDeposit = (hq, year, k) ->
            Optional.ofNullable(HQUtility.lstOfAccount.apply(hq).stream()).get()
                    .flatMap(account -> account.getTransactionList().stream())
                    .filter(transactions -> transactions.getDate().getYear() == year && transactions.getTransactionType().equals("DEPOSIT"))
                    .sorted((t1, t2) -> (int) (t2.getAmount() - t1.getAmount()))
                    .map(transactions -> "Account nbr: " + transactions.getToAccount() + " Amount: " + transactions.getAmount())
                    .limit(k)
                    .collect(Collectors.toList());
    /*
     * Top K accounts by current balance for the given year
     */
    @SuppressWarnings("OptionalGetWithoutIsPresent")
    public static BiFunction<HQ, Integer, List<Account>> topKAccounts = (hq, k) ->
            Optional.ofNullable(HQUtility.lstOfAccount.apply(hq).stream()).get()
                    .sorted((acc1, acc2) -> (int) (acc2.getCurrentBalance() - acc1.getCurrentBalance()))
                    .limit(k)
                    .collect(Collectors.toList());
    /*
     * Function that lists top k total withdraw peek month of the year
     * Having given year checking and identifying peek withdrawal month in the year
     */
    public static TriFunction<HQ, Integer, Integer, List<String>> thePeekMonthWithdrawTopK = (hq, year, k) ->
            Optional.ofNullable(HQUtility.lstOfAccount.apply(hq)).orElse(new ArrayList<>())
                    .stream()
                    .flatMap(account -> Optional.ofNullable(account.getTransactionList()).orElse(new ArrayList<>())
                            .stream())
                    .filter(transaction -> transaction.getDate().getYear() == year &&
                            transaction.getTransactionType().equals("WITHDRAW"))
                    .collect(Collectors.groupingBy(transactions -> transactions.getDate().getMonth(),
                            Collectors.summarizingDouble(Transactions::getAmount)))
                    .entrySet()
                    .stream()
                    .sorted((c1, c2) -> (int) (c2.getValue().getSum()) - (int) (c1.getValue().getSum()))
                    .limit(k)
                    .map(key -> "Month: " + key.getKey() + ", Total Withdraw: " + key.getValue().getSum())
                    .collect(Collectors.toList());


    //eden's
    //top withdrawal
    public static TriFunction<HQ,Integer,Integer, List<Transactions>> topKWithdrawal=(hq, year, k)->
            HQUtility.lstOfTransaction.apply(hq).stream()
                    .flatMap(account -> account.getTransactionList().stream())
                    .filter(transactions -> transactions.getDate().getYear()==year && transactions.getTransactionType().equals("WITHDRAW"))
                    .sorted((t1,t2)->(int)(t2.getAmount() - t1.getAmount()))
                    .limit(k)
                    .collect(Collectors.toList());

    //The lowest transfer of the year
    public static BiFunction<HQ,Integer,Transactions> lowestTransferOfTheYear=(hq, year)->
            //sorting in ascending
            HQUtility.lstOfTransaction.apply(hq).stream()
                    .flatMap(account -> account.getTransactionList().stream())
                    .filter(transactions -> transactions.getDate().getYear() == year && transactions.getTransactionType().equals("TRANSFER")).min((t1, t2) -> (int) (t1.getAmount() - t2.getAmount()))
                    .orElse(null);

    public static BiFunction<HQ, Month,String> maximumNumberOfTransactionsInAMonth =(hq, month)->
            HQUtility.lstOfTransaction.apply(hq).stream()
                    .flatMap(account -> account.getTransactionList().stream() )
                    .filter(transactions -> transactions.getDate().getMonth()==month)
                    .collect(Collectors.groupingBy(t->t.getDate().getDayOfWeek())).entrySet().stream()
                    .sorted((t1,t2)-> t2.getValue().size()-(t1.getValue().size()))
                    .map(t->t.getKey()+ " "+ t.getValue().size())
                    .limit(1).findFirst().orElse("Nothing found");

}
