package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Branch {
    private final String branchName;
    private final LocalDate openedDate;
    private Address address;
    private List<User> users;

    public Branch(String branchName, LocalDate openedDate, Address address) {
        this.branchName = branchName;
        this.openedDate = openedDate;
        this.address = address;
        this.users = new ArrayList<>();
    }


    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchName='" + branchName + '\'' +
                ", openedDate=" + openedDate +
                ", address=" + address +
                ", users=" + users +
                '}';
    }
}
