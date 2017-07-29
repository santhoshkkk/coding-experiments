package algo.bit;

import java.util.Scanner;

public class AorB {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
//		long a = s.nextLong(16);
//		boolean[] ar = getBinaryArray(a);
//		for(int i=0;i<64;i++){
//			System.out.print(ar[i]?1:0);
//		}
		
		for (int i = 0; i < q; i++) {
			int k = s.nextInt();
			long a = s.nextLong(16);
			long b = s.nextLong(16);
			long c = s.nextLong(16);
			aOrB(k, a, b, c);
		}

		s.close();

	}

	private static void aOrB(int k, long a, long b, long c) {
		boolean[] cr = getBinaryArray(c);
		boolean[] ar = getBinaryArray(a);
		boolean[] br = getBinaryArray(b);

		boolean noSol = false;

		for (int i = 63; i >= 0; i--) {
			if ((ar[i] | br[i]) != cr[i]) {
				if (cr[i]) {
					if (k == 0) {// both ar and br are 0 make br 1
						noSol = true;
						break;
					}
					br[i] = true;
					k--;
				} else {
					if (ar[i]) {
						if (k == 0) {// both ar and br are 0 make br 1
							noSol = true;
							break;
						}
						ar[i] = false;
						k--;
					}
					if (br[i]) {
						if (k == 0) {// both ar and br are 0 make br 1
							noSol = true;
							break;
						}
						br[i] = false;
						k--;
					}
				}
			}
		}

		if (noSol) {
			System.out.println(-1);
		} else {
			System.out.println(getHex(ar));
			System.out.println(getHex(br));
		}

	}

	private static String getHex(boolean[] ar) {
		long num = 0;
		for (int i = 63; i >= 0; i--) {
			if (ar[i]) {
				num += Math.pow(2, i);
			}
		}
		return Long.toHexString(num);
	}

	private static boolean[] getBinaryArray(long c) {
		boolean[] bin = new boolean[64];
		for (int i = 63; i >= 0; i--) {
			bin[i] = (c & (1l << i)) != 0;
		}
		return bin;
	}

}
