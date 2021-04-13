package models;

public class Admin extends User {
    private final float salary;

    public Admin(float salary, String username, String email, String firstName, String lastName, Address address) {
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


    @Override
    public String toString() {
        return "Admin {" +
                "first name =" + getFirstname() +
                "last name =" + getLastName() +
                "email =" + getEmail() +
                '}';
    }
    float getSalary() {
        return salary;
    }
}
