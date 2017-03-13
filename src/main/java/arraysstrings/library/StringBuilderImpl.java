package arraysstrings.library;

public class StringBuilderImpl {
    private char[] chars;
    private int currIndex;

    public StringBuilderImpl() {
        chars = new char[10];
        currIndex = 0;
    }

    public void append(String str) {
        if(currIndex + str.length() > chars.length) { //overflow
            //this will be the new length
            char[] res = new char[currIndex + str.length()];

            //copy orginal characters to this new array
            System.arraycopy(chars, 0, res, 0, currIndex);

            //point old char to this new char array
            chars = res;

            //Note we cound have also used arrays.copyOf instead of system.arraycopy
        }

        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            chars[currIndex++] = c;
        }
    }

    public String toString() {
        return new String(chars, 0, currIndex);
    }

    public static void main(String[] args) {
        String s1 = "Rishu";
        StringBuilderImpl sb = new StringBuilderImpl();
        sb.append("Rishu");
        sb.append("Sonall");
        sb.append("loveeach");
        sb.append("other");
        sb.append("new york city");
        System.out.println(sb.toString());

    }
}
