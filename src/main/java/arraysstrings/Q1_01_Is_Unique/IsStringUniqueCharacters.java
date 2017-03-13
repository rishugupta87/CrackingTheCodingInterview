package arraysstrings.Q1_01_Is_Unique;

/**
 * Is Unique: Implement an algorithm to determine if a string has all unique characters.
 * What if you cannot use additional data structures?
 */
public class IsStringUniqueCharacters {

    /**
     *
     * It's also okay to assume 256 characters. This would be the case in extended ASCII.
     * Self explanatory method
     *
     * T(n) = O(n) = O(1) = since we know the str length <= 256 the loop is max for 256
     * Space: = O(1) = since we know the extra space of boolean cant exceed 256
     *
     *  If you didn't want to assume the character set is fixed, you could express the complexity
     *  as o(c)space and 0(min(c, n)) or 0(c)time, where c is the size of the character set.
     *
     * @param str
     * @return
     */
    public static boolean isUniqueChars(String str) {
        if (str.length() > 256) { //we cant form a string of more than 256 characters without having duplicates.
            return false;
        }
        boolean[] char_set = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i); //returns ascii value of character
            if (char_set[val]) return false;
            char_set[val] = true;
        }
        return true;
    }

    /**
     * We can reduce our space usage by a factor of eight by using a bit vector. We will assume, in the below code,
     * that the string only uses the lowercase letters a through z.This will allow us to use just a single int
     */
    public static boolean isUniqueChars2(String str) {
        if (str.length() > 26) { // Only 26 characters
            return false;
        }
        int checker = 0;
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i) - 'a';
            if ((checker & (1 << val)) > 0) return false;
            checker |= (1 << val);
        }
        return true;
    }

    public static void main(String[] args) {
        String[] words = {"abcde", "hello", "apple", "kite", "padle"};
        for (String word : words) {
            System.out.println(word + ": " + isUniqueChars2(word));
        }
    }
}
