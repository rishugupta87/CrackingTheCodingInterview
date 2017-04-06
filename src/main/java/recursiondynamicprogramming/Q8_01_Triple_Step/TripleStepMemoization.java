package recursiondynamicprogramming.Q8_01_Triple_Step;

import java.math.BigInteger;

/**
 * Created by rg029761 on 3/19/17.
 */
public class TripleStepMemoization {

    /**
      The previous solution for countWays is called many times for the same values, which is unnecessary. We can
      fix this through memoization.
      Essentially, if we've seen this value of n before, return the cached value. Each time we compute a fresh
      value, add it to the cache which in this case is a simple array .

     * @param n
     * @return
     */
    public static int steps(int n) {
        return countSteps(n , new int[n+1]);
    }

    private static int countSteps(final int n, final int[] table) {
        if(n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        } if (n == 2) {
            return 2;
        }
        if(table[n] == 0) {
            table[n] = countSteps(n - 1, table) + countSteps(n - 2, table) + countSteps(n - 3, table);
        }
        return table[n];
    }

    public static void main(String[] args) {
        int n = 36;
        int ways = steps(n);
        System.out.println(ways);

        // important to note is that when n = 37 no of ways will overflow the integer bound
//      int n = 37;
//      int ways2 = steps(n);
//      System.out.println(ways2);

        //Using a long will delay, but not completely solve, this issue.
        // you can work around this using a BigInteger class
    }
}
