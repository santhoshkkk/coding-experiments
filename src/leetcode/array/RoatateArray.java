package leetcode.array;

public class RoatateArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        rotate(nums, 2);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    public static void rotate(int[] nums, int k) {
        int next;
        int temp;
        int nextIndex;
        k=k%nums.length;
        for (int i = 0; i < k; i++) {
            next = nums[0];
            for (int j = 0; j < nums.length; j++) {
                nextIndex=(j + 1) % nums.length;
                temp = nums[nextIndex];
                nums[nextIndex] = next;
                next = temp;
            }
        }
    }
}
