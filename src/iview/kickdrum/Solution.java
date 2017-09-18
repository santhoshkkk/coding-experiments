package iview.kickdrum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	private static final String DELIMITER = ",";

	static void fancySort(String[] exps) {
		List<Expr> exprs = new ArrayList<>(exps.length);
		for (int i = 0; i < exps.length; i++) {
			Expr exp;
			try {
				exp = new Solution.Expr(exps[i]);
			} catch (Exception e) {
				continue;
			}
			exprs.add(exp);
		}

		Collections.sort(exprs, new ExprComparator());

		for (Expr expr : exprs) {
			System.out.println(expr);
		}

	}

	static class Expr {
		String raw;
		int value;

		public Expr(String raw) throws Exception {
			this.raw = raw;
			value = evaluate(raw);
		}

		private int evaluate(String raw2) throws Exception {
			int val = 0;
			// parse
			String[] tokens = raw.split(DELIMITER);
			String operation = tokens[0];
			// get operation

			switch (operation) {
			case "ADD":
				val = add(tokens);
				break;
			case "SUBTRACT":
				val = subtract(tokens);
				break;
			case "MULTIPLY":
				val = multiply(tokens);
				break;
			case "DIVIDE":
				val = divide(tokens);
				break;
			case "MIN":
				val = min(tokens);
				break;
			case "MAX":
				val = max(tokens);
				break;
			default:
				throw new UnsupportedOperationException();
			}
			// perform Operation
			return val;
		}

		private int max(String[] tokens) throws Exception {
			int max = Integer.parseInt(tokens[1]);
			int num = 0;
			for (int i = 2; i < tokens.length; i++) {
				num = Integer.parseInt(tokens[i]);
				max = max < num ? num : max;
			}
			return max;
		}

		private int min(String[] tokens) throws Exception {
			int min = Integer.parseInt(tokens[1]);
			int num = 0;
			for (int i = 2; i < tokens.length; i++) {
				num = Integer.parseInt(tokens[i]);
				min = min > num ? num : min;
			}
			return min;
		}

		private int divide(String[] tokens) throws Exception {
			int val = Integer.parseInt(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				val /= Integer.parseInt(tokens[i]);
			}
			return val;
		}

		private int multiply(String[] tokens) throws Exception {
			int prod = Integer.parseInt(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				prod *= Integer.parseInt(tokens[i]);
			}
			return prod;
		}

		private int subtract(String[] tokens) throws Exception {
			int diff = Integer.parseInt(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				diff -= Integer.parseInt(tokens[i]);
			}
			return diff;
		}

		private int add(String[] tokens) throws Exception {
			int sum = Integer.parseInt(tokens[1]);
			for (int i = 2; i < tokens.length; i++) {
				sum += Integer.parseInt(tokens[i]);
			}
			return sum;
		}

		public String toString() {
			return raw;
		}

	}

	static class ExprComparator implements Comparator<Expr> {
		@Override
		public int compare(Expr o1, Expr o2) {
			int diff = o1.value - o2.value;
			return diff != 0 ? diff : o1.raw.compareTo(o2.raw);
		}
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);

		int _exps_size = 0;
		_exps_size = Integer.parseInt(in.nextLine().trim());
		String[] _exps = new String[_exps_size];
		String _exps_item;
		for (int _exps_i = 0; _exps_i < _exps_size; _exps_i++) {
			try {
				_exps_item = in.nextLine();
			} catch (Exception e) {
				_exps_item = null;
			}
			_exps[_exps_i] = _exps_item;
		}

		fancySort(_exps);
		in.close();

	}

}
