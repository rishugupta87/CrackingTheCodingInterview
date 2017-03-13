package arraysstrings.Q1_04_Palindrome_Permutation;

import java.util.HashMap;
import java.util.Map;

/**

 Given a string, write a function to check if it is a permutation of a palin- drome. A palindrome is a word or phrase that is the same forwards and backwards.
 A permutation is a rearrangement of letters.The palindrome does not need to be limited to just dictionary words.
 EXAMPLE
 Input: Tact Coa
 Output: True (permutations: "taco cat". "atco cta". etc.)
 */
public class PalindromePermutation {

    /**
     *
     * Ask interviewer: Is the palindrome case sensitive i.e "abcbA" is this palindrome ?
     *
     * Idea1 : Generate all permutations of a string and check if one of them is a palindrome.
     *         However this is very inefficient
     *
     * Idea2;

     To be more precise, strings with even length (after removing all non-letter characters) must have all even counts of characters.
     Strings of an odd length must have exactly one character with an odd count. Of course, an "even" string can't have an odd number of exactly one character,
     otherwise it wouldn't be an even-length string (an odd number + many even numbers =an odd number). Likewise, a string with odd length can't have all characters
     with even counts (sum of evens is even). It's therefore sufficient to say that, to be a permutation of a palindrome, a string can have no more than one character that is odd.
     This will cover both the odd and the even cases
     *
     * @param s
     * @return
     */
    public static boolean isPalindromePermutation(final String s) {
        if(s == null || s.length() == 0) {
            return false;
        }

        Map<Character, Integer> map = new HashMap<Character, Integer>();

        char[] chars = s.toCharArray();
        for(char c : chars) {
            if(c == ' ') {
                continue;
            }
            char lowerChar = Character.toLowerCase(c);
            map.put(lowerChar, map.get(lowerChar) != null ? map.get(lowerChar) + 1 : 1);
        }

        boolean isOnlyOneOddVal = false;
        boolean foundOneOddAtleast = false;
        for(int val : map.values()) {
            if(val % 2 == 0) {
                continue;
            }
            foundOneOddAtleast = true;

            if(!isOnlyOneOddVal) {
                isOnlyOneOddVal = true;
            } else {
                isOnlyOneOddVal = false;
                break;
            }
        }
        if(!foundOneOddAtleast) {
            return true;
        }
        if(isOnlyOneOddVal) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        String s1 = "Tact Coa";
        String s2 = "abcba";
        String s3 = "abccba";
        String s4 = "Rishu Gupta";
        String s5 = "SonalLaNOS";
        String s6 = "SonalbaNOS";
        System.out.println(PalindromePermutation.isPalindromePermutation(s1));
        System.out.println(PalindromePermutation.isPalindromePermutation(s2));
        System.out.println(PalindromePermutation.isPalindromePermutation(s3));

        System.out.println(PalindromePermutation.isPalindromePermutation(s4));
        System.out.println(PalindromePermutation.isPalindromePermutation(s5));
        System.out.println(PalindromePermutation.isPalindromePermutation(s6));
    }
}
