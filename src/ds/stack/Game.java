package ds.stack;

import java.util.Scanner;

public class Game {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int g = in.nextInt();
		for (int a0 = 0; a0 < g; a0++) {
			int n = in.nextInt();
			int m = in.nextInt();
			int x = in.nextInt();
			int[] a = new int[n];
			for (int a_i = 0; a_i < n; a_i++) {
				a[a_i] = in.nextInt();
			}
			int[] b = new int[m];
			for (int b_i = 0; b_i < m; b_i++) {
				b[b_i] = in.nextInt();
			}
			// your code goes here
			findMoves(a, n, b, m, x);
		}
		in.close();
	}

	private static void findMoves(int[] a, int n, int[] b, int m, int max) {
		int aCount = 0;
		int bCount = 0;
		long sum = 0;
		
		while(aCount<n && sum + a[aCount] <= max){
			sum += a[aCount++];
		}
		
		int ans = aCount;
		while(bCount<m && aCount>=0){
			sum+=b[bCount++];
			while(aCount>0&& sum>max){
				sum-=a[--aCount];
			}
			
			if(sum<=max && aCount+bCount>ans){
				ans=aCount+bCount;
			}
		}
		System.out.println(ans);
	}
}
