package leetcode.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = new String[]{"flower", "flow", "flight"};
        System.out.println(longestPrefix(strs));
    }

    private static String longestPrefix(String[] strs) {
        StringBuilder prefix = new StringBuilder();

        char currentChar = 0;

        if (null == strs || strs.length == 0) {
            return prefix.toString();
        } else if (strs.length == 1) {
            return strs[0];
        } else {
            if (strs[0] == null || strs[0].length() == 0) {
                return prefix.toString();
            }

            for (int i = 0; i < strs[0].length(); i++) {
                currentChar = strs[0].charAt(i);
                boolean allMatch = true;
                for (int j = 1; j < strs.length; j++) {
                    if (strs[j].length() <= i) {
                        allMatch = false;
                        break;
                    }
                    if (strs[j].charAt(i) != currentChar) {
                        allMatch = false;
                        break;
                    }
                }
                if (allMatch) {
                    prefix.append(currentChar);
                } else {
                    break;
                }
            }
            return prefix.toString();
        }


    }
}
