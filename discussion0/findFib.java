public class findFib {
	public static int fib (int n ) {
		// if (n == 0) {
		// 	return 0;
		// }
		// if (n == 1) {
		// 	return 1;
		// }
		if (n <= 1) {
			return n;
		}
		else {
			return (fib(n-1) + fib(n-2));
		}
	}

	public static int fib2 (int n, int k, int f0, int f1) {
		return n == k ? f0 : fib2(n, k + 1, f1, f0 + f1);
		// if (n == k) {
		// 	return f0;
		// }
		// else {
		// 	return fib2(n , k+1, f1, f0+f1);
		// }
	}

	// public static int fib3 (int n, int k) {
	// 	int result = 0;
	// 	if (n == 0) {
	// 		return 0;
	// 	}
	// 	if (n == 1) {
	// 		return 1;
	// 	} 
	// 	while (n > k) {
	// 		result = helper(0,1);
	// 		k++;
	// 	}
	// 	return result;
	// }
	// public static int helper (int f0 , int f1) {
	// 	f0 = f1;
	// 	f1 = f0 + f1;
	// 	return f0;
	// }

	//test
	public static void main(String[] args) {
		System.out.println(fib(4));
		System.out.println(fib2(4,0,0,1));
	}
}

// 0, 1, 2, 3, 4
// 0, 1, 1, 2, 3, 5, 8, 13, 21
// fib2(2,0,0,1);
// 	fib2(2,1,1,1);
// 		fib2(2,2,1,2) 			