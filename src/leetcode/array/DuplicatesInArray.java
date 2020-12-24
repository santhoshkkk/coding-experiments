package leetcode.array;

import java.util.HashSet;
import java.util.Set;

public class DuplicatesInArray {
    public static void main(String[] args) {
        System.out.println(hasDuplicates(new int[]{1, 2, 3}));
        System.out.println(hasDuplicates(new int[]{1, 2, 1}));
        System.out.println(hasDuplicates(new int[]{}));
        System.out.println(hasDuplicates(null));
    }

    private static boolean hasDuplicates(int[] array) {
        if (null == array || array.length < 2) {
            return false;
        }
        Set<Integer> unique = new HashSet<>();
        for (int num : array) {
            if (!unique.add(num)) {
                return true;
            }
        }
        return false;
    }
}
