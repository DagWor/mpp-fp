package models;

public class Teller extends User{

    public Teller(String username, String firstname, String lastName, String email) {
        super(username, firstname, lastName, email);
    }

//    Create customer
    public void createCustomer(){
//        Create Customer
    }

    public void makeDeposit(){
    //to be implemented
    }

    public double calcTotalDeposit(){
//        to be implemented
        return 0.0;

    }

//    public List<Transaction> viewBalance(){}

//    public void makeTransfer(){}
}
