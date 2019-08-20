package algo.sort;

import static algo.sort.SortUtils.getNumbersFromUser;
import static algo.sort.SortUtils.randomlyGetNumbers;

public class QuickSort {
    public static void sort(int[] data) {
        sort(data, 0, data.length - 1);

    }

    private static void sort(int[] data, int start, int end) {
        if (start < end) {
            int partitionIndex = partition(data, start, end);
            sort(data, start, partitionIndex - 1);
            sort(data, partitionIndex + 1, end);
        }
    }

    private static int partition(int[] data, int start, int end) {
        Integer lastElement = data[end];
        int i = start - 1;
        for (int j = start; j < end; j++) {
            if (data[j] <= lastElement) {
                i = i + 1;
                exchange(data, i, j);
            }
        }
        exchange(data, i + 1, end);
        return i + 1;
    }

    private static void exchange(int[] data, int i, int j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void main(String[] args) {
        driveManual();
        driveUsingRandom();
    }

    private static void driveUsingRandom() {
        int[] data = randomlyGetNumbers();
        sort(data);
        SortUtils.printArray(data);
    }

    private static void driveManual() {
        int[] data = getNumbersFromUser();
        sort(data);
        SortUtils.printArray(data);
    }
}
