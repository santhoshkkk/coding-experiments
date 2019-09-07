package algo.array;

public class RotateMatrixInPlace {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotateInPlace(matrix);

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                System.out.print(matrix[r][c] + " ");
            }
            System.out.println();
        }
    }

    private static void rotateInPlace(int[][] matrix) {

        int length = matrix.length;
        int subArrayMaxRows = (int) Math.floor(length / 2);
        int subArrayMaxCols = (int) Math.ceil((float) length / 2);
        int[] temp = new int[4];
        for (int r = 0; r < subArrayMaxRows; r++) { //O(r)
            for (int c = 0; c < subArrayMaxCols; c++) { //O(k)
                int[] currentIndex = {r, c};
                for (int k = 0; k < 4; k++) {
                    temp[k] = matrix[currentIndex[0]][currentIndex[1]];
                    currentIndex = computeTargetIndex(currentIndex, length);
                }

                currentIndex[0] = r;
                currentIndex[1] = c;
                for (int k = 0; k < 4; k++) {
                    matrix[currentIndex[0]][currentIndex[1]] = temp[(3 + k) % 4];
                    currentIndex = computeTargetIndex(currentIndex, length);
                }

            }
        }
    }

    private static int[] computeTargetIndex(int[] oldIndex, int length) {
        int[] newIndex = new int[2];
        newIndex[0] = oldIndex[1];
        newIndex[1] = (length - 1) - oldIndex[0];
        return newIndex;
    }
}
