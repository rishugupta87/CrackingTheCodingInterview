package arraysstrings.Q1_06_String_Compression;

/**
 *
 * String Compression: Implement a method to perform basic string compression using the counts of
 * repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the "compressed"string
 * would not become smaller than the original string, your method should return the original string. You can
 * assume the string has only uppercase and lowercase letters (a - z).
 */
public class StringCompression {
    /**
     *
     *  solution creates the compressed string first and then return the shorter of the input string and the compressed string.
     *
     * Time = O(n) where n is the length of the string
     * Space = O(1)
     *
     * @param s
     * @return
     */
    public static String compressString(final String s) {

        if(s == null || s.length() == 0) {
            return null;
        }
        if(s.length() == 1) {
            return s; //since compressed string cannot be shorter than original in this case
        }
        char[] chars = s.toCharArray();
        int i = 0; int j = 1;
        StringBuilder sb = new StringBuilder();

        while (j < chars.length) {
            sb.append(chars[i]);
            int count = 1;
            while (j < chars.length && chars[i] == chars[j]) {
                count++;
                j++;
            }
            sb.append(String.valueOf(count));
            i = j;
            j = i+1;
        }
        String compressedString = sb.toString();

        return s.length() < compressedString.length() ? s : compressedString;
    }

    public static String compress_ccisolution(String str) {
        StringBuilder compressed = new StringBuilder();
        int countConsecutive = 0;
        for (int i = 0; i < str.length(); i++) {
            countConsecutive++;

			/* If next character is different than current, append this char to result.*/
            if (i + 1 >= str.length() || str.charAt(i) != str.charAt(i + 1)) {
                compressed.append(str.charAt(i));
                compressed.append(countConsecutive);
                countConsecutive = 0;
            }
        }
        return compressed.length() < str.length() ? compressed.toString() : str;
    }

    public static void main(String[] args) {
        String s1 = "aabcccccaaa";
        String s2 = "abcdefghi";
        System.out.println(StringCompression.compressString(s1));
        System.out.println(StringCompression.compressString(s2));
    }
}
