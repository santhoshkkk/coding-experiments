package leetcode.array;

public class RoatateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        rotate(nums, 2);
        for(int i=0;i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int temp[] = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            temp[(i + k) % nums.length] = nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = temp[i];
        }
    }
}
