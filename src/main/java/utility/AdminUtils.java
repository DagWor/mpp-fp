package utility;

import models.*;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.util.*;

public abstract class AdminUtils {
    public static BiFunction<HQ, Integer, List<Customer>> mostActiveCustomers = (hq, k) ->
            Stream.ofNullable(hq)
                    .flatMap(hq1 -> Optional.ofNullable(hq1.getBranch()).orElseGet(ArrayList::new).stream())
                    .flatMap(branch -> Optional.ofNullable(branch.getUsers()).orElseGet(ArrayList::new).stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer) user)
                    .flatMap(customer -> Optional.ofNullable(customer.getAccountList()).orElseGet(ArrayList::new).stream())
                    .sorted((account1, account2) -> account2.getTransactionList().size() - account1.getTransactionList().size())
                    .limit(k)
                    .map(Account::getCustomer)
                    .collect(Collectors.toList());


    public static BiFunction<Branch, Integer, List<Teller>> highestPaidTellers = (branch, k) ->
            Stream.ofNullable(branch)
                    .flatMap(branch1 -> Optional.ofNullable(branch1.getUsers()).orElseGet(ArrayList::new).stream())
                    .filter(user -> user instanceof Teller)
                    .map(user -> (Teller) user)
                    .sorted((teller, teller1) -> (int)teller1.getSalary() - (int)teller.getSalary() )
                    .limit(k)
                    .collect(Collectors.toList());



    public static Function<Branch, Double> branchRevenue = (branch) ->
            DoubleStream.of(AdminUtils.deposit.apply(branch), AdminUtils.withdrawal.apply(branch))
                .reduce((a1, a2) -> a1 - a2).orElse(0.0);


    public static Function<Branch, Double> withdrawal = branch ->
            Stream.ofNullable(branch)
                    .flatMap(branch1 -> Optional.ofNullable(branch1.getUsers()).orElseGet(ArrayList::new).stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer)user)
                    .flatMap(customer -> Optional.ofNullable(customer.getAccountList()).orElseGet(ArrayList::new).stream())
                    .flatMap(account -> Optional.ofNullable(account.getTransactionList()).orElseGet(ArrayList::new).stream())
                    .filter(transaction1 -> Optional.ofNullable(transaction1.getTransactionType()).orElse("no-").equals("withdrawal"))
                    .map(Transactions::getAmount)
                    .reduce(Double::sum)
                    .orElse(0.0);

    public static Function<Branch, Double> deposit = branch ->
            Stream.ofNullable(branch)
                    .flatMap(branch1 -> Optional.ofNullable(branch1.getUsers()).orElseGet(ArrayList::new).stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer)user)
                    .flatMap(customer -> Optional.ofNullable(customer.getAccountList()).orElseGet(ArrayList::new).stream())
                    .flatMap(account -> account.getTransactionList().stream())
                    .filter(transaction1 -> transaction1.getTransactionType().equals("deposit"))
                    .map(Transactions::getAmount)
                    .reduce(Double::sum)
                    .orElse(0.0);


    public static Function<HQ, List<Account>> lstOfAccount = hq ->
            Stream.of(hq)
                    .flatMap(_hq -> Optional.ofNullable(_hq.getBranch()).orElseGet(ArrayList::new).stream())
                    .flatMap(branch -> Optional.ofNullable(branch.getUsers()).orElseGet(ArrayList::new).stream())
                    .filter(user -> user instanceof Customer)
                    .map(user -> (Customer) user)
                    .flatMap(customer -> customer.getAccountList().stream())
                    .collect(Collectors.toList());
}
