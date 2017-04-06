package recursiondynamicprogramming.Q8_07_Permutations_Without_Dups;

import java.util.ArrayList;

public class StringPermutationsUniqueCharacters_Approach2 {

    /**
     * Building from permutations of all n-1 character substring

     Need to "try" each character as the first character and then append the permutations.
     P(ala2a3) = { a1 + P(a2a3)} + a2 + P(ala3)} + a3 + P(ala2) }

     Example:
     {al + P(a2a3)} -) ala2a3, ala3a2
     {a2 + P(ala)} -) a2ala3, a2a3al
     {a3 + p(ala)} -) a3ala2, a3a2al
     *
     * @param str
     * @return
     */
    public static ArrayList<String> getPerms(String str) {
        if (str == null) {
            return null;
        }
        ArrayList<String> result = new ArrayList<String>();
        permutation("", str, result);
        return result;
    }

    private static ArrayList<String> permutation(String prefix, String str, ArrayList<String> result) {
        int n = str.length();
        if (n == 0)  {
            result.add(prefix);
        }

        for (int i = 0; i < n; i++) {
            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n), result);
        }
        return result;
    }

    public static void main(String[] args) {
        ArrayList<String> list = getPerms("abc");
        System.out.println("There are " + list.size() + " permutations.");
        for (String s : list) {
            System.out.println(s);
        }
    }
}
