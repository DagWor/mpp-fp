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



//   git

    public  void fundTransfer(){

    }
}
