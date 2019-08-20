package algo.sort;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class SortUtils {
    public static int[] getNumbersFromUser() {
        Scanner scanner = new Scanner(System.in);

        int size = getSizeFromUser(scanner);

        int[] data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = scanner.nextInt();
        }

        return data;
    }

    private static int getSizeFromUser(Scanner scanner) {
        System.out.print("Enter the size of data: ");
        return scanner.nextInt();
    }

    public static void printArray(int[] data) {
        for (int i = 0; i < data.length; i++) {
            System.out.print(data[i] + " ");
        }
    }

    public static int[] randomlyGetNumbers() {
        Scanner scanner = new Scanner(System.in);
        int sizeFromUser = getSizeFromUser(scanner);
        return generateRandomArray(sizeFromUser);
    }

    private static int[] generateRandomArray(int size) {
        int[] data = new int[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt();
        }
        return data;
    }

    public static void main(String[] args) {
        System.out.println("Quick sort verses insertion sort performance comparison");
        int[] data = randomlyGetNumbers();

        int[] dataCopy = Arrays.copyOf(data, data.length);

        long quickSortStartTime = System.nanoTime();
        QuickSort.sort(data);
        long quickSortEndTime = System.nanoTime();
        System.out.println("Time taken by quick sort     :" + (quickSortEndTime - quickSortStartTime) + " ns");

        long insertionSortStartTime = System.nanoTime();
        InsertionSort.sort(dataCopy);
        long insertionSortEndTime = System.nanoTime();
        System.out.println("Time taken by insertion sort :" + (insertionSortEndTime - insertionSortStartTime) + " ns");

        System.out.println("Insertion sort took " + (insertionSortEndTime - insertionSortStartTime) / (float)(quickSortEndTime - quickSortStartTime) + " times more time");
    }

}
