package services;

import models.Account;
import models.Address;
import models.HQ;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import utility.HQUtility;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class HQUtilityTest {

    @BeforeAll
    public static void setUp() {
        LoadData1.transactionLoader();
    }

    @Test
    public void emptyPeekWithdrawMonthTest(){
        assertEquals(new ArrayList<>(),HQUtility.thePeekMonthWithdrawTopK.apply(new HQ("",
                LocalDate.of(1900,01,01),new Address("","",
                0,0,"","")),2021,5));
    }

    @Test
    public void thePeekMonthWithdrawTopKFunctionalityTest1(){
        int year =2021;
        int k=1; //Number
        String str="Month: MAY, Total Withdraw: 4700.0";
        assertEquals(List.of(str),HQUtility.thePeekMonthWithdrawTopK.apply(LoadData1.hq,year,k));
    }

    @Test
    public void thePeekMonthWithdrawTopKFunctionalityTest2(){
        int year =2021;
        int k=2; //Number
        assertEquals(k,HQUtility.thePeekMonthWithdrawTopK.apply(LoadData1.hq,year,k).size());
    }

    @Test
    public void thePeekMonthWithdrawTopKFunctionalityTest3(){
        int year =2022;
        int k=2; //Number
        assertEquals(0,HQUtility.thePeekMonthWithdrawTopK.apply(LoadData1.hq,year,k).size());
    }

    /*

    Top K accounts Test
    test 1: What will happen if we pass empty
    */
    @Test
    public void emptyDataTopKAccountFunctionalityTest(){
        assertEquals(new ArrayList<>(),HQUtility.topKDeposit.apply(new HQ("",
                LocalDate.of(1900,01,01),new Address("","",
                0,0,"","")),2021,5));
    }

    @Test
    public void theTopKAccountFunctionalityTest(){
        int k=2; //Number
        assertEquals(true,HQUtility.topKAccounts.apply(LoadData1.hq,k).contains(LoadData1.account));
    }

    /*@Test
    public void theTopKAccountFunctionalityTest1(){
        int k=0; //Number
        List<Account> accountResult = HQUtility.topKAccounts.apply(LoadData.hq,k);
        assertFalse(accountResult.contains(LoadData1.account));
    }*/

    @Test
    public void theTopKAccountFunctionalityTest2(){
        int k=2;
        assertEquals(k,HQUtility.lstOfAccount.apply(LoadData1.hq).size());
    }

    @Test
    public void topKDepositTest(){
        int k=2; int year=2021;
        assertEquals(k,HQUtility.topKDeposit.apply(LoadData1.hq,year,k).size());
    }

    @Test
    public void topKDepositTest1(){
        int k=2; int year=2021;
        assertEquals(List.of("Account nbr: 321 Amount: 1500.0","Account nbr: 321 Amount: 1500.0"),
                HQUtility.topKDeposit.apply(LoadData1.hq,year,k));
    }
}
