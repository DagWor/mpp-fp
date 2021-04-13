package models;

public class Teller {
    private final float salary;

    public Teller(float salary, String username, String email, String firstName, String lastName) {
//        super(username, email, firstName, lastName);
        this.salary = salary;
    }

    public float getSalary() {
        return salary;
    }

    public void createAccount(){

    }
}
