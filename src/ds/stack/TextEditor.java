package ds.stack;

import java.util.Scanner;
import java.util.Stack;

public class TextEditor {

	public static void main(String[] args) {
		Editor editor = new Editor();
		Scanner s = new Scanner(System.in);
		int ops = s.nextInt();
		for (int i = 0; i < ops; i++) {
			int cmd = s.nextInt();
			Operation op = new Operation();
			op.command = cmd;
			switch (cmd) {
			case 1:
				String word = s.next();
				op.data = word;

				break;
			case 2:
			case 3:
				int index = s.nextInt();
				op.data = index;
				break;
			case 4:
				break;
			}
			editor.performOperation(op);
		}
		s.close();
	}

}

class Editor {
	StringBuffer text = new StringBuffer();
	Stack<Operation> undoStack = new Stack<Operation>();
	int current = -1;

	void performOperation(Operation op) {
		switch (op.command) {
		case 1:
			append(op);
			break;
		case 2:
			delete(op);
			break;
		case 3:
			print(op);
			break;
		case 4:
			undo(op);
			break;
		}
	}

	void append(Operation o) {
		String word = (String) o.data;
		text.append(word);
		undoStack.push(o);
	}

	void delete(Operation o) {
		int length = text.length();
		Integer removeLength = (Integer) o.data;

		if (removeLength > length) {
			removeLength = length;
		}
		int start = (length - removeLength);
		int end = length;
		String removedText = text.substring(start, end);
		o.undoData = removedText;
		text.delete(start, end);
		undoStack.push(o);
	}

	void print(Operation o) {
		Integer k = (Integer) o.data;
		if (k <= text.length()) {
			System.out.println(text.charAt(k-1));
		}
	}

	void undo(Operation o) {
		Operation u = undoStack.pop();
		if (null != u) {
			switch (u.command) {
			case 1:
				undoAppend(u);
				break;
			case 2:
				undoDelete(u);
				break;
			}
		}

	}

	private void undoDelete(Operation u) {
		String delText = (String) u.undoData;
		text.append(delText);
	}

	private void undoAppend(Operation u) {
		String appendedString = (String) u.data;
		int start = text.length() - appendedString.length();
		text.delete(start, text.length());
	}
}

class Operation {
	int command;
	Object data;
	Object undoData;
}
