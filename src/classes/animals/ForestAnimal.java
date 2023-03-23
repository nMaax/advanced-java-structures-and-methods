package classes.animals;

public class ForestAnimal {
	
	boolean hibernation;
	
	public ForestAnimal() {
		super();
		this.hibernation = false;
	}

	public void hibernate() {
		if (hibernation == true) throw new RuntimeException("The animal is already sleeping! Shhh 💤");
		this.hibernation = true;
	}
	
	public void wakeUp() {
		if (hibernation == true) throw new RuntimeException("The animal is already awake! Don't disturb it 🙌");
		this.hibernation = false;
	}
	
	public String sound() {
		return "... 🌳";
	}
	
}
