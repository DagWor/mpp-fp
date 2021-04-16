package services;
import models.HQ;
import models.Transactions;
import org.junit.jupiter.api.BeforeAll;


import org.junit.jupiter.api.Test;
import utility.HQUtility;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class HQUtility2Test {
    @BeforeAll
    public static void setup(){
        LoadData.transactionLoader();
    }
    //maximumNumberOfTranscationsInAMonth
    @Test
    public void _maximumNumberOfTranscationsInAMonth(){
        String  actualResult = HQUtility.maximumNumberOfTranscationsInAMonth.apply(LoadData.hq, Month.APRIL );
        assertEquals(false,actualResult.equals("FRIDAY 6"));
    }
    //lowest transfer of the year
    @Test
    public  void _lowestTransferoftheYear()
    {
        Transactions input=new Transactions( "TRANSFER",  126, 128, 500.0, LocalDate.of(2021, 5, 3));
        Transactions actualResult=HQUtility.lowestTransferOfTheYear.apply(LoadData.hq ,2021);
        assertEquals(input,actualResult);
    }
    //top withdrawal
    @Test
    public  void  topkWithdrawalKthreeTest()
    {
        List <Transactions> input=new ArrayList<>();
        List<Transactions> actualResult=HQUtility.topKWithdrawal.apply(LoadData.hq,2021,3);
        assertEquals(3,actualResult.size());
    }

    @Test
    public  void  topkWithdrawalkFourTest()
    {
        List <Transactions> input=new ArrayList<>();
        List<Transactions> actualResult=HQUtility.topKWithdrawal.apply(LoadData.hq,2021,4);
        assertEquals(4,actualResult.size());
    }

    @Test
    public  void  topkWithdrawalyearTest()
    {
        List <Transactions> input=new ArrayList<>();
        List<Transactions> actualResult=HQUtility.topKWithdrawal.apply(LoadData.hq,2022,3);
        assertEquals(0,actualResult.size());
    }
}