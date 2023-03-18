package animals;

public class Bear extends ForestAnimal{
    
    private String name;
    private int age;
    private String furColor;
    private double weight;
    
    public Bear(String name, int age, String furColor, double weight) {
        this.name = name;
        this.age = age;
        this.furColor = furColor;
        this.weight = weight;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public int getAge() {
        return age;
    }
    
    public void setAge(int age) {
        this.age = age;
    }
    
    public String getFurColor() {
        return furColor;
    }
    
    public void setFurColor(String furColor) {
        this.furColor = furColor;
    }
    
    public double getWeight() {
        return weight;
    }
    
    public void setWeight(double weight) {
        this.weight = weight;
    }
    
    public void roar() {
        System.out.println(name + " roars loudly!");
    }
    
    public void eat(String food) {
        System.out.println(name + " eats " + food + ".");
        weight += 0.5; // Bears gain weight after eating
    }
    
    public void sleep() {
        System.out.println(name + " goes to sleep.");
    }
    
}
