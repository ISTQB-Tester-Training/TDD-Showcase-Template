package TDDShowcaseTestPackage;

import TDDShowcasePackage.*;
import org.junit.Test;
import static org.junit.Assert.*;

public class TimePairTest {

    TimePair aTimePair = new TimePair();

    @Test
    public void timeDifferenceTest_1h () {
        aTimePair.setTimeValues("10:00", "11:00");
        assertEquals(1.0, aTimePair.getTimeDifference(), 0.0);
    }

    @Test
    public void timeDifferenceTest_0h () {
        aTimePair.setTimeValues("10:00", "10:00");
        assertEquals(0.0, aTimePair.getTimeDifference(), 0.0);
    }
}