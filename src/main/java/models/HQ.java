package models;

import utility.HQUtility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class HQ {

    private String bankName;
    private List<Branch> branch;
    private LocalDate establishedDate;
    private Address address;

    public HQ(String bankName, LocalDate establishedDate, Address address) {
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

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    //    The top k deposit of the given year
//    Hint K is the a number that select top rank numbers
    public static List<String> theTopKDeposit(HQ hq, int year, int k) {
        return HQUtility.topKDeposit.apply(hq, year, k);
    }

    //    Top k accounts by account balance
    public static List<Account> theTopKAccounts(HQ hq, int k) {
        return HQUtility.topKAccounts.apply(hq, k);
    }

    //    Top k peek withdraw month (s) of the giver year
    /*public static List<String> thePeekWithdrawtopK(HQ hq, int year, int k) {
        return HQUtility.thePeekMonthWithdrawTopK.apply(hq, year,k);
    }*/
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
