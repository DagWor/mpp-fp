package models;

import java.util.List;

public class Customer extends User {
 private List<Account> accountList;

    public Customer(String username, String firstname, String lastName, String email) {
        super(username, firstname, lastName, email);
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


    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }
    //   git

    public  void fundTransfer(){

    }
}
