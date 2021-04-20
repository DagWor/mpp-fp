import models.*;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import services.*;
import utility.AdminUtils;
import utility.CustomerFunctions;
import utility.HQUtility;
import services.LoadData1;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

public class MainTest {

    // DAGMAWI
    // TEST - mostActiveCustomer
    @Test
    public void whenHQGiven_provideMostActiveCustomer() {

        List<Customer> expected = Collections.singletonList(AdminServices.expectedCustomer_whenHQGiven_provideMostActiveCustomer());
        List<Customer> actual = AdminUtils.mostActiveCustomers.apply((HQ)AdminServices.prepareData().get(0), 1);
        assertEquals(expected, actual);
    }

    @Test
    public void whenNullHQGiven_provideMostActiveCustomer() {

        List<Customer> expected = new ArrayList<>();
        List<Customer> actual = AdminUtils.mostActiveCustomers.apply(null, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void whenHQGivenWithNegativeLimit_provideMostActiveCustomer() {

        List<Customer> expected = new ArrayList<>();
        List<Customer> actual = AdminUtils.mostActiveCustomers.apply((HQ)AdminServices.prepareData().get(0), -1);
        assertEquals(expected, actual);
    }

    // Test highestPaidTellers
    @Test
    public void whenBranchGiven_provideHighestPaidTeller() {

        List<Teller> expected = Collections.singletonList(AdminServices.expectedTeller_whenBranchGiven_provideHighestPaidTeller());
        List<Teller> actual = AdminUtils.highestPaidTellers.apply((Branch) AdminServices.prepareData().get(1), 1);
        assertEquals(expected, actual);
    }

    @Test
    public void whenNullBranchGiven_provideHighestPaidTeller() {

        List<Teller> expected = new ArrayList<>();
        List<Teller> actual = AdminUtils.highestPaidTellers.apply(null, 1);
        assertEquals(expected, actual);
    }


    // Test calculateMonthlyBranchDepositWithdrawalDifference
    @Test
    public void whenBranchGiven_calculateMonthlyBranchDepositWithdrawalDifference(){
        Double expected = AdminServices.expectedRevenue_whenBranchGiven_calculateBranchRevenue();
        Double actual = AdminUtils.MonthlyBranchDepositWithdrawalDifference.apply((Branch) AdminServices.prepareData().get(1), 2021, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void whenNullBranchGiven_calculateMonthlyBranchDepositWithdrawalDifference(){
        Double expected = 0.0;
        Double actual = AdminUtils.MonthlyBranchDepositWithdrawalDifference.apply(null, 2021, 5);
        assertEquals(expected, actual);
    }


    // Test - withdrawal
    @Test
    public void whenBranchGiven_totalWithdrawalForYearAndMonth(){
        Double expected = AdminServices.expectedWithdrawal_whenBranchGiven_totalWithdrawal();
        Double actual = AdminUtils.withdrawal.apply((Branch)AdminServices.prepareData().get(1), 2021, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void whenNullBranchGiven_totalWithdrawalForYearAndMonth(){
        Double expected = 0.0;
        Double actual = AdminUtils.withdrawal.apply(null, 2021, 5);
        assertEquals(expected, actual);
    }

    // Test - deposit
    @Test
    public void whenBranchGiven_totalDepositForYearAndMonth(){
        Double expected = AdminServices.expectedDeposit_whenBranchGiven_totalWithdrawal();
        Double actual = AdminUtils.deposit.apply((Branch)AdminServices.prepareData().get(1), 2021, 5);
        assertEquals(expected, actual);
    }

    @Test
    public void whenNullBranchGiven_totalDepositForYearAndMonth(){
        Double expected = 0.0;
        Double actual = AdminUtils.deposit.apply(null, 2021, 5);
        assertEquals(expected, actual);
    }





    // WONDIMU

    @BeforeAll
    public static void setUp() {
        LoadData1.transactionLoader();
        LoadData.transactionLoader();
        LoadAllData.testDataOne();
        LoadAllData.transactionLoader();
        LoadAllData.SetTeller();
    }

    @Test
    public void emptyPeekWithdrawMonthTest(){
        assertEquals(new ArrayList<>(), HQUtility.thePeekMonthWithdrawTopK.apply(new HQ("",
                LocalDate.of(1900,1,1),new Address("","",
                0,0,"","")),2021,5));
    }

    @Test
    public void thePeekMonthWithdrawTopKFunctionalityTest1(){
        int year = 2021;
        int k = 1; //Number
        String str = "Month: MAY, Total Withdraw: 4700.0";
        assertEquals(List.of(str),HQUtility.thePeekMonthWithdrawTopK.apply(LoadData1.hq,year,k));
    }

    @Test
    public void thePeekMonthWithdrawTopKFunctionalityTest2(){
        int year = 2021;
        int k = 2; //Number
        assertEquals(k,HQUtility.thePeekMonthWithdrawTopK.apply(LoadData1.hq,year,k).size());
    }

    @Test
    public void thePeekMonthWithdrawTopKFunctionalityTest3(){
        int year = 2022;
        int k = 2; //Number
        assertEquals(0,HQUtility.thePeekMonthWithdrawTopK.apply(LoadData1.hq,year,k).size());
    }

    /*

    Top K accounts Test
    test 1: What will happen if we pass empty
    */
    @Test
    public void emptyDataTopKAccountFunctionalityTest(){
        assertEquals(new ArrayList<>(),HQUtility.topKDeposit.apply(new HQ("",
                LocalDate.of(1900,1,1),new Address("","",
                0,0,"","")),2021,5));
    }

    @Test
    public void theTopKAccountFunctionalityTest(){
        int k = 2; //Number
        assertTrue(HQUtility.topKAccounts.apply(LoadData1.hq, k).contains(LoadData1.account));
    }

    @Test
    public void theTopKAccountFunctionalityTest2(){
        int k = 2;
        assertEquals(k,HQUtility.lstOfAccount.apply(LoadData1.hq).size());
    }

    @Test
    public void topKDepositTest(){
        int k = 2;
        int year = 2021;
        assertEquals(k,HQUtility.topKDeposit.apply(LoadData1.hq,year,k).size());
    }

    @Test
    public void topKDepositTest1(){
        int k = 2;
        int year = 2021;
        assertEquals(List.of("Account nbr: 321 Amount: 1500.0","Account nbr: 321 Amount: 1500.0"),
                HQUtility.topKDeposit.apply(LoadData1.hq,year,k));
    }





    // EDEN
    //maximumNumberOfTransactionsInAMonth
    @Test
    public void _maximumNumberOfTransactionsInAMonth() {
        String  actualResult = HQUtility.maximumNumberOfTransactionsInAMonth.apply(LoadData.hq, Month.APRIL );
        assertNotEquals("FRIDAY 6", actualResult);
    }
    //lowest transfer of the year
    @Test
    public  void _lowestTransferOfTheYear() {
        Transactions input = new Transactions( "TRANSFER",  126, 128, 500.0, LocalDate.of(2021, 5, 3));
        Transactions actualResult = HQUtility.lowestTransferOfTheYear.apply(LoadData.hq ,2021);
        assertEquals(input,actualResult);
    }

    //top withdrawal
    @Test
    public void topKWithdrawalKThreeTest()
    {
        List<Transactions> actualResult = HQUtility.topKWithdrawal.apply(LoadData.hq,2021,3);
        assertEquals(3,actualResult.size());
    }

    @Test
    public  void  topKWithdrawalKFourTest() {
        List<Transactions> actualResult = HQUtility.topKWithdrawal.apply(LoadData.hq,2021,4);
        assertEquals(4,actualResult.size());
    }

    @Test
    public  void  topKWithdrawalYearTest() {
        List<Transactions> actualResult = HQUtility.topKWithdrawal.apply(LoadData.hq,2022,3);
        assertEquals(0,actualResult.size());
    }



    // MINTESINOT

    @SuppressWarnings("SuspiciousMethodCalls")
    @Test
    public void listOfCustomerWithCityAndSalaryTwoTest(){
        List<Customer> customers = CustomerFunctions.listOfCustomerWithCityAndSalary.apply(LoadAllData.hq,"Fairfield",1000f);
        assertEquals(2,customers.size());
        assertTrue(customers.contains(LoadAllData.customer));

    }

    @SuppressWarnings("SuspiciousMethodCalls")
    @Test
    public void listOfCustomerWithCityAndSalaryWithAMountTest(){
        List<Customer> customers = CustomerFunctions.listOfCustomerWithCityAndSalary.apply(LoadAllData.hq,"Fairfield",25000f);
        assertEquals(2,customers.size());
        assertTrue(customers.contains(LoadAllData.customer));

    }

    @Test
    public void listOfCustomerWithCityAndSalaryWithCityTest(){
        List<Customer> customers = CustomerFunctions.listOfCustomerWithCityAndSalary.apply(LoadAllData.hq,"Boston",25000f);
        assertEquals(0,customers.size());


    }

    @Test
    public void listOfCustomerWithCityAndSalaryWithSpecificCityTest(){
        List<Customer> customers = CustomerFunctions.listOfCustomerWithCityAndSalary.apply(LoadAllData.hq,"Seattle",25000f);
        assertEquals(1,customers.size());


    }

    // test Customer List
    @Test
    public void listCustomerCorrect(){
        List<String> customerList = CustomerFunctions.listCustomer.apply(LoadAllData.hq,2);
        assertEquals(2,customerList.size());
        assertTrue(customerList.contains("Fairfield 4"));
    }
    @Test
    public void listCustomerWrongData(){
        List<String> customerList = CustomerFunctions.listCustomer.apply(LoadAllData.hq,2);
        assertFalse(customerList.contains("Fairfields 4"));
    }

    @Test
    public void listCustomerWithLimit(){
        List<String> customerList = CustomerFunctions.listCustomer.apply(LoadAllData.hq,1);
        assertEquals(1,customerList.size());
    }

    @Test
    public void listCustomerWithCustomerWithLimit(){
        List<String> customerList = CustomerFunctions.listCustomer.apply(LoadAllData.hq,1);
        assertEquals(1,customerList.size());
    }



    // test Worst city of customer
    @Test
    public void worstCityInterOfCustomerNumberTest(){
        String actualList = CustomerFunctions.worstCityInterOfCustomerNumber.apply(LoadAllData.hq);
        assertEquals("Seattle 1",actualList);
    }

    @Test
    public void worstCityInterOfCustomerNumberDataTest(){
        String actualList = CustomerFunctions.worstCityInterOfCustomerNumber.apply(LoadAllData.hq);
        assertTrue(actualList.contains("Seattle 1"));
    }


}
