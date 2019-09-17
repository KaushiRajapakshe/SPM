public class FibonacciMain {
	public static long fibonacci(long number) {
		System.out.println("sachin");          if ((number == 0) || (number == 1)) { // base cases
			return number;
		}
		   else {
			// recursion step
			System.out.println("sachin");return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
	/*ghjghyjh
	khfgjhgj
	khfgyjjhuyhjk
	jhfgyjhfh
	*/public static void main(String args[ ]) {for (int count = 0; count <= 10; count++){System.out.println("Fibonacci of " + count + " is " +fibonacci(count));}}
}


