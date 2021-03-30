package TDDShowcasePackage;

public class TimePair {

    private String startTime, endTime;

    public TimePair() {};

    public void setTimeValues (String strStartTime, String strEndTime) {
        startTime = strStartTime;
        endTime = strEndTime;
    }

    public double getTimeDifference(String strStartTime, String strEndTime) {
        setTimeValues(strStartTime, strEndTime);
        return getTimeDifference();
    }

    public double getTimeDifference() {
        return 1.0;
    }
}
