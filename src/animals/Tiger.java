package animals;

public class Tiger implements ZooAnimal{
	
	private String name;
	private String biome;
	
	public enum Color {
		ORANGE,
		WHITE;
	}
	private Color color;

	public Tiger(String name, String biome, Color color) {
		this.name = name;
		this.biome = biome;
		this.color = color;
	}
	
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the biome
	 */
	public String getBiome() {
		return biome;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	@Override
	public String sound() {
		return "GRRRR! 🐯";
	}
	
}
