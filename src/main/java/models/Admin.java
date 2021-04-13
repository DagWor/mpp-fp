package models;

public class Admin {
    private final float salary;

    public Admin(float salary, String username, String email, String firstName, String lastName) {
//        super(username, email, firstName, lastName);
        this.salary = salary;
    }

    float getSalary() {
        return salary;
    }
}
