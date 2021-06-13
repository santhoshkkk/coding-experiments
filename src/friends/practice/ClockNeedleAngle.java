package friends.practice;

public class ClockNeedleAngle {
    public static final int ANGLE_PER_HOUR = 30;
    public static final int TOTAL_ANGLE = 360;
    int MINUTE_NEEDLE_ANGLE_PER_MINUTE = 6;
    float HOUR_NEEDLE_ANGLE_PER_MINUTE = 0.5f;

    public static void main(String[] args) {
        ClockNeedleAngle clockNeedleAngle = new ClockNeedleAngle();
        System.out.println(clockNeedleAngle.angle(12, 00));
        System.out.println(clockNeedleAngle.angle(12, 01));
        System.out.println(clockNeedleAngle.angle(12, 05));
        System.out.println(clockNeedleAngle.angle(1, 00));
        System.out.println(clockNeedleAngle.angle(2, 00));
        System.out.println(clockNeedleAngle.angle(3, 00));
        System.out.println(clockNeedleAngle.angle(3, 30));
        System.out.println(clockNeedleAngle.angle(6, 00));
        System.out.println(clockNeedleAngle.angle(6, 30));
        System.out.println(clockNeedleAngle.angle(9, 15));
    }

    float angle(int hour, int minute) {
        float minuteNeedleAngle = minute * MINUTE_NEEDLE_ANGLE_PER_MINUTE;
        float hourNeedleAngle = hour * ANGLE_PER_HOUR + minute * HOUR_NEEDLE_ANGLE_PER_MINUTE;

        return minuteNeedleAngle > hourNeedleAngle ? minuteNeedleAngle - hourNeedleAngle :
                TOTAL_ANGLE - (hourNeedleAngle - minuteNeedleAngle);

    }

}
