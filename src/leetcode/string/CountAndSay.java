package leetcode.string;

public class CountAndSay {
    public static void main(String[] args) {
        for(int i=1; i<=30; i++) {
            System.out.println(countAndSay(i));
        }
    }

    private static String countAndSay(int n) {
        if (n <=1) {
            return "1";
        }
        String previous = countAndSay(n - 1);

        StringBuilder output = new StringBuilder();
        char[] chars = previous.toCharArray();

        char previousChar = chars[0];
        int charCount = 1;
        for (int i = 1; i < chars.length; i++) {
            if (previousChar == chars[i]) {
                charCount++;
            } else {
                output.append(charCount).append(previousChar);
                previousChar = chars[i];
                charCount = 1;
            }
        }
        output.append(charCount).append(previousChar);

        return output.toString();
    }
}
