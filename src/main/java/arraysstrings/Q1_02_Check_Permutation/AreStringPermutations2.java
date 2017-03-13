package arraysstrings.Q1_02_Check_Permutation;

public class AreStringPermutations2 {

    /**
     * Ask interviewer if the string is an ascii string
     * Assume 256 set character set
     *
     * Iterate over string1 character by character while counting no of times that character appeared,
     * for each character -> get its ascii value -> this will be index in array
     * increase count by 1
     *
     * Iterate over string2 character by character, array[ascii(character)]-- decrement the count by 1
     *
     * If they are permutations the value of of elements in array will be 0.
     *
     * @param str1
     * @param str2
     * @return
     */
    public static boolean permutation(String s, String t) {
        if (s.length() != t.length()) return false; // Permutations must be same length

        int[] letters = new int[256]; // Assumption: ASCII
        for (int i = 0; i < s.length(); i++) {
            letters[s.charAt(i)]++;
        }

        for (int i = 0; i < t.length(); i++) {
            letters[t.charAt(i)]--;
            if (letters[t.charAt(i)] < 0) {
                return false;
            }
        }

        return true; // letters array has no negative values, and therefore no positive values either
    }
}
