package utility;

import models.Customer;
import models.HQ;
import models.User;

import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CustomerFunctions {

    public static Function<HQ, List<User>> listOfUser=(hq)-> Stream.of(hq)
            .flatMap(hq1->hq1.getBranch().stream()).
                    flatMap(branch->branch.getUsers().stream()).collect(Collectors.toList());


    //given:city and amount and return list of customer
    public static     TriFunction<HQ,String,Float, List<Customer>>  listOfCustomerWithCityAndSalary=
            (hq, city, balance) -> listOfUser.apply(hq).stream().
                    filter(user->user.getAddress().getCity()==city).
                    filter(user->user instanceof Customer ).
                    map(user->(Customer)user).
                    flatMap(customer->customer.getAccountList().stream()).
                    collect(Collectors.groupingBy(account->account.getCustomer(),Collectors.summarizingDouble(account->account.getCurrentBalance())))
                    .entrySet().stream().
                            filter(c -> c.getValue().getSum()>=balance).distinct().
                            map(m->m.getKey()).collect(Collectors.toList());


    /*public static BiFunction<HQ,Integer,List<String>> listOfTopTeller=(hq, k)->
                    listOfUser.apply(hq)
                            .stream().
                    filter(user->user instanceof Customer )
                    .map(user->(Customer)user)
                    .flatMap(customer->customer.getAccountList().stream())
                    .flatMap(account -> account.getTransactionList().stream())
                    .collect(Collectors.groupingBy(transactions -> transactions.getTeller())).entrySet().stream()
                    .sorted((transaction1,transaction2)->transaction2.getValue().size()-transaction1.getValue().size()).limit(k)
                    .map(transaction->transaction.getKey().getFirstname()+" "
                            +transaction.getKey().getLastName()+" "+
                            transaction.getValue().size())
                    .collect(Collectors.toList());*/


    public  static  Function<HQ,String> worrestCityInterOfCustomerNumber=(hq)->listOfUser.apply(hq).stream()
                   .filter(user->user instanceof Customer )
                   .collect(Collectors.groupingBy(user -> user.getAddress().getCity())).entrySet().stream()
                   .sorted((c1,c2)->c1.getValue().size()-c2.getValue().size())
                   .map(entry->entry.getKey()+" "+entry.getValue().size())
                   .findFirst().get();



   public static BiFunction<HQ,Integer,List<String>> listCustomer=(hq,k)->listOfUser.apply(hq).stream()
                .collect(Collectors.groupingBy(c->c.getAddress().getCity())).entrySet().stream()
                .sorted((c1,c2)->c2.getValue().size()-c1.getValue().size())
                .map(c->c.getKey()+" "+c.getValue().size())
                 .limit(k)
                .collect(Collectors.toList());


}
