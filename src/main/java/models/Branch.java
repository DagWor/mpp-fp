package models;

import java.util.Date;
import java.util.List;

public class Branch {
    private String branchName;
    private Date openedDate;
    private Address address;
    private List<User> users;

    public Branch(String branchName, Date openedDate, Address address, List<User> users) {
        this.branchName = branchName;
        this.openedDate = openedDate;
        this.address = address;
        this.users = users;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public Date getOpenedDate() {
        return openedDate;
    }

    public void setOpenedDate(Date openedDate) {
        this.openedDate = openedDate;
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

//    Branch level Queries
//    Top k Account of the branch for given year
    public static double topKAccount(int yr){
//        to be implemented
        return 0.0;
    }

//    Top k highest withdraw month for the given year
    public static Date toKWithdrawOfTheYear(){
//        to be implemented
        return new Date();
    }

//    top k highest withdraw account of the given year
    public static  List<Account> topKWithdrawAccount(){
        //to be implemented
        return null;
    }
}
