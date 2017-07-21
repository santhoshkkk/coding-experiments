package algo.impl;

import java.util.Scanner;

public class ApplesNOranges {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int s = in.nextInt();
		int t = in.nextInt();
		int a = in.nextInt();
		int b = in.nextInt();
		int m = in.nextInt();
		int n = in.nextInt();
		int[] apple = new int[m];
		int applesOnHouse = 0;
		for (int apple_i = 0; apple_i < m; apple_i++) {
			apple[apple_i] = in.nextInt();
			int fallPoint = apple[apple_i] + a;
			if (fallPoint >= s && fallPoint <= t) {
				applesOnHouse++;
			}
		}
		System.out.println(applesOnHouse);
		int[] orange = new int[n];
		int orangesOnHouse = 0;
		for (int orange_i = 0; orange_i < n; orange_i++) {
			orange[orange_i] = in.nextInt();
			int fallPoint = b + orange[orange_i];
			if (fallPoint <= t && fallPoint >= s) {
				orangesOnHouse++;
			}
		}

		System.out.println(orangesOnHouse);

		in.close();
	}
}
