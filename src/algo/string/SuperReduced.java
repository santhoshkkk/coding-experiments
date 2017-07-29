package algo.string;

import java.util.Scanner;

public class SuperReduced {

	static String super_reduced_string(String s) {
		StringBuilder r = new StringBuilder(s.length() / 2);
		int rI = -1;
		for (int i = 0; i < s.length();) {
			char charAt = s.charAt(i);
			if (i == s.length() - 1) {
				if (rI != -1 && r.charAt(rI) == charAt) {
					r.deleteCharAt(rI);
					rI = rI - 1;
					i = i + 1;
				} else {
					r.append(charAt);
					i = i + 1;
					rI = rI + 1;
				}
			} else {
				char charNext = s.charAt(i + 1);
				if (charAt == charNext) {
					i = i + 2;
				} else {
					if (rI != -1 && r.charAt(rI) == charAt) {
						r.deleteCharAt(rI);
						rI = rI - 1;
						i = i + 1;
					} else {
						r.append(charAt);
						i = i + 1;
						rI = rI + 1;
					}
				}
			}

		}

		return r.length() > 0 ? r.toString() : "Empty String";
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String result = super_reduced_string(s);
		System.out.println(result);
		in.close();
	}

}
