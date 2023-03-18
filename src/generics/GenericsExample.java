package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import animals.Bear;
import animals.Dog;
import animals.DogBreed;
import animals.ForestAnimal;
import animals.Panda;
import animals.Tiger;
import animals.ZooAnimal;

/**
 *Video tutorial: {@link https://youtu.be/K1iu1kXkVoA}
 *
 * Generics in Java provide a way to create type-safe code by allowing classes,
 * methods, and interfaces to be parameterized with one or more types. 
 * The main benefit of using Generics is that it allows us to create reusable 
 * code that can work with different types of data.
 * 
 * The basic syntax of using Generics is to define a type parameter using the angle 
 * bracket notation "<>", also known as the diamond operator. 
 *
 * */
public class GenericsExample {
	
	@SuppressWarnings("unused")
	public static void main(String[] args) {

		Dog stella = new Dog("Stella", 4, DogBreed.MALTESE);
		Integer randomInteger = (int) Math.random();
		
		TwoObjPrinter<Dog, Integer> printer = new TwoObjPrinter<Dog, Integer>(stella, randomInteger);
		shout(new TwoObjPrinter<Integer, String>(3, "Così parlò Zarathustra"), "forza napoli");
		System.out.println();
		
		shout("eiii", Arrays.asList("Ciao", "Daje Roma", "3"));
		System.out.println();
		
		List<Dog> dogList = new ArrayList<Dog>();
		dogList.add(stella);
		dogList.add(new Dog("Luna", 5, DogBreed.YORKSHIRE));
		dogList.add(new Dog("Argo", 6, DogBreed.MIXED));
		printList(dogList);
		System.out.println();
		
		List<ZooAnimal> zoo = new ArrayList<ZooAnimal>();
		zoo.add(new Tiger("Vanessa", "Jungle", Tiger.Color.ORANGE));
		zoo.add(new Tiger("Gianfranco", "Jungle", Tiger.Color.ORANGE));
		zoo.add(new Panda("Carlo", 10, 101.5, Panda.Region.CHINA, Panda.getPandaColors()[0]));
		zoo.add(new ZooAnimal() {
			
			String AnimalType = "Cocodrile";
			
			@Override
			public String sound() {
				return "E il coccodrillo come fa? 🐊";
			}
		});
		printEntireZoo(zoo);
		System.out.println();
		
		List<Panda> pandas = new ArrayList<Panda>();
		pandas.add(new Panda("Giacomo", 8, 80.0, Panda.Region.ASIATIC_SOUTH_EST, Panda.getPandaColors()[1]));
		pandas.add(new Panda("Franco", 13, 105.0, Panda.Region.NEPAL, Panda.getPandaColors()[0]));
		printSpecificZoo(pandas);
		System.out.println();
		
		//printSpecificZoo(zoo); // This is fine
		//printEntireZoo(pandas); // This is illegal
		
		List<ForestAnimal> forestAnimals = new ArrayList<>();
		printPandasAndAbove(pandas); // This would be illegal if the method would use <? super Bear> instead of <? super Panda>
		forestAnimals.add(new Bear("Carlotta", 17, "Completelly brown with a touch of black", 130.5));
		printPandasAndAbove(forestAnimals);
		System.out.println();
	}
	
	/*
	 * When defining a generic method outside of a class, it is important to use the diamond operator <T>
	 * to specify that the method is generic and can accept any type of object as a parameter. 
	 * By doing this, the method can be called with different 
	 * types of objects and will be able to handle each object correctly based on its specific type.
	 * 
	 * If the diamond operator is not used, the method will not be able to accept different types 
	 * of objects as parameters and will be limited to working with a specific type of object 
	 * that is specified when the method is defined. This can make the method less flexible and 
	 * less useful in situations where you need to work with different types of objects.
	 * */
	private static <T, V> void shout(T thingToShout, V otherThingToShout) {
		System.out.print(thingToShout.toString().toUpperCase() + "!!! ");
		System.out.println(otherThingToShout.toString().toUpperCase() + "!!!");
	}
	

	
	/*
	 * We should use printList(List<?> myList) instead of printList(List<Object> myList) because List<?> 
	 * is a wildcard generic type, which means it can accept any type of List regardless of its generic type. 
	 * This makes the printList method more flexible and reusable as it can be used with different types of lists.
	 * 
	 * If we use List<Object> instead, we would be limiting the method to only accept lists of Object type. 
	 * This means that if we try to pass a list of a specific type, such as List<Integer> or List<String>, 
	 * it would not be possible as these lists are not subtypes of List<Object>.
	 * 
	 * 	
	 * For example, if we had used List<Object> instead of List<?>, the following code would not compile:
		
		List<Integer> myIntList = new ArrayList<>();
		printList(myIntList); // This would result in a compile-time error
		
		private static void printList(List<Object> myList) {
			System.out.println(myList);
		}

	 * This is because even if Integer is a subtype of Object the class List<Integer> is NOT a subtype of List<Object>. 
	 * By using List<?> instead, we can accept any type of List as long as it is a List	
	 * 
	 * */
	private static void printList(List<?> myList) {
		System.out.println(myList);
	}
	
