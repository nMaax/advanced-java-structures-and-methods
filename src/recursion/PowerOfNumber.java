package recursion;

public class PowerOfNumber {
	
	public static void main(String[] args) {
		System.out.println(powerOf(2, 4));
	}
	
	public static int powerOf(int n, int p) {
		if (p == 1) return n;
		return n * powerOf(n, p-1);
	}
}
