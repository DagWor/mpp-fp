package services;
import models.Address;
import models.HQ;
import org.junit.jupiter.api.Test;
import utility.*;

import java.time.LocalDate;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HQUtilityTest {

    //
    @Test
    public void emptyHQTest(){
        assertEquals(new ArrayList<>(),HQUtility.thePeekMonthWithdrawTopK.apply(new HQ("",
                LocalDate.of(1900,01,01),new Address("","",
                0,0,"","")),2021,5));
    }
}
