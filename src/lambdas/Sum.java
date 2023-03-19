package lambdas;

/*
 * In Java, a functional interface is an interface that has only one abstract method. 
 * It is also known as a Single Abstract Method (SAM) interface. 
 * The purpose of functional interfaces is to enable functional programming in Java 
 * by allowing interfaces to be used as lambda expressions or method references, which 
 * are the core features of functional programming.
 * 
 * In Java, functional interfaces are annotated with the @FunctionalInterface annotation.
 *  This annotation is used to ensure that the interface has only one abstract method.
 *   If there are more than one abstract method, then the compiler will generate an error.
 **/
@FunctionalInterface
public interface Sum {
	
	public double sum(double a, double b);
	
}
