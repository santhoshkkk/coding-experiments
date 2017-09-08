package iview.amazon;

import java.util.Scanner;

public class MatrixSpiral {

  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int r = s.nextInt();
    int c = s.nextInt();

    int[][] matrix = new int[r][c];
    for (int i = 0; i < r; i++) {
      for (int j = 0; j < c; j++) {
        matrix[i][j] = s.nextInt();
      }
    }

    int[] spiral = new int[r * c];
    toSpiral(matrix, 0, 0, r - 1, c - 1, spiral, 0);
    for (int i = 0; i < spiral.length; i++) {
      System.out.print(spiral[i] + " ");
    }

    s.close();
  }

  private static void toSpiral(int[][] matrix,
                               int sr,
                               int sc,
                               int er,
                               int ec,
                               int[] out,
                               int outIndex) {
    if (sr > er && sc > ec) {
      // square matrix termination condition
      return;
    }
    if (sr == er) {
      // extract row and return
      for (int j = sc; j <= ec; j++) {
        out[outIndex++] = matrix[sr][j];
      }
      return;
    } else if (sc == ec) {
      // extract column and return
      for (int i = sr; i <= er; i++) {
        out[outIndex++] = matrix[i][sc];
      }
      return;
    }

    // extract first row
    for (int j = sc; j <= ec; j++) {
      out[outIndex++] = matrix[sr][j];
    }

    // extract last column excluding first element
    for (int i = sr + 1; i <= er; i++) {
      out[outIndex++] = matrix[i][ec];
    }

    // if last row and first row are not same print last row in reverse
    // excluding first element
    for (int j = ec - 1; j >= sc; j--) {
      out[outIndex++] = matrix[er][j];
    }

    // if first column and last column are not same then print fist column in
    // reverse excluding first element
    for (int i = er - 1; i > sr; i--) {
      out[outIndex++] = matrix[i][sc];
    }

    int nsr = sr + 1;
    int nsc = sc + 1;
    int ner = er - 1;
    int nec = ec - 1;

    toSpiral(matrix, nsr, nsc, ner, nec, out, outIndex);
  }

}
