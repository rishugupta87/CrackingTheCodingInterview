package arraysstrings.Q1_05_One_Away;

public class OneEditAway {

    /**
     *
     * We dont need to check for insert, delete and replace separately
     * can be handled in one function
     *
     * Idea:
     * First check both the string lengths should not differ more than 1
     * if both the string lengths are same its the case of replace, else insert/delete
     * - How to handle all in one function ?
     * - find longer vs shorter string, if both are same length consider any one as long
     * - compare characters in long string vs short string where index1 points to longer string and index2 points to shorter string
     * - if both the characters at each index match simply increment index1 and index2
     * - if both characters do not match ?
     *    - in case of replace increment both index1 and index2
     *    - in case of insert/delete just increment index1
     *    - note that you have encountered a mismatch so that next time you encounter another mismatch simply return false
     *
     *  Time = O(length(long)) note length of long and short can only differ by 1
     *
     * @param s1
     * @param s2
     * @return
     */
    public static boolean areOneEditAway(final String s1, final String s2) {
        if(s1 == null || s2 == null) {
            return false;
        }
        //string should not differ more than 1 in case of insert, replace, delete
        if(Math.abs(s1.length() - s2.length()) > 1) {
            return false;
        }
        return checkIfOneOffCharacterOnly(s1, s2);
    }

    private static boolean checkIfOneOffCharacterOnly(final String s1, final String s2) {
        String longStr;
        String shortStr;

        if(s1.length() >= s2.length()) {
            longStr = s1;
            shortStr = s2;
        } else {
            longStr = s2;
            shortStr = s1;
        }

        boolean isFirstCharOff = false;
        int index1 = 0; //pointing to long string
        int index2 = 0; //pointing to short string

        while(index1 < longStr.length() && index2 < shortStr.length()) {
            if(longStr.charAt(index1) == shortStr.charAt(index2)) {
                index1++;
                index2++;
                continue;
            }

            if(!isFirstCharOff) {
                isFirstCharOff = true;
                if(s1.length() == s2.length()) {
                    index1++;
                    index2++;
                } else {
                    index1++; //increment longer string
                }
            } else {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s1 = "pale";
        String s2 = "pales";
        String s3 = "psla";
        String s4 = "asla";


        System.out.println(OneEditAway.areOneEditAway(s1, s2));
        System.out.println(OneEditAway.areOneEditAway(s3, s4));

    }
}
