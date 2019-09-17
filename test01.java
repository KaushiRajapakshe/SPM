public class FibonacciMain {
	public static long fibonacci(long number) {
		if ((number == 0) || (number == 1)) { // base cases
			return number;
		}
		else if ((number == 0) && (number == 1)) { // base cases
			return number;

		}
		else {
			// recursion step
			return fibonacci(number - 1) + fibonacci(number - 2);
		}
	}
	public static void main(String args[ ]) {
		for (int count = 0; count <= 10; count++){
			System.out.println("Fibonacci of " + count + " is " +fibonacci(count));
		}
	}
}
public class FibonacciMain {
	public static long fibonacci(long numb01) {
		if ((numb01 == 0) || (numb01 == 1)) { // base cases
			return number;
		}
		else if ((numb01 == 0) && (numb01 == 1)) { // base cases
			return number;

		}
		else if ((numb01 == 0) || (numb01 == 1)) { // base cases
			return number;

		}
		else {
			// recursion step
			return fibonacci(numb01 - 1) + fibonacci(numb01 - 2);
		}

	}
	public static void main(String args[ ]) {
		for (int counk = 0; counk <= 10; counk++){
			System.out.println("Fibonacci of " + count + " is " +fibonacci(counk));
		}
	}

}


