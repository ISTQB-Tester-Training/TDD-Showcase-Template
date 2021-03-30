package tddshowcasetestpackage;

import tddshowcasepackage.*;
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

    @Test
    public void timeDifferenceTest_invalidStartTimeFormat() {
        aTimePair.setTimeValues("XX:00", "11:00");

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference());

        assertEquals(501, (long) aTimePairException.getMessageNr());
        System.out.println("Error Number: " + aTimePairException.getMessageNr() + " " +
                           "Error text: " + aTimePairException.getMessageText());
    }
}