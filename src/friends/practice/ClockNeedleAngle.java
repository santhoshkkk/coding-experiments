package friends.practice;

public class ClockNeedleAngle {
    int needleAnglePerMinute = 6;
    float hourAnglePerMinute = 0.5f;

    public static void main(String[] args) {
        ClockNeedleAngle clockNeedleAngle = new ClockNeedleAngle();
        System.out.println(clockNeedleAngle.angle(12, 00));
        System.out.println(clockNeedleAngle.angle(12, 01));
        System.out.println(clockNeedleAngle.angle(12, 05));
        System.out.println(clockNeedleAngle.angle(11, 55));
        System.out.println(clockNeedleAngle.angle(11, 0));
        System.out.println(clockNeedleAngle.angle(1, 00));
    }

    float angle(int hour, int minute) {
        return minute * needleAnglePerMinute - ((12 == hour) ? 1 : hour) * hourAnglePerMinute;
    }

}
