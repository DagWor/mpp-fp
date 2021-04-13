package models;

public class Admin extends User {
    private final float salary;

    public Admin(float salary, String username, String email, String firstName, String lastName, Address address) {
        super(username, email, firstName, lastName, address);
        this.salary = salary;
    }

    float getSalary() {
        return salary;
    }
}
