package InterviewPrep;

public class ClockTimeAngle {
    public int getAngleMinutes(int Minutes) {
        if (0 == Minutes) { return 0; }
        else {
            int fiveMinuteMultiple = 0;
            int fiveExcess = 0;
            if (Minutes > 5) {
                fiveMinuteMultiple = Minutes / 5;
                if (Minutes % 5 > 1) {
                    fiveExcess = Minutes - (fiveMinuteMultiple * 5);
                }
                // A clock being a circle of 360 degrees. Every five minutes is 30 degrees.
                // Every minute being 6 degrees.
                return (fiveMinuteMultiple * 30) + (fiveExcess * 6);
            }
            else {
                return Minutes * 6;
            }
        }
    }

    // if we want to be pendantic we can do some fancier math about the hour-arm and based off the minutes
    // determine what fifth of the hour its in and then calculate the angle from that. That can be v2.
    public int getAngleHours(int Hours) {
        if (12 == Hours) { return 0; }
        else { return Hours * 30; }
    }

    // there are five minutes between each Hour on a analog clock. If we perform 360/5 we get 72. Thus
    // we can break up the degrees of the circle into fifths. This gives us the precision for what "minute"
    // to calculate for where in that Hour, the Minutes angle is. What fifth of the circle is it located?
    //
    // if each minute is 6 degrees, we can calculate what portion of 30 degrees the hour-hand is during
    // an hour. Insted of locking hard to the hour itself, this gives us more precision.
    //
    // bug: unused variables and this is never called, need to validate.
    public int getAngleHoursPrecise(int Hours, int Minutes) {
        int hoursAngle = getAngleHours(Hours);
        int minutesAngle = getAngleMinutes(Minutes);
        int minutesPercent = 0;

        if (minutesAngle <= 72) { return 30; }
        else {
            minutesPercent = (minutesAngle / 72);
            return (minutesPercent + 1) * 30;
        }
    }

    public boolean calcNinetyDegrees(int Hours, int Minutes) {
        int degrees = getAngleHours(Hours) - getAngleMinutes(Minutes);

        if (degrees == 90 || degrees == -90) { return true; }
        return false;
    }
}
