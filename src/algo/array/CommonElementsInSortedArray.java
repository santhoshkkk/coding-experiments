package algo.array;

import java.util.Arrays;
import java.util.stream.Collectors;

public class CommonElementsInSortedArray {
    public static void main(String[] args) {
        int[] common = commonElements(new int[]{1, 4, 7, 19, 100}, new int[]{1, 2, 4, 5, 7, 20, 100, 105});
        System.out.println(Arrays.stream(common).boxed().collect(Collectors.toList()));
    }

    private static int[] commonElements(int[] first, int[] second) {
        //Using a list to store the output will simplify the problem
        int[] common = new int[Math.min(first.length, second.length)];
        int commonIndex = 0;
        for (int firstIndex = 0, secondIndex = 0; firstIndex < first.length && secondIndex < second.length; ) {
            //Check the elements at current index
            int firstItem = first[firstIndex];
            int secondItem = second[secondIndex];
            if (firstItem == secondItem) {
                common[commonIndex] = firstItem;
                commonIndex++;
                firstIndex++;
                secondIndex++;
            } else if (firstItem < secondItem) {
                firstIndex++;
            } else {
                secondIndex++;

            }
        }
        return Arrays.copyOf(common, commonIndex);
    }
}
