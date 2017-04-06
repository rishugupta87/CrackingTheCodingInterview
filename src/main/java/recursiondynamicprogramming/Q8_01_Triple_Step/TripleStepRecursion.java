package recursiondynamicprogramming.Q8_01_Triple_Step;

/**
 *
  8.1 Triple Step: A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or
  3 steps at a time. Implement a method to count how many possible ways the child can run up the stairs.
 */
public class TripleStepRecursion {

    /**
     * Time complexity = O(3^n)
     * Space = O(n)
     *
     * @param n
     * @return
     */
    public static int steps(int n) {
        if(n < 0) {
            return 0;
        }
        if (n == 0 || n == 1) {
            return 1;
        } if (n == 2) {
            return 2;
        }
        return steps(n - 1) + steps(n - 2) + steps(n - 3);
    }

    public static void main(String[] args) {
        int n = 5;
        int ways = steps(n);
        System.out.println(ways);
    }
}
