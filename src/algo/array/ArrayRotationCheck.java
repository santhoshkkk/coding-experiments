package algo.array;

//Check one array is a rotation of another Array
public class ArrayRotationCheck {
    public static void main(String[] args) {
        System.out.println(isRotation(new int[]{1, 2, 3, 4, 5}, new int[]{4, 5, 1, 2, 3}));
        System.out.println(isRotation(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 1, 2, 3}));
        System.out.println(isRotation(new int[]{1, 2, 3, 4, 5}, new int[]{4, 1, 2, 3}));
        System.out.println(isRotation(new int[]{}, new int[]{}));
    }

    private static boolean isRotation(int[] first, int[] second) {
        boolean rotation = true;
        if (first.length != second.length) {
            rotation = false;
        } else if (first.length > 0) {
            int firstArrayFirstElementIndexInSecondArray = find(second, first[0]);

            if (firstArrayFirstElementIndexInSecondArray == -1) {
                rotation = false;
            } else {
                for (int secondIndex = firstArrayFirstElementIndexInSecondArray, firstIndex = 0; firstIndex < first.length; firstIndex++, secondIndex = ((secondIndex + 1) % second.length)) {
                    if (first[firstIndex] != second[secondIndex]) {
                        rotation = false;
                        break;
                    }
                }
            }
        }
        return rotation;
    }

    private static int find(int[] second, int candidate) {
        for (int i = 0; i < second.length; i++) {
            if (second[i] == candidate) {
                return i;
            }
        }
        return -1;
    }
}
