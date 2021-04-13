package models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HQ {

    private String bankName;
    private List<Branch> branch;
    private Date establishedDate;
    private Address address;

    public HQ(String bankName, Date establishedDate, Address address) {
        this.bankName = bankName;
        this.establishedDate = establishedDate;
        this.address = address;
        branch = new ArrayList<>();
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public List<Branch> getBranch() {
        return branch;
    }

    public void setBranch(List<Branch> branch) {
        this.branch = branch;
    }

    public Date getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(Date establishedDate) {
        this.establishedDate = establishedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public void createBranch(){
        //implementation
    }
    public void addBranch(Branch _branch){
        branch.add(_branch);
    }
    public List<Branch> viewBranch(){
        //to be implemented
        return null;
    }

    //The top k deposit of the given year
    public static List<Transactions> theHighestDepositOfTheMonth(HQ hq, int year, int k){
        return HQUtility.topKDeposit.apply(hq,2020,5);
    }
//    Top k accounts
    public static List<Account> theTopKAccounts(HQ hq, int k){
        return HQUtility.topKAccounts.apply(hq,k);
    }

    //Find the highest withdraw account for a given month
    public static double theHighestWithdrawOfTheMonth(int month){
        //to be implemented
        return 0.0;
    }

    //Average Top k withdraw customer city within a given year
    public static List<Branch> averageTopKWithdrawAddress(int year){
        //to be implemented
        return null;
    }

    //Top k branches by number of customers
    public static List<Branch> topKBranches(){
        //to be implemented
        return null;
    }

    //Top k branches by number of customers
    public static List<Branch> topKBranches(HQ hq){
        return  null;
    }

}
