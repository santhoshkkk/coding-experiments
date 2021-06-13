package friends.practice;

public class SortedArraySquare {
    public static void main(String[] args) {
        SortedArraySquare sortedArraySquare = new SortedArraySquare();
        printResult(sortedArraySquare.sortedNumSum(new int[]{1, 2, 3, 4}));
        printResult(sortedArraySquare.sortedNumSum(new int[]{-5, -2, 0, 3, 4}));
        printResult(sortedArraySquare.sortedNumSum(new int[]{-1000, -100}));
        printResult(sortedArraySquare.sortedNumSum(new int[]{}));

        System.out.println();
    }

    static void printResult(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
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
