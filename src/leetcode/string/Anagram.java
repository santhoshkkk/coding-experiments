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

        int[] charCount = new int[26];
        for(int i=0; i<s.length(); i++){
            charCount[s.charAt(i)-'a']++;
            charCount[t.charAt(i)-'a']--;
        }
        for(int i=0; i<charCount.length; i++){
            if(charCount[i]<0){
                return false;
            }
        }

        return true;
    }

}
