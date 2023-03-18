package generics;

/*.
 * Instead of having a class that prints a specific type of object, we can use a generic class that works with any type of object.
 * This approach is much better since we don't have to create multiple classes for each type of object.
 * Generics in Java allow us to create classes, interfaces, and methods that can work with different types of objects.
 * We define a generic class by using angle brackets <> and a placeholder type parameter, 
 * which is usually denoted by a single uppercase letter. 
 * 
 * In this case, we define a generic class called Printer with a type parameter T
 * 
 * In Java, the diamond operator <> is used to specify a generic type parameter, and can be used to define a class that extends or implements multiple classes and/or interfaces.
 * To extend a class and implement one or more interfaces, you can use the following syntax:
 * 
 
	class MyClass<T extends MyBaseClass & MyInterface1 & MyInterface2> {
    	// class definition
	}
	
 * In this example, MyClass is a generic class that extends MyBaseClass and implements MyInterface1 and MyInterface2.
 * 
 * The & symbol is used to separate multiple class and interface types that are being extended or implemented.
 * For example, if MyBaseClass is a class that provides some basic functionality that you want to reuse 
 * in MyClass, and MyInterface1 and MyInterface2 are interfaces that provide some additional functionality 
 * that MyClass needs to implement, you can use the diamond operator to create a new class that 
 * combines all of these features.
 * 
 * Keep in mind that when you use the diamond operator to specify multiple type bounds for a generic type parameter, the bounds must be specified in a specific order. The class that is being extended must come first, followed by any interfaces that are being implemented. Additionally, you can only extend one class, but you can implement multiple interfaces.
 * 
*/

/**
 * A generic class that can print any type of object.
 * 
 * @param <T> the type of object to print
 */
public class Printer<T extends Object & Comparable<T> & Runnable> {

	private T thingToPrint;

	public Printer(T thingToPrint) {
		this.thingToPrint = thingToPrint;
	}

	/**
	 * Gets the object to print.
	 * 
	 * @return the object to print
	 */
	protected T getThingToPrint() {
		return thingToPrint;
	}

	/**
	 * Sets the object to print.
	 * 
	 * @param thingToPrint the object to print
	 */
	protected void setThingToPrint(T thingToPrint) {
		this.thingToPrint = thingToPrint;
	}

	/** Prints the object on the console. */
	public void print() {
		System.out.println(this.thingToPrint);
	}

	@Override
	public String toString() {
		return this.thingToPrint.toString();
	}
	
}
