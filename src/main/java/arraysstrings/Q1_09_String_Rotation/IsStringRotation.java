package arraysstrings.Q1_09_String_Rotation;

/**
 *
 Assume you have amethod isSubstring which checks ifone word is asubstring of another.
 Given two strings, 51 and 52, write code to check if 52 is a rotation of 51 using only one call to isSubstring
 (e.g.,"waterbottle"is a rotation of"erbottlewat").
 */
public class IsStringRotation {

    /**
     *
     *  If we imagine that 52 is a rotation of 51, then we can ask what the rotation point is. For example,
     *  if you rotate waterbottle after wat, you get erbottlewat. In a rotation, we cut 51 into two parts, x and y,
     *  and rearrange them to get 52.
     *  51 =xy =waterbottle x =wat
     *  y =erbottle
     *  52 =yx =erbottlewat
     *
     *  So, we need to check if there's a way to split 51 into x and y such
     *  that xy = 51 and yx = 52. Regardless of where the division between x and y is,
     *  we can see that yx will always bea substring ofxyxy.That is, 52 will always be a substring of 5151.
     *
     * @param big
     * @param small
     * @return
     */
    public static boolean isSubstring(String big, String small) {
        if (big.indexOf(small) >= 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isRotation(String s1, String s2) {
        int len = s1.length();
	    /* check that s1 and s2 are equal length and not empty */
        if (len == s2.length() && len > 0) {
	    	/* concatenate s1 and s1 within new buffer */
            String s1s1 = s1 + s1;
            return isSubstring(s1s1, s2);
        }
        return false;
    }

    public static void main(String[] args) {
        String[][] pairs = {{"apple", "pleap"}, {"waterbottle", "erbottlewat"}, {"camera", "macera"}};
        for (String[] pair : pairs) {
            String word1 = pair[0];
            String word2 = pair[1];
            boolean is_rotation = isRotation(word1, word2);
            System.out.println(word1 + ", " + word2 + ": " + is_rotation);
        }
    }
}
