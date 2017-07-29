package algo.bit;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AorBAttempt2 {
	static Map<Character, boolean[]> charHex;
	static Map<String, Character> bitChar;

	static void init() {
		charHex = new HashMap<>();
		bitChar = new HashMap<>();
		for (int i = 0; i < 16; i++) {
			boolean[] bits = getBits(i);
			char charAt = Integer.toHexString(i).toUpperCase().charAt(0);
			charHex.put(charAt, bits);
			bitChar.put(getBitString(bits), charAt);
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int q = s.nextInt();
		init();

		for (int i = 0; i < q; i++) {
			int k = s.nextInt();
			String a = s.next().trim();
			String b = s.next().trim();
			String c = s.next().trim();

			aOrB(k, a, b, c);
		}

		s.close();

	}

	private static String getBitString(boolean[] bits) {
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < bits.length; i++) {
			sb.append(bits[i] ? 1 : 0);
		}
		return sb.toString();
	}

	private static boolean[] getBits(int num) {
		boolean[] arr = new boolean[4];
		for (int i = 3; i >= 0; i--) {
			arr[3 - i] = ((1 << i) & num) != 0;
		}
		return arr;
	}

	private static void aOrB(int k, String a, String b, String c) {
		boolean noSolution = false;
		boolean[] aOa = new boolean[a.length() * 4];
		boolean[] bOa = new boolean[b.length() * 4];

		OUTER: for (int i = 0; i < a.length(); i++) {
			char aC = a.charAt(i);
			char bC = b.charAt(i);
			char cC = c.charAt(i);

			boolean[] aH = getHexBits(aC);
			boolean[] bH = getHexBits(bC);
			boolean[] cH = getHexBits(cC);

			for (int j = 0; j < 4; j++) {
				if ((aH[j] | bH[j]) != cH[j]) {
					if (cH[j]) {
						if (k == 0) {
							noSolution = true;
							break OUTER;
						}
						bH[j] = true;
						k--;
					} else {
						if (aH[j]) {
							if (k == 0) {
								noSolution = true;
								break OUTER;
							}
							aH[j] = false;
							k--;
						}
						if (bH[j]) {
							if (k == 0) {
								noSolution = true;
								break OUTER;
							}
							bH[j] = false;
							k--;
						}
					}
				}
			}

			int startIndex = i * 4;
			for (int l = startIndex, m = 0; l < startIndex + 4; l++, m++) {
				aOa[l] = aH[m];
				bOa[l] = bH[m];
			}
		}

		if (k > 0) {
			for (int i = 0; i < aOa.length; i++) {
				if (aOa[i] && bOa[i]) {
					if (k == 0) {
						break;
					}
					aOa[i] = false;
					k--;
				} else if (aOa[i] && !bOa[i]) {
					if (k == 1) {
						continue;
					}
					if (k == 0) {
						break;
					}
					aOa[i] = false;
					bOa[i] = true;
					k -= 2;
				}
			}
		}
		if (noSolution) {
			System.out.println(-1);
		} else {
			System.out.println(new BigInteger(getBitString(aOa), 2).toString(16).toUpperCase());
			System.out.println(new BigInteger(getBitString(bOa), 2).toString(16).toUpperCase());
		}

	}

	private static boolean[] getHexBits(char aC) {
		return Arrays.copyOf(charHex.get(aC), 4);
	}

}
