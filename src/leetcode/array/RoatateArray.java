package leetcode.array;

public class RoatateArray {
    public static void main(String[] args) {

    }

    public void rotate(int[] nums, int k) {
        int current = nums[0];
        int index = 0;
        int temp;
        for (int i = 0; i < nums.length; i++) {
            temp = nums[(index + k) % nums.length];
            nums[(index + k) % nums.length] = current;
            System.out.println("current:" + current + "temp: " + temp + "index:" + index);
            current = temp;
            index = (index + k) % nums.length;
        }
    }
}
