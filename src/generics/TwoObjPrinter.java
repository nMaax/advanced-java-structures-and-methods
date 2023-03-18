package generics;

/**
 * A generic class that can print any type of object.
 * 
 * @param <T> the type of object to print
 */
public class TwoObjPrinter<T, V> {

	private T thingToPrint;
	private V otherThingToPrint;

	public TwoObjPrinter(T thingToPrint, V otherThingToPrint) {
		this.thingToPrint = thingToPrint;
		this.otherThingToPrint = otherThingToPrint;
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
	
	/**
	 * @return the otherThingToPrint
	 */
	protected V getOtherThingToPrint() {
		return otherThingToPrint;
	}

	/**
	 * @param otherThingToPrint the otherThingToPrint to set
	 */
	protected void setOtherThingToPrint(V otherThingToPrint) {
		this.otherThingToPrint = otherThingToPrint;
	}

	/** Prints the object on the console. */
	public void print() {
		System.out.println(this.thingToPrint + " " + this.otherThingToPrint);
	}

	@Override
	public String toString() {
		return this.thingToPrint.toString() + " " + this.otherThingToPrint.toString();
	}
	
}
