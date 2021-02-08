package leetcode.string;

public class FistUniqueCharacter {
    public static void main(String[] args) {
        System.out.println(firstUniqueChar("leetcode"));
        System.out.println(firstUniqueChar("jadeja"));
        System.out.println(firstUniqueChar("anna"));

    }

    public static int firstUniqueChar(String s) {
        boolean duplicate = false;
        for (int i = 0; i < s.length(); i++) {
            duplicate = false;
            for (int j = 0; j < s.length(); j++) {
                if (i != j && s.charAt(i) == s.charAt(j)) {
                    duplicate = true;
                    break;
                }
            }
            if (!duplicate) {
                return i;
            }
        }
        return -1;

    }
}
