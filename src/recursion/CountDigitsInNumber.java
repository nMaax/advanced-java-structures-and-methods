package recursion;

public class CountDigitsInNumber {

	public static void main(String[] args) {
		System.out.println(containsDigit(2546957, 8));;
	}
	
	/*
	 * 
	 * § sci approach
	 * 
	 * a = number_length - 1 
	 * number = digit1 * 10 ^ a + digit2 * 10 ^ a-1 + digit3 * 10 ^ a-2 + ... + digit_length * 10^0
	 * 
	 * 
	 * 		e.g. 157392 = 1e5 + 5e4 + 7e3 + 3e2 + 9e1 + 2e0
	 * 
	 * int r = 157392 * 10^-a = 1,57392 (since r is an integer it gets rounded to 1)
	 * 
	 * if ( r == digitSearched) return true;
	 * 
	 * int t = 157392 - r*10^-a = 57392
	 * 
	 * come prima ...
	 * 
	 * */
	
	public static boolean containsDigit (int number, int digit) {
		return explodeDigits(number, digit, new String(""+number).length());
	}
	
	public static boolean explodeDigits(int number, int digit, int numLength) {
		
		if (numLength == 1) return number == digit;
		
		int a = numLength-1;
		
		int r = (int) (number *  Math.pow(10, -a));
		if (r == digit) return true;
		
		
		int t = (int) (number - r*Math.pow(10, a));		
		return explodeDigits(t, digit, numLength-1);
	}
}
