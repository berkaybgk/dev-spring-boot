import java.util.Arrays;

public class LongestSubstring {
    public static void main(String[] args) {
        String string = "abcabcaa";
        System.out.println(cleanerSolution(string));;
    }

    public static int cleanerSolution(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int maxLengthOfSubstrings = 0;

        for (int i = 0; i<s.length(); i++) {
            String tempSubString = s.charAt(i) + "";
            for (int j = i+1; j <s.length(); j++ ) {
                CharSequence currentChar = s.charAt(j) + "";

                // if the substring will be repeating after this char
                if (tempSubString.contains(currentChar)) {
                    if (tempSubString.length()>maxLengthOfSubstrings)
                        maxLengthOfSubstrings = tempSubString.length();
                    break;
                }

                // if the substring won't be repeating after this char
                else {
                    tempSubString += currentChar;
                    if ((j == s.length()-1) && (tempSubString.length() > maxLengthOfSubstrings)) {
                        maxLengthOfSubstrings = tempSubString.length();
                        break;
                    }
                }
            }
        }
        return maxLengthOfSubstrings;
    }

    public static int solution(String string) {
            String[] nonRepeatingSubStrings = new String[string.length()];
            int counter = 0;

            for (int i = 0; i<string.length(); i++) {
                String tempSubString = string.charAt(i) + "";
                for (int j = i+1; j <string.length(); j++ ) {
                    CharSequence currentChar = string.charAt(j) + "";

                    // if the substring will be repeating after this char
                    if (tempSubString.contains(currentChar)) {
                        nonRepeatingSubStrings[counter++] = tempSubString;
                        break;
                    }
                    // if the substring won't be repeating after this char
                    else {
                        tempSubString += currentChar;
                        if (j == string.length()-1) {
                            nonRepeatingSubStrings[counter++] = tempSubString;
                            break;
                        }
                    }
                }
                if (string.length() == 1) {
                    return 1;
                }
            }

            int longestStringLength = 0;

            for (int i = 0; i<nonRepeatingSubStrings.length; i++) {
                String currentString = nonRepeatingSubStrings[i];
                if (currentString == null) {
                    break;
                }
                // if the string is longer than what has been searched so far
                if (currentString.length() > longestStringLength) {
                    longestStringLength = currentString.length();
                }
            }

            return longestStringLength; // the longest string in the array;
        }

}
