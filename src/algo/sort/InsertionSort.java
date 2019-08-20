package algo.sort;

import static algo.sort.SortUtils.getNumbersFromUser;
import static algo.sort.SortUtils.randomlyGetNumbers;

public class InsertionSort {

    private static void exchange(int[] data, int i, int j) {
        Integer temp = data[i];
        data[i] = data[j];
        data[j] = temp;
    }

    public static void sort(int[] data) {
        for (int i = 0; i < data.length; i++) {
            int min = data[i];
            int minIndex = i;
            for (int j = i + 1; j < data.length; j++) {
                if (min > data[j]) {
                    min = data[j];
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                exchange(data, i, minIndex);
            }
        }
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
