package ds.trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class GoodSetBadSet {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		CharTrieNode root = new CharTrieNode();
		root.data = ' ';
		root.matchCount = 0;
		for (int i = 0; i < count; i++) {
			String str = s.next();
			boolean valid = root.checkAndInsert(root, str);
			if (!valid) {
				System.out.println("BAD SET");
				System.out.println(str);
				s.close();
				return;
			}
		}
		System.out.println("GOOD SET");
		s.close();
	}

}

class CharTrieNode {
	// Holds a string with chars a to j
	char data;
	Map<Character, CharTrieNode> children = new HashMap<>(10);
	int matchCount = 1;
	boolean leaf;

	public boolean checkAndInsert(CharTrieNode node, String s) {
		boolean valid = true;
		List<CharTrieNode> nodes = new ArrayList<>();

		CharTrieNode child = node;
		boolean newChar = false;
		for (int i = 0; i < s.length(); i++) {
			Character charAt = s.charAt(i);
			if (node.children.containsKey(charAt)) {
				child = node.children.get(charAt);
				nodes.add(child);
			} else {
				// The existing string is a substring of the newone
				if (node.leaf) {
					return false;
				}
				child = new CharTrieNode();
				child.data = charAt;
				node.children.put(charAt, child);
				newChar = true;
			}
			node = child;
		}

		if (!newChar) {
			return false;
		}

		if (node.matchCount != 1 || newChar) {
			node.leaf = true;
			// duplicate do not increment count
			for (CharTrieNode node1 : nodes) {
				node1.matchCount++;
			}
		}

		return valid;

	}
}
