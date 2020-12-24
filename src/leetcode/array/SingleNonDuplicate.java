package leetcode.array;

public class SingleNonDuplicate {

    public static int singleNumber(int[] nums) {

        int uniqueNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            uniqueNum = uniqueNum ^ nums[i];
        }

        return uniqueNum;

    }

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1, 2, 3, 2, 1}));
        System.out.println(singleNumber(new int[]{1}));
    }
}
