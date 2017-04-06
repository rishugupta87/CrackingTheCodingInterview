package recursiondynamicprogramming.Q8_09_Parens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis_Efficient {

    /**
     *
     We can avoid this duplicate string issue by building the string from scratch. Under this approach, we add left and right parens, as long as our expression stays valid.
     On each recursive call, we have the index for a particular character in the string.We need to select either a left or a right paren.When can we
     use a left paren, and when can we use a right paren?
     1. LeftParen:As long as we haven't used up all the left parentheses,we can always insert a left paren.
     2. Right Paren: We can insert a right paren as long as it won't lead to a syntax error. When will we get a
     syntax error? We will get a syntax error if there are more right parentheses than left.
     So, we simply keep track of the number of left and right parentheses allowed. If there are left parens remaining, we'll insert a left paren and recurse.
     If there are more right parens remaining than left (i.e., if there are more left parens in use than right parens), then we'll insert a right paren and recurse.
     *
     *
     * @param n
     * @return
     */
    public static List<String> generateParenthesis(final int n) {
        int noOfOpen = 0;
        int noOfClose = 0;

        List<String> res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();

        //generate(res, noOfOpen, noOfClose, n, new String());
        generate(res, noOfOpen, noOfClose, n, sb);

        return res;
    }

    //easy to understand
    private static void generate(final List<String> res, final int noOfOpen,
                                 final int noOfClose, final int n, String s) {
        if(noOfOpen < 0 || noOfClose < 0) {
            return;
        }
        if(noOfOpen == n && noOfClose == n) {
            res.add(s);
            return ;
        }
        if(noOfOpen < n) {
            generate(res, noOfOpen+1, noOfClose, n, s + "("); //however concating string like this creates a new string everytime.
        }

        if(noOfClose < noOfOpen) {
            generate(res, noOfOpen, noOfClose + 1, n, s + ")");
        }
    }


    //http://stackoverflow.com/questions/24704170/generate-balanced-parentheses-in-java
    // understanding of why how we want to reset the stringbuilder.
    private static void generate(final List<String> res, final int noOfOpen,
                                              final int noOfClose, final int n, StringBuilder sb) {
        if(noOfOpen < 0 || noOfClose < 0) {
            return;
        }
        if(noOfOpen == n && noOfClose == n) {
            res.add(sb.toString());
            return ;
        }
        if(noOfOpen < n) {
            generate(res, noOfOpen+1, noOfClose, n, sb.append("("));
            sb.delete(sb.length() - 1, sb.length()); //after each recursive call remove the last character
        }

        if(noOfClose < noOfOpen) {
            generate(res, noOfOpen, noOfClose + 1, n, sb.append(")"));
            sb.delete(sb.length() - 1, sb.length()); //after each recursive call remove the last character
        }
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(2));
    }
}
