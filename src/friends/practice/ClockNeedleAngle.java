package friends.practice;

public class ClockNeedleAngle {
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
        float hourNeedleAngle = hour * 30 + minute * HOUR_NEEDLE_ANGLE_PER_MINUTE;

        return minuteNeedleAngle > hourNeedleAngle ? minuteNeedleAngle - hourNeedleAngle :
                360 - (hourNeedleAngle - minuteNeedleAngle);

    }

}
