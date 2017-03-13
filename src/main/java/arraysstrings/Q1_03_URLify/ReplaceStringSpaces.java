package arraysstrings.Q1_03_URLify;

/**
 URLify: Write a method to replace all spaces in a string with '%20:
 You may assume that the string has sufficient space at the end to hold the additional characters,

 and that you are given the "true" length of the string. (Note: If implementing in Java, please use a character
 array so that you can perform this operation in place.)

 EXAMPLE
 Input: "Mr John Smith    " , 13
 Output: "Mr%20John%20Smith"
 */
public class ReplaceStringSpaces {
    /**
     *
     * A common approach in string manipulation problems is to edit the string starting from the end and working backwards.
     * This is useful because we have an extra buffer at the end, which allows us to change characters without worrying about what we're overwriting.
     *
     * We will use this approach in this problem.The algorithm employs a two-scan approach. In the first scan, we count the number of spaces. By
     * tripling this number, we can compute how many extra characters we will have in the final string. In the second pass, which is done in reverse order,
     * we actually edit the string.When we see a space, we replace it with %20. If there is no space, then we copy the original character.
     *
     *
     * @param s
     * @param len
     * @return
     */
    public static String replace(String s, int len) {
        if(s == null || s.length() == 0) {
            return null;
        }

        //count number of spaces in the string
        int noOfSpaces = 0;
        for(int i = 0 ; i < len; i++) {
            if(s.charAt(i) == ' ') {
                noOfSpaces++;
            }
        }
        int orgCharCount = len - noOfSpaces; // 13-2 = 11
        int lenRequired = 3* noOfSpaces + orgCharCount; // 3*2 + 11 = 17

        if(s.length() < lenRequired) { //not sufficient space at the end
            return null;
        }

        int index1 = len - 1; //point at last character of true string .
        int index2 = lenRequired - 1; //point at end

        char[] charArray = s.toCharArray();

        while(index1 < index2) {
            if(charArray[index1] != ' ') {
                charArray[index2--] = charArray[index1--];
            } else {
                index1--;
                charArray[index2--] = '0';
                charArray[index2--] = '2';
                charArray[index2--] = '%';
            }
        }

        return new String(charArray);
    }

    public static void main(String[] args) {
        String s = "Mr John Smith    ";
        System.out.println(ReplaceStringSpaces.replace(s, 13));
    }
}
