package algo.impl;

import java.util.Scanner;

public class KangarooJump {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int v1 = in.nextInt();
		int x2 = in.nextInt();
		int v2 = in.nextInt();
		kangaroo(x1, v1, x2, v2);
		in.close();
	}

	private static void kangaroo(int x1, int v1, int x2, int v2) {
		while (true) {
			x1 = x1 + v1;
			x2 = x2 + v2;
			if (x1 == x2) {
				System.out.println("YES");
				break;
			} else {
				if (x1 >= x2 && v1 >= v2) {
					System.out.println("NO");
					break;
				} else if (x1 <= x2 && v1 <= v2) {
					System.out.println("NO");
					break;
				}
			}
		}
	}

}
