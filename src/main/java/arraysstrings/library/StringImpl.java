package arraysstrings.library;

public final class StringImpl { //make this class final so that we cant inherit this one, trying to make our custom string impl immutable.

    private char[] chars; //we back our string by a character array.
    private int size;

    public StringImpl(char[] chars) {
        this.chars = new char[chars.length];
        System.arraycopy(chars, 0, this.chars, 0, chars.length);
        size = chars.length;
    }

    public int length() {
        return size;
    }

    /**
     * This method returns the index within this string of the first occurrence of the specified
     * character or -1, if the character does not occur.
     *
     * @param ch
     * @return
     */
    public int indexOf(char ch) {
        //search for this character in the character array
        return indexOf(ch, 0);
    }

    /**
     * This method returns the index within this string of the first occurrence of the specified character,
     * starting the search at the specified index or -1, if the character does not occur.
     *
     * @param ch
     * @param fromIndex
     * @return
     */
    public int indexOf(int ch, int fromIndex) {
        for(int i = fromIndex ; i < chars.length; i++) {
            if(ch == chars[i]) {
                return i;
            }
        }
        return -1;
    }

    public char charAt(int index) {
        return chars[index];
    }

    /**
     * This method has two variants and returns a new string that is a substring of this string.
     * The substring begins with the character at the specified index and extends to the end of this string or up to endIndex – 1,
     * if the second argument is given.
     *
     * @param beginIndex the begin index, inclusive.
     * @return
     */
    StringImpl substring(int beginIndex) {
        return substring(beginIndex, this.length());
    }

    /**
     * This method has two variants and returns a new string that is a substring of this string.
     * The substring begins with the character at the specified index and extends to the end of this string or up to endIndex – 1,
     * if the second argument is given.
     *
     * @param beginIndex the begin index, inclusive.
     * @param endIndex the end index, exclusive.
     * @return
     */
    StringImpl substring(int beginIndex, int endIndex) {
        int begIndex = this.indexOf(this.charAt(beginIndex));

        char[] result = new char[endIndex - begIndex];
        int p = 0;

        for(int i = begIndex ; i < endIndex; i++) {
            result[p++] = chars[i];
        }
        return new StringImpl(result);
    }

    public static StringImpl valueOf(int num) {
        int originalNumber = num;

        //find no of digits
        int noOfDigtits = 0 ;
        while(num > 0) {
            noOfDigtits++;
            num/=10;
        }
        char[] charArray = new char[noOfDigtits];
        int p = 0;
        int noOfZeros = noOfDigtits - 1;

        while (noOfZeros >= 0) {
            int divisor = (int)(Math.pow(10, noOfZeros));
            int firstDigit = originalNumber/divisor;
            char c = (char) (firstDigit + '0');
            charArray[p++] = c;
            originalNumber = originalNumber % divisor;
            noOfZeros--;
        }
        //TODO: handle negative numbers, for negative numbers need to append '-' and increase char array size
        return new StringImpl(charArray);
    }

    public static String stringValueOf(int value) {
        if (value == 0) return "0";
        if (value == Integer.MIN_VALUE) return "-2147483648";

        final boolean negative = value < 0;
        if (negative) value = -value;

        final StringBuilder buf = new StringBuilder();
        while (value != 0) {
            int digit = value % 10;
            buf.append( (char)(0x30 + digit) );
            value = value / 10;
        }
        if (negative) buf.append('-');

        return buf.reverse().toString();
    }

    public StringImpl concat(StringImpl str) {
        char[] charactersToConcat = str.chars;
        char[] currentCharacters = this.chars;

        char[] result = new char[currentCharacters.length + charactersToConcat.length];
        System.arraycopy(currentCharacters, 0, result, 0, currentCharacters.length);
        System.arraycopy(charactersToConcat, 0, result, currentCharacters.length , charactersToConcat.length);

        return new StringImpl(result);
    }

    public static void main(String[] args) {
        String s = "Aeroplane is a great invention";
        StringImpl str = new StringImpl(s.toCharArray());
        System.out.println(str.charAt(3));
        System.out.println(str.charAt(10));
        System.out.println(str.substring(0).chars);
        System.out.println(str.substring(2,9).chars);

        int num = 12;
        System.out.println(StringImpl.valueOf(num).chars);
        System.out.println(StringImpl.stringValueOf(num));

        char[] chars1 = new char[] {'R', 'I', 'S', 'H', 'U'};
        StringImpl str1 = new StringImpl(chars1);
        char[] chars2 = new char[] {'S', 'O', 'N', 'A', 'L', 'G', 'U', 'P', 'T', 'A'};
        StringImpl str2 = new StringImpl(chars2);
        System.out.println(str1.concat(str2).chars);
    }
}
