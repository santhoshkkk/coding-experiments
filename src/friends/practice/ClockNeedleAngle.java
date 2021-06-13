package friends.practice;

public class ClockNeedleAngle {
    private static final int TOTAL_ANGLE = 360;
    private static final int HOUR_NEEDLE_ANGLE_PER_HOUR = 30;
    private static final int MINUTE_NEEDLE_ANGLE_PER_MINUTE = 6;
    private static final float HOUR_NEEDLE_ANGLE_PER_MINUTE = 0.5f;

    public static void main(String[] args) {
        ClockNeedleAngle clockNeedleAngle = new ClockNeedleAngle();
        for (int hours = 1; hours < 13; hours++) {
            for (int minutes = 0; minutes < 60; minutes++) {
                System.out.println(hours + ":" + minutes + " - " + clockNeedleAngle.angle(hours, minutes) + " degrees");
            }
        }
    }

    float angle(int hours, int minutes) {
        float minuteNeedleAngleFrom12 = minutes * MINUTE_NEEDLE_ANGLE_PER_MINUTE;
        float hourNeedleAngleFrom12 = hours * HOUR_NEEDLE_ANGLE_PER_HOUR + minutes * HOUR_NEEDLE_ANGLE_PER_MINUTE;

        return minuteNeedleAngleFrom12 > hourNeedleAngleFrom12 ? minuteNeedleAngleFrom12 - hourNeedleAngleFrom12 :
                TOTAL_ANGLE - (hourNeedleAngleFrom12 - minuteNeedleAngleFrom12);

    }

}
