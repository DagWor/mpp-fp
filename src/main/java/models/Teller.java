package models;

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

    public void createSavingAccount(Customer customer, SavingAccount savingAccount){
        // TODO - add account for customer
//        customer.addAccount(savingAccount);
    }

    public void createCheckingAccount(Customer customer, SavingAccount savingAccount){
        // TODO - add account for customer
//        customer.addAccount(checkingAccount);
    }

    @Override
    public String toString() {
        return "Teller {" +
                "first name =" + getFirstname() +
                "last name =" + getLastName() +
                "email =" + getEmail() +
                '}';
    }
}
