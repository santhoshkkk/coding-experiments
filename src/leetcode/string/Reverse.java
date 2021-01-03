package leetcode.string;

public class Reverse {
    public static void main(String[] args) {
        char[] s1 = "I am a disco dancer".toCharArray();
        reverseString(s1);
        System.out.println(s1);

    }

    private static void reverseString(char[] s) {
        char temp;
        int swapIndex;
        for (int i = 0; i < s.length / 2; i++) {
            temp = s[i];
            swapIndex = (s.length - 1) - i;
            s[i] = s[swapIndex];
            s[swapIndex] = temp;
        }

    }
}
