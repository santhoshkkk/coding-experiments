package algo.string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Anagrams {

	static Map<Integer, List<String>> lengthSubStrings;

	static int sherlockAndAnagrams(String s) {
		lengthSubStrings = new HashMap<>(s.length() / 2);
		int len = 2;
		// loadSubStrings
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 1; j <= s.length(); j++) {
				len = j - i;
				String sub = s.substring(i, j);
				// System.out.println(len + " " + sub);
				List<String> set = lengthSubStrings.get(len);
				if (null == set) {
					set = new ArrayList<>();
					lengthSubStrings.put(len, set);
				}
				set.add(sub);
			}
		}

		int count = 0;
		List<Character> strList = new ArrayList<Character>();
		List<Character> otherList = new ArrayList<Character>();
		for (int ln : lengthSubStrings.keySet()) {
			List<String> list = lengthSubStrings.get(ln);
			for (int i = 0; i < list.size(); i++) {
				for (int j = i + 1; j < list.size(); j++) {
					String str = list.get(i);
					String other = list.get(j);
					if (str != other && isAnagram(str, other, strList, otherList)) {
						// System.out.println(str);
						count++;
					}
				}
			}
		}

		return count;
	}

	private static boolean isAnagram(String str, String other, List<Character> strList, List<Character> otherList) {
		boolean ang = false;

		if (other.length() == str.length()) {
			for (Character c : other.toCharArray()) {
				otherList.add(c);
			}
			for (Character c : str.toCharArray()) {
				otherList.remove(c);
			}
			if (otherList.isEmpty()) {
				ang = true;
			}
		}
		strList.clear();
		otherList.clear();
		return ang;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			String s = in.next();
			int result = sherlockAndAnagrams(s);
			System.out.println(result);
		}
		in.close();
	}

}
