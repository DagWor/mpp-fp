package models;

public class Customer extends User {

    public Customer(String username, String firstname, String lastName, String email) {
        super(username, firstname, lastName, email);
    }

    public double viewBalance(){

        return  0.0;
    }

    public  void fundTransfer(){

    }
}
