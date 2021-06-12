package leetcode.array;

public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 2, 2, 2};
        /*
            i=1, duplicates = 0 i<8
            1,1,2,2,2,2,2,2
            i=2, duplicates = 1 i<7
            1,2,2,2,2,2,2
            i=3, duplicates = 2 i<6
            1,2,2,2,2,2
            i=4, duplicates = 3 i<5
            1,2,2,2,2
            i=4, duplicates = 4 i<4
            1,2,2,2
            1,2,2
            1,2
        */
        int duplicates = removeDuplicates(nums);
        System.out.println("duplicates: " + duplicates);
        for (int i = 0; i < nums.length - duplicates; i++) {
            System.out.print(nums[i] + " ");
        }

    }

    public static int removeDuplicates(int[] nums) {
        int duplicates = 0;
        for (int i = 1; i < nums.length - (duplicates-1); i++) {
            if (nums[i] == nums[i - 1]) {
                duplicates++;
                for (int j = i; j < nums.length - duplicates; j++) {
                    nums[j] = nums[j + 1];
                }
            }
        }
        return duplicates;
    }
}
