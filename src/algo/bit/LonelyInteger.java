package algo.bit;

import java.util.Scanner;

public class LonelyInteger {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();
		int xor = 0;
		for (int i = 0; i < n; i++) {
			xor = xor ^ s.nextInt();
		}
		System.out.println(xor);
		s.close();
	}

}
