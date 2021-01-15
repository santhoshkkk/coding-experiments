package leetcode;

import java.util.Arrays;

public class MergeIntervals {
    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1, 3}, {5, 9}, {20, 30}, {2, 6}};
        int[][] expected = new int[][]{{1, 6}, {5, 9}, {20, 30}};
        System.out.print("{");
        Arrays.stream(mergeIntervals(intervals)).forEach(entry -> {
            System.out.print("{");
            Arrays.stream(entry).forEach(elem -> {
                System.out.print(elem + ",");
            });
            System.out.print("},");
        });
        System.out.println("}");

        //check any start which is starting after thisstart
        // if newend = max(thisEnd, end)
        // remove overlapping
    }

    static int[][] mergeIntervals(int[][] intervals) {
        int eliminated = 0;
        //Assuming array is sorted
        for (int i = 0; i < intervals.length; i++) {
            for (int j = i + 1; j < intervals.length; j++) {
                if (intervals[i][0] <= intervals[j][0] && intervals[i][1] >= intervals[j][0]) {
                    intervals[i][1] = Math.max(intervals[i][1], intervals[j][1]);
                    eliminated++;
                }
            }
        }

        return Arrays.copyOf(intervals, intervals.length - eliminated);
    }
}
