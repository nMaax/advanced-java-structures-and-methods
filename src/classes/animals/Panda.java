package classes.animals;

public final class Panda extends Bear implements ZooAnimal{
	
	public enum Region {
		CHINA,
		NEPAL,
		ASIATIC_SOUTH_EST;
	}
	private Region region;
	
	/*
	 * If you want to make an Enum Inner class private
	 * eventually you will need to make its values accessible from outside
	 * 
	 * To do so make it static and define a static getValues() method, call 
	 * it in the out class for another method and make this one public.
	 * 
	 * Following this patter you will be able to retrieve Enum values as an array of Enums
	 * Outside of the outerclass too.
	 * 
	 * See the static method getPandaColors() below
	 * */
	private static enum Color {
		BLACK_AND_WHITE("Just the plain old good Panda fur you find in WWF leaflets"),
		RED("Red mixed with Orange and Brown, with Black and White details");
		
		private String furColor;
		
		private Color(String furColor) {
			this.furColor = furColor;
		}
		
		public static Color[] getValues() {
			return Color.values();
		}
		
		public String getFurColor() {
			return this.furColor;
		}
	}
	private Color color;

	public Panda(String name, int age, double weight, Region region, Color color) {
		
		super(name, age, color.getFurColor(), weight);
		this.region = region;
		this.color = color;
	}

	/**
	 * @return the region
	 */
	public Region getRegion() {
		return region;
	}

	/**
	 * @return the color
	 */
	public Color getColor() {
		return color;
	}

	/**
	 * @param region the region to set
	 */
	public void setRegion(Region region) {
		this.region = region;
	}

	/**
	 * @param color the color to set
	 */
	public void setColor(Color color) {
		this.color = color;
	}
	
	public static Color[] getPandaColors() {
		return Color.getValues();
	}
	
	@Override
	public String sound() {
		return "Pandoo 🐼";
	}
}

