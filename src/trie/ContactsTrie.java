package trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Scanner;

public class ContactsTrie {

	public static void main(String[] args) {

		Scanner s = new Scanner(System.in);
		int count = s.nextInt();
		TrieNode root = new TrieNode();
		root.data = ' ';
		root.matchCount = 0;
		for (int i = 0; i < count; i++) {
			String command = s.next();
			if (command.equals("find")) {
				String input = s.next();
				System.out.println(root.findPrefixMatchingCount(root, input));
			} else if (command.equals("add")) {
				String input = s.next();
				root.insert(root, input);
				root.bfs();
				System.out.println();
			}
		}
		s.close();
	}

}

class TrieNode {
	char data;
	Map<Character, TrieNode> children = new HashMap<>(26);
	int matchCount = 1;

	void insert(TrieNode node, String s) {
		List<TrieNode> nodes = new ArrayList<>();

		TrieNode child = node;
		boolean newChar = false;
		for (int i = 0; i < s.length(); i++) {
			Character charAt = s.charAt(i);
			if (node.children.containsKey(charAt)) {
				child = node.children.get(charAt);
				nodes.add(child);
			} else {
				child = new TrieNode();
				child.data = charAt;
				node.children.put(charAt, child);
				newChar = true;
			}
			node = child;
		}

		if (node.matchCount != 1 || newChar) {
			// duplicate do not increment count
			for (TrieNode node1 : nodes) {
				node1.matchCount++;
			}
		}

	}

	int findPrefixMatchingCount(TrieNode node, String subString) {
		for (int i = 0; i < subString.length(); i++) {
			Character charAt = subString.charAt(i);
			if (node.children.containsKey(charAt)) {
				node = node.children.get(charAt);
			} else {
				return 0;
			}
		}
		return node.matchCount;
	}

	void bfs() {
		Queue<TrieNode> q = new LinkedList<>();
		q.add(this);
		while (!q.isEmpty()) {
			TrieNode current = q.poll();
			System.out.print(" " + current.data + "(" + current.matchCount + ")");
			for (Character child : current.children.keySet()) {
				q.add(current.children.get(child));
			}
		}
	}
}
