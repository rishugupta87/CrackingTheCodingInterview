package recursiondynamicprogramming.Q8_07_Permutations_Without_Dups;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a method to compute all permutations of a string of unique characters.\
 */
public class StringPermutationsUniqueCharacters_Approach1 {

    /**
     * Building from permutations of first n-1 characters.
     *
       Therefore, if we took all the permutations of abc and added d into all possible locations, we would get all
       permutations of abcd. See notes
     *
     * @param str
     * @return
     */
    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }
        return generatePermutations(str);
    }

    private static ArrayList<String> generatePermutations(final String str) {
        if(str.length() == 1) {
            ArrayList<String> permutations = new ArrayList<String>();
            permutations.add(String.valueOf(str.charAt(0)));
            return permutations;
        }
        char first = str.charAt(0);
        String remainString = str.substring(1);
        ArrayList<String> remainPermutations = generatePermutations(remainString);
        ArrayList<String> modifiedPermuations = insertCharacterAtEachRemainPermutation(first, remainPermutations);

        return modifiedPermuations;
    }

    private static ArrayList<String> insertCharacterAtEachRemainPermutation(final char first,
                                                                       final List<String> remainPermutations) {
        ArrayList<String> modifiedPermutations = new ArrayList<String>();

        /**
         *
         * Logic to insert a character at each position of string
         *
         *  Example remainPermutation = abc
         *  first = d
         *
         *   index   start(remainPermutation.substring(0, i))   end(remainPermutation.substring(i))
         *   0       ""                                         abc
         *   1       a                                          bc
         *   2       ab                                         c
         *   3       abc                                        ""
         *
         */
        for(String remainPermutation: remainPermutations) { // remainPermutations = ["cd", "dc"], first = b
            for(int i = 0 ; i <=remainPermutation.length(); i++) {
                String start = remainPermutation.substring(0, i);
                String end = remainPermutation.substring(i);
                modifiedPermutations.add(start + first + end);
            }
        }
        return modifiedPermutations;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abcd");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