	/*
	 * 
	 	private static void printZoo(List<? extends ZooAnimal> zoo) {
			for (ZooAnimal animal : zoo) {
				System.out.println(animal.sound());
			}
		}

		private static void printZoo(List<ZooAnimal> zoo) {
			for (ZooAnimal animal : zoo) {
				System.out.println(animal.sound());
			}
		}
	 * 
	 * The difference between the two methods is the type of the argument that they accept.
	 * 
	 * The first method printZoo(List<? extends ZooAnimal> zoo) accepts a list of objects that 
	 * are of type ZooAnimal or a subclass of ZooAnimal. This is known as a bounded wildcard. 
	 * It allows the method to accept a list of any type that is a subclass of ZooAnimal, 
	 * providing more flexibility in the types of lists that can be passed to the method.
	 * 
	 * The second method printZoo(List<ZooAnimal> zoo) accepts only a list of objects that are
	 * of type ZooAnimal. This means that it can only accept a list of ZooAnimal objects, 
	 * and not any subclass of ZooAnimal.
	 * 
	 * In terms of the output, both methods will produce the same result since the sound() method 
	 * is defined in the ZooAnimal interface and will be implemented by all subclasses of ZooAnimal. 
	 * However, using the first method with a bounded wildcard can be more flexible and allow for a wider range 
	 * of input types.
	 * 
	 * 
	 * 
	 * */
	private static void printSpecificZoo(List<? extends ZooAnimal> zoo) {
		for (ZooAnimal animal : zoo) {
			System.out.println(animal.sound());
		}
	}

	private static void printEntireZoo(List<ZooAnimal> zoo) {
		for (ZooAnimal animal : zoo) {
			System.out.println(animal.sound());
		}
	}
	
	/*
	 * In this case, the notation <? super Panda> is a 
	 * wildcard type parameter that indicates a type that 
	 * is either a superclass of Panda, or Panda itself.
	 * 
	 * Since Panda is a child class of Bear, any class that 
	 * is a superclass of Panda is also a superclass of Bear. 
	 * Therefore, <? super Panda> would accept any class that is 
	 * a superclass of Panda, Bear, or any other class that is a superclass of Bear.
	 * 
	 * For example, if we have a class Animal that is a superclass of Bear, then <? super Panda> 
	 * would accept types like Animal, Bear, or Object.
	 * 
	 * The super keyword indicates that the unknown type must be a superclass of Panda, or Panda itself. 
	 * This means that the wildcard type parameter can accept any type that is a superclass of Panda, 
	 * which includes Bear and any other superclass of Panda.
	 * 
	 * Again, the second ? in <? super Panda, ?> is a shorthand notation for <? extends Object>, 
	 * which means any type that extends Object.
	 * 
	 * Overall, the wildcard type parameter <? super Panda> provides flexibility when dealing 
	 * with different types that are either a superclass of, or Panda itself, while still ensuring type safety. 
	 * It allows for more generic and reusable code, since it can accept a wider range of types 
	 * that meet the specified requirements.
	 * */
	private static void printPandasAndAbove(List<? super Panda> pandasAndAbove) {
	    for (Object animal : pandasAndAbove) {
	        if (animal instanceof Bear) {
	            System.out.println(((Bear) animal).sound());
	        } else if (animal instanceof Panda) {
	            System.out.println(((Panda) animal).sound());
	        }
	    }
	}

}
