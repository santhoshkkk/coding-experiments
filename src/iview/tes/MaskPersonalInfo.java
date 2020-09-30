package iview.tes;

import java.util.List;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class MaskPersonalInfo {
    public static final String EMAIL_REGEX = "\\S+@\\S+\\.\\S+";
    public static final String PHONE_REGEX = "[0-9]{10}";
    private final List<String> patternsToReplace;

    public MaskPersonalInfo(String... patterns) {
        this.patternsToReplace = List.of(patterns);
    }

    public static void main(String[] args) {
        MaskPersonalInfo maskPersonalInfo = new MaskPersonalInfo(EMAIL_REGEX, PHONE_REGEX);
        System.out.println(maskPersonalInfo.mask("String without personal info").equals("String without personal info") ? "PASS" : "FAIL");
        System.out.println(maskPersonalInfo.mask("String with email kksa22@gmail.com").equals("String with email ****************") ? "PASS" : "FAIL");
        System.out.println(maskPersonalInfo.mask("String with phone 9901152228").equals("String with phone **********") ? "PASS" : "FAIL");
        System.out.println(maskPersonalInfo.mask("String with phone 9901152228 and email kksa22@gmail.com").equals("String with phone ********** and email ****************") ? "PASS" : "FAIL");
    }

    public String mask(String input) {
        String[] modified = new String[1];
        modified[0] = input;
        if (null != input) {
            for (String pattern : patternsToReplace) {
                Stream<MatchResult> results = Pattern.compile(pattern).matcher(input).results();
                results.forEach(result -> {
                    String subString = modified[0].substring(result.start(), result.end());
                    modified[0] = modified[0].replace(subString, getMaskString(subString.length()));
                });
            }
        }
        return modified[0];
    }

    private CharSequence getMaskString(int length) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < length; i++) {
            stringBuilder.append("*");
        }
        return stringBuilder;
    }
}
