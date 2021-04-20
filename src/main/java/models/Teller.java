package models;

import java.util.Objects;

public class Teller extends User {
    private final float salary;

    public Teller(float salary, String username, String email, String firstName, String lastName, Address address) {
        super(username, email, firstName, lastName, address);
        this.salary = salary;
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

    public float getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Teller {" +
                "first name =" + getFirstname() +
                "last name =" + getLastName() +
                "email =" + getEmail() +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Teller teller = (Teller) o;
        return Float.compare(teller.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(salary);
    }
}
