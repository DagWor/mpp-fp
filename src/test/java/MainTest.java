import models.*;
import org.junit.jupiter.api.Test;
import services.AdminServices;
import utility.AdminUtils;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    // TEST - mostActiveCustomer
    @Test
    public void whenHQGiven_provideMostActiveCustomer() {

        List<Customer> expected = Collections.singletonList(AdminServices.expectedCustomer_whenHQGiven_provideMostActiveCustomer());
        List<Customer> actual = AdminUtils.mostActiveCustomers.apply((HQ)AdminServices.prepareData().get(0), 1);
        assertEquals(expected, actual);
    }

    @Test
    public void whenNullHQGiven_provideMostActiveCustomer() {

        List<Customer> expected =new ArrayList<>();
        List<Customer> actual = AdminUtils.mostActiveCustomers.apply(null, 1);
        assertEquals(expected, actual);
    }

    @Test
    public void whenHQGivenWithNullBranch_provideMostActiveCustomer() {

        List<Customer> expected =new ArrayList<>();
        List<Customer> actual = AdminUtils.mostActiveCustomers.apply(null, 1);
        assertEquals(expected, actual);
    }

    // Test highestPaidTellers
    @Test
    public void whenBranchGiven_provideHighestPaidTeller() {

        List<Teller> expected = Collections.singletonList(AdminServices.expectedTeller_whenBranchGiven_provideHighestPaidTeller());
        List<Teller> actual = AdminUtils.highestPaidTellers.apply((Branch) AdminServices.prepareData().get(1), 1);
        assertEquals(expected, actual);
    }


    // Test calculateMonthlyBranchDepositWithdrawalDifference
    @Test
    public void whenBranchGiven_calculateMonthlyBranchDepositWithdrawalDifference(){
        Double expected = AdminServices.expectedRevenue_whenBranchGiven_calculateBranchRevenue();
        Double actual = AdminUtils.MonthlyBranchDepositWithdrawalDifference.apply((Branch) AdminServices.prepareData().get(1), 2021, 5);
        assertEquals(expected, actual);
    }
}
