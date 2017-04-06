package recursiondynamicprogramming.Introduction;

public class FibonacciD {

	/**
	 *
	 * Time = o (2^n) 2 branched per node = O(no of branches ^ depth)
	 * Space = O(n) n recursive calls ons tack
	 *
	 * @param n
	 * @return
	 */
	public static int fibonacci_bottomUp(int n) {
		if (n == 0) return 0;
		if(n <= 2) {
			return 1;
		}
		int a = 1;
		int b = 1;
		int c = 0;

		for (int i = 3; i <= n; i++) {
			c = a + b;
			a = b;
			b = c;
		}
		return c;
	}

	public static int fibonacci_topDown(int n) {
		return fibonacci(n, new int[n + 1]);
	}

	private static int fibonacci(final int n, final int[] nums) {
		if(n == 0) {
			return 0;
		}
		if(n <=2 ) {
			return 1;
		}

		if(nums[n] == 0) {
			nums[n] = fibonacci(n - 1, nums) + fibonacci(n -2, nums);
		}

		return nums[n];
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(FibonacciD.fibonacci_bottomUp(7));
		System.out.println(FibonacciD.fibonacci_topDown(3));
	}

}
