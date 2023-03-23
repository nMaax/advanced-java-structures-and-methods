package classes.animals;

public record Cat(String name, int age) {
	
	public void meow() {
		System.out.println("Meow! 🐈");
	}
	
	@Override
	public String toString() {
		return "Cat: " + this.name + " " + this.age;
	}
}
