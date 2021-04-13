package models;

public class Teller extends User {
    private final float salary;

    public Teller(float salary, String username, String email, String firstName, String lastName) {
        super(username, email, firstName, lastName);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void createSavingAccount(Customer customer, SavingAccount savingAccount){
        // TODO - add account for customer
//        customer.addAccount(savingAccount);
    }

    public void createCheckingAccount(Customer customer, SavingAccount savingAccount){
        // TODO - add account for customer
//        customer.addAccount(checkingAccount);
    }
}
