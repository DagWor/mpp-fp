package utility;

import models.*;

import java.util.function.BiFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
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
                    .limit(k < 0 ? 0 : k)
                    .map(Account::getCustomer)
                    .collect(Collectors.toList());


    public static BiFunction<Branch, Integer, List<Teller>> highestPaidTellers = (branch, k) ->
            Stream.ofNullable(branch)
                    .flatMap(branch1 -> Optional.ofNullable(branch1.getUsers()).orElseGet(ArrayList::new).stream())
                    .filter(user -> user instanceof Teller)
                    .map(user -> (Teller) user)
                    .sorted((teller, teller1) -> (int)teller1.getSalary() - (int)teller.getSalary() )
                    .limit(k < 0 ? 0 : k)
                    .collect(Collectors.toList());



    public static TriFunction<Branch, Integer, Integer, Double> MonthlyBranchDepositWithdrawalDifference = (branch, year, month) ->
            DoubleStream.of(AdminUtils.deposit.apply(branch, year, month), AdminUtils.withdrawal.apply(branch, year, month))
                .reduce((a1, a2) -> a2 - a1).orElse(0.0);


    public static TriFunction<Branch, Integer, Integer, Double> withdrawal = (branch, year, month) ->
            Optional.ofNullable(CommonUtils.listOfTransactions.apply(branch)).orElseGet(ArrayList::new)
                    .stream()
                    .filter(transaction1 -> transaction1.getTransactionType().equals("withdrawal") && transaction1.getDate().getYear()==year && transaction1.getDate().getMonthValue() == month)
                    .map(Transactions::getAmount)
                    .reduce(Double::sum)
                    .orElse(0.0);

    public static TriFunction<Branch, Integer, Integer, Double> deposit = (branch, year, month) ->
                    Optional.ofNullable(CommonUtils.listOfTransactions.apply(branch)).orElseGet(ArrayList::new)
                            .stream()
                    .filter(transaction1 -> transaction1.getTransactionType().equals("deposit") && transaction1.getDate().getYear()==year && transaction1.getDate().getMonthValue() == month)
                    .map(Transactions::getAmount)
                    .reduce(Double::sum)
                    .orElse(0.0);

}
