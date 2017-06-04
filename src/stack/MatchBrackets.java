package stack;

import java.util.Scanner;

public class MatchBrackets {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		MyStack stack = new MyStack();
		for (int a0 = 0; a0 < t; a0++) {
			String s = in.next();
			stack.clear();
			boolean matching = true;
			for (int i = 0; i < s.length(); i++) {
				Character c = s.charAt(i);
				if (c == '{' || c == '[' || c == '(') {
					stack.push(c);
				} else if (c == '}' || c == ']' || c == ')') {
					if (!stack.isEmpty()) {
						stack.pop();
					} else {
						matching = false;
					}
				}
			}
			if (matching && stack.isEmpty()) {
				System.out.println("YES");
			} else {
				System.out.println("NO");
			}

		}
		in.close();
	}
}

class MyStack {
	Character[] data = new Character[1000];
	int top = -1;

	boolean isEmpty() {
		return top == -1;
	}

	Character top() {
		return data[top];
	}

	Character pop() {
		return data[top--];
	}

	void push(Character newdata) {
		data[++top] = newdata;
	}

	void clear() {
		top = -1;
	}

	public MyStack clone() {
		MyStack newStack = new MyStack();
		newStack.data = this.data.clone();
		newStack.top = this.top;
		return newStack;
	}

}
