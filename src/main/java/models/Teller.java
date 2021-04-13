package models;

public class Teller extends User {
    private final float salary;

    public Teller(float salary, String username, String email, String firstName, String lastName, Address address) {
        super(username, email, firstName, lastName, address);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void createSavingAccount(Customer customer, SavingAccount savingAccount){
        // TODO - add account for customer
//        customer.addAccount(savingAccount);
    }


    public double calcTotalDeposit() {
//        to be implemented
        return 0.0;
    }

    public void createCheckingAccount(Customer customer, SavingAccount savingAccount){
        // TODO - add account for customer
//        customer.addAccount(checkingAccount);
    }
}
