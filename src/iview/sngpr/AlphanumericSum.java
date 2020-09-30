package iview.sngpr;

public class AlphanumericSum {
    static int sumOfLetters(String input) {
        int sum = 0;
        if (null == input) {
            return sum;
        }
        char[] inputArray = input.toCharArray();
        for (int i = 0; i < inputArray.length; i++) {
            sum += isVowel(inputArray[i]) ? 1 : 2;
        }
        return sum;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }

    public static void main(String[] args) {
        System.out.println(sumOfLetters("lowercase"));
    }
}
