package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "agaamnr"));
        System.out.println(isAnagram("ram", "man"));
        System.out.println(isAnagram("ramm", "marr"));
        System.out.println(isAnagram(null, "man"));
        System.out.println(isAnagram("namm", "man"));
    }

    public static boolean isAnagram(String s, String t) {
        if(null == s || null == t || s.length() != t.length()){
            return false;
        }

        return(toCharCount(s).equals(toCharCount(t)));
    }

    private static Map<Character, Integer> toCharCount(String s){
        Map<Character, Integer> sChars = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            if(sChars.containsKey(s.charAt(i))){
                sChars.put(s.charAt(i), sChars.get(s.charAt(i))+1);
            }else {
                sChars.put(s.charAt(i), 1);
            }
        }
        return sChars;
    }
}
