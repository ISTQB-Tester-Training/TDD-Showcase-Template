package tddshowcasepackage;

import java.time.*;
import java.time.temporal.ChronoUnit;

public class TimePair {

    private String startTime = null;
    private String endTime = null;

    public TimePair() {}

    public void setTimeValues (String strStartTime, String strEndTime) {
        startTime = strStartTime;
        endTime = strEndTime;
    }

    public double getTimeDifference(String strStartTime, String strEndTime) {
        setTimeValues(strStartTime, strEndTime);
        return getTimeDifference();
    }

    public double getTimeDifference() throws TimePairException {

        try {
            LocalTime checkStartTime = LocalTime.parse(startTime);
        }
        catch (Exception e) {
            throw new TimePairException(e.getMessage() + "(Input value: " + startTime + ")", 501);
        }

        return LocalTime.parse(startTime).until(LocalTime.parse(endTime), ChronoUnit.MINUTES)/60.0;
    }

    public class TimePairException extends RuntimeException {
        private final String message;
        private final Long messageNr;

        public TimePairException (String argMessage, long argMessageNr) {
            super(argMessage);
            message = argMessage;
            messageNr = argMessageNr;
        }
        public String getMessageText() {
            return message;
        }
        public Long getMessageNr() {
            return messageNr;
        }
    }
}
