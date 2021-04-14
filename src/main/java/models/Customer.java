package models;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Customer extends User {
 private List<Account> accountList;


    public Customer(String username, String firstname, String lastName, String email,Address address) {
        super(username, firstname, lastName, email,address);
        accountList=new ArrayList<>();
    }

    @Override
    public String getEmail() {
        return super.getEmail();
    }

    @Override
    public String getFirstname() {
        return super.getFirstname();
    }

    @Override
    public String getLastName() {
        return super.getLastName();
    }

    @Override
    public String getUsername() {
        return super.getUsername();
    }

    @Override
    public void setEmail(String email) {
        super.setEmail(email);
    }

    @Override
    public void setFirstname(String firstname) {
        super.setFirstname(firstname);
    }

    @Override
    public void setUsername(String username) {
        super.setUsername(username);
    }

    @Override
    public void setLastName(String lastName) {
        super.setLastName(lastName);
    }

    public void setAccount(Account account) {
        accountList.add(account);
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    //   git

    public  void fundTransfer(){

    }

    @Override
    public String toString() {
        return "Customer{" +
                "accountList=" + accountList +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(getEmail(), customer.getEmail());
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountList);
    }
}
