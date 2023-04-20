package recursion;

public class Fibonacci {

	public static void main(String[] args) {
		
		printFibonacci(2);
		
	}
	
	/*
	 * F(0) = 0, 
	 * F(1) = 1, 
	 * ...
	 * F(n) = F(n-1) + F(n-2) for n > 1. 
	 * 
	 * F(0) = 1
	 * F(1) = 1
	 * F(2) = F(1) + F(0) = 1 + 1 = 2
	 * F(3) = F(2) + F(1) = 2 + 1 = 3
	 * F(4) = F(3) + F(2) = 3 + 2 = 5
	 * 
	 * 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, ...
	 * 
	 * 
	 * 
	 * */
	
	public static void printFibonacci(int limit) {
		
		if (limit < 1) return;
		
		System.out.print("1, 1, ");
		fibonacci(1, 1, limit);
		System.out.println("...");
	}
	
	public static void fibonacci(int num, int prev, int limit) {
		
		int r = num + prev;
		
		if (r > limit) return;
		else System.out.print(r + ", ");
		
		fibonacci(r, num, limit);
	}
	
}
