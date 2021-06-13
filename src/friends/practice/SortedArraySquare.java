package friends.practice;

import java.util.Arrays;

public class SortedArraySquare {
    public static void main(String[] args) {
        SortedArraySquare sortedArraySquare = new SortedArraySquare();
        System.out.println(Arrays.toString(sortedArraySquare.sortedNumSum(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(sortedArraySquare.sortedNumSum(new int[]{-5, -2, 0, 3, 4})));
        System.out.println(Arrays.toString(sortedArraySquare.sortedNumSum(new int[]{-1000, -100})));
        System.out.println(Arrays.toString(sortedArraySquare.sortedNumSum(new int[]{})));

        System.out.println();
    }

    int[] sortedNumSum(int[] nums) {
        int[] result = new int[nums.length];
        int resultIndex = nums.length - 1;
        for (int start = 0, end = nums.length - 1; start <= end; ) {
            if (nums[start] < 0 && nums[start] * -1 >= nums[end]) {
                result[resultIndex--] = nums[start] * nums[start];
                start++; //NOSONAR
            } else {
                result[resultIndex--] = nums[end] * nums[end];
                end--; //NOSONAR
            }
        }
        return result;
    }
}
