package arraysstrings.Q1_02_Check_Permutation;

import java.util.Arrays;

/**
 *
 * Check Permutation: Given two strings, write a method to decide if one is a permutation of the other.
 *

 Like in many questions, we should confirm some details with our interviewer.
 - if the permutation comparison is case sensitive. That is: is God a permutation of dog?
 - Additionally, we should ask if whitespace is significant. We will assume for this problem that the comparison is
   case sensitive and whitespace is significant. So, "god " is different from "dog".
 - Observe first that strings of different lengths cannot be permutations of each other.
 */
public class AreStringPermutations {

    /**
     * We can just sort the two strings and compare both strings in order
     *
     * T(n) = O(nlogn)
     *
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean isStringsPermuations(final String  str1, final String str2) {
        if(str1.length() != str2.length()) {
            return false;
        }

        String s1 = sort(str1);
        String s2 = sort(str2);

        if(s1.equals(s2)) {
            return true;
        }
        return false;
    }

    private static String sort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }

    public static void main(String[] args) {
        System.out.println(AreStringPermutations.isStringsPermuations("Rishu", "shuir"));
    }
}
