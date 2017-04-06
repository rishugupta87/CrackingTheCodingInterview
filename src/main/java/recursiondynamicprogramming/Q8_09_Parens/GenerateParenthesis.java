package recursiondynamicprogramming.Q8_09_Parens;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Parens: Implement an algorithm to print all valid (e.g., properly opened and closed) combinations of n pairs of parentheses.
 *
 * for n = 3
 * ()()(), (()()), ()(()), (())(), ((()))
 */
public class GenerateParenthesis {

    /**
     *
     * We could try generating the solution for three pairs by taking the list of two pairs of parentheses and adding a third pair.
     *
     *
     * Solution1:
     * We'd have to add the third paren before, around, and after.
     * That is: ()<SOLUTION>, (<SOLUTION>), <SOLUTION>() . Will this work?
     *
     * The problem with this solution is that it might have duplicate values. We could eliminate this by using a hash table/hash set
     * This works, but it's not very efficient. We waste a lot of time coming up with the duplicate strings.
     *
     * @param n
     * @return
     */
    public static Set<String> generateParenthesis(final int n) {
        if(n == 0) {
            return Collections.emptySet();
        }
        if(n == 1) {
            Set<String> set = new HashSet<>();
            set.add("()");
            return set;
        }

        Set<String> previousSet = generateParenthesis(n - 1);
        Set<String> modifiedSet = insertAtPrevSet(previousSet);
        return modifiedSet;
    }

    private static Set<String> insertAtPrevSet(final Set<String> previousSet) {
        Set<String> result = new HashSet<>();
        for(final String previous : previousSet) {
            result.add("()" + previous);
            result.add(previous + "()");
            result.add("(" + previous + ")");
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }
}
