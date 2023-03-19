package lambdas;

public class Calculator implements Sum{

	@Override
	public double sum(double a, double b) {
		return a + b;
	}
	
	public double diff(double a, double b) {
		return a - b;
	}
	
	public double times(double a, double b) {
		return a * b;
	}
	
	public double divided(double a, double b) {
		return a / b;
	}
	
}
