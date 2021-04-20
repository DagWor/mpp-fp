package models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HQ {

    private final String bankName;
    private List<Branch> branch;
    private final LocalDate establishedDate;
    private Address address;

    public HQ(String bankName, LocalDate establishedDate, Address address) {
        this.bankName = bankName;
        this.establishedDate = establishedDate;
        this.address = address;
        branch = new ArrayList<>();
    }


    public List<Branch> getBranch() {
        return branch;
    }

    public void setBranch(List<Branch> branch) {
        this.branch = branch;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "HQ{" +
                "bankName='" + bankName + '\'' +
                ", branch=" + branch +
                ", establishedDate=" + establishedDate +
                ", address=" + address +
                '}';
    }
}
