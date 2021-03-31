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
        aTimePair.setTimeValues("SS:00", "11:00");

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference());

        assertEquals(501, (long) aTimePairException.getMessageNr());
        System.out.println("Invalid START Time - Error Number: " + aTimePairException.getMessageNr() + " " +
                           "Error text: " + aTimePairException.getMessageText());
    }

    @Test
    public void timeDifferenceTest_invalidEndTimeFormat() {
        aTimePair.setTimeValues("11:00", "EE:00");

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference());

        assertEquals(502, (long) aTimePairException.getMessageNr());
        System.out.println("Invalid END Time - Error Number: " + aTimePairException.getMessageNr() + " " +
                "Error text: " + aTimePairException.getMessageText());
    }

    @Test
    public void timeDifferenceTest_missingParam() {

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference());

        assertEquals(500, (long) aTimePairException.getMessageNr());
        System.out.println("Missing Parameter - Error Number: " + aTimePairException.getMessageNr() + " " +
                "Error text: " + aTimePairException.getMessageText());
    }

     @Test
    public void timeDifferenceTest_invalidTimePeriod() {
        aTimePair.setTimeValues("19:00", "03:00");

        TimePair.TimePairException aTimePairException = assertThrows(TimePair.TimePairException.class,
                () -> aTimePair.getTimeDifference());

        assertEquals(503, (long) aTimePairException.getMessageNr());
        System.out.println("Invalid TIME PERIOD - Error Number: " + aTimePairException.getMessageNr() + " " +
                "Error text: " + aTimePairException.getMessageText());
    }

}