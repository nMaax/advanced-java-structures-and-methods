package generics;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import classes.animals.Bear;
import classes.animals.Dog;
import classes.animals.DogBreed;
import classes.animals.ForestAnimal;
import classes.animals.Panda;
import classes.animals.Tiger;
import classes.animals.ZooAnimal;

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
		
		List<String> list1 = Arrays.asList("foo", "bar", "baz");
		List<String> list2 = Arrays.asList("bar", "qux");

		List<String> result1 = removeDuplicatesT(list1, list2); // This will work with type parameter T
		System.out.println(result1);
		
		List<?> result2 = removeDuplicatesQM(list1, list2); // This will work with the wildcard operator ?
		System.out.println(result2);
		
		//List<Object> result3 = removeDuplicatesObj(list1, list2); // This will not compile because List<String> is not a subtype of List<Object>
		System.out.println();
		
		/*
		 * One reason (in fact the only real one since all other can be achieved with T or Object) to use <?>
		 * is when you want to declare a method or a variable that can accept a collection of any type,
		 * without specifying a type parameter. This is useful when you don't care about the actual type 
		 * of the element in the collection, but you still want to be able to operate on it in a generic way.
		 * */
		ArrayList<?> unknownList;
		ArrayList<Object> objectList;
		
		unknownList = new ArrayList<String>(); // This will work
		//objectList = new ArrayList<String>(); // This won't since ArrayList<String> is NOT a subclass of ArrayList<Object>, even tho String IS a subclass of Object
		/* 
		 * Basically... 
		 * 
		 * If before we could do;
		 * 
		 * Object x;
		 * 
		 * x = "Ciao";
		 * x = 3;
		 * 
		 * Now (with collections) we cannot do anymore stuff like:
		 * 
		 * List<Object> x;
		 * x = new ArrayList<String>(); // this is illegal, List<String> is not a child of List<Object>
		 * x.add();
		 * ...
		 * 
		 * x = new ArrayList<String>(); // this is illegal too
		 * x.add();
		 * ...
		 * 
		 * So we need to find a way to have a generic variable who can hold all types of collections;
		 * 
		 * List<?> x;
		 * x = new ArrayList<String>(); // This will work
		 * x = new ArrayList<String>(); // This will work too
		 * 
		 * But now we cannot anymore use .add() since the type of ArrayList is unknown.
		 * A simple solution would be to do something like this
		 * 
		 * x = Arrays.asList(1, 2, 3, 4);
		 * 
		 * But again we could call .add() on it
		 * 
		 * This explains the fact that when we use <?> we know that we are 
		 * managing a situation where we don't care what's inside of x,
		 * so we are going to call only methods that do not depend on what is
		 * the type stored inside
		 */
		
		// Create some lists of different types
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5);
        List<Double> doubleList = Arrays.asList(1.1, 2.2, 3.3, 4.4, 5.5);
        List<String> stringList = Arrays.asList("one", "two", "three", "four", "five");
        List<Object> stringAndIntList = Arrays.asList(1, 2, 3, "four");
        
        // Call the max() method with different types of lists
        double intMax = max(intList);
        System.out.println("Max of intList: " + intMax);
        double doubleMax = max(doubleList);
        System.out.println("Max of doubleList: " + doubleMax);
        double stringMax = max(stringList);
        System.out.println("Max of stringList: " + stringMax);
        double stringAndIntMax = max(stringAndIntList);
        System.out.println("Max of stringAndIntMax: " + stringAndIntMax);
        
        /*
         * Type inference: if i put empty brackets on the right of a non-generic declared variable
         * java will automatically understand the type of the instance
         * 
         * This will work in context where the type of the right side of '=' is clear
         * 
         * */
        Map<String, Integer> numbers = new HashMap<>();
        mapPrinter(new HashMap<>()); // this will work
        //maxT(new List<>()); // this wont since we don't know what should .maxT(List<T> list) take as parameter
		
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
	 * Consider even that 
	   
	  	private static void printList(List<T> myList) {
			System.out.println(myList);
		}
		
	 * is not legal. 
	 * 
	 * In this case the printList method is using a type parameter <T> to specify the type of the List parameter. 
	 * However, in this case, the type parameter is not defined or constrained, so the List could be of any type. 
	 * This would make it similar to the List<?> version. 
	 * But, the problem is that T is not defined or specified anywhere in the method or in the class. 
	 * This means that the compiler cannot infer the type of T, and the method will not compile.
	 * 
	 * When you use T as a type parameter, it means that you are defining a generic type or method that 
	 * can work with any type, but the specific type is determined when the code is compiled or executed. 
	 * For example, if you have a class MyList<T> that implements a generic list, 
	 * you could create a MyList<String> object, which means that T is now String. 
	 * The type parameter T is replaced with the actual type (in this case String) when the code is compiled.
	 * 
	 * On the other hand, when you use ? as a type parameter, it means that you are telling the compiler 
	 * that you don't care about the specific type, only that it is some type. This is often used when you 
	 * want to write code that is generic and can work with different types, but you don't need
	 *  to know the specific type at compile time. For example, if you have a method printList(List<?> list), 
	 *  you can pass in a list of any type, but the specific type is not important because you only need to 
	 *  print the list.
	 * 
	 * In short, both T and ? are generic type parameters, but T is used when you need to define a specific 
	 * type that is determined at compile time, while ? is used when you don't care about the specific type 
	 * and only need to work with any type.
	 * 
	 * The only place where you can use ? is in the declaration of a variable or a parameter to indicate 
	 * that the type is unknown or irrelevant.
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
	
	/** Removes duplicates from a list using T */
	public static <T> List<T> removeDuplicatesT(List<T> list1, List<T> list2) {
	    Set<T> set = new HashSet<>(list1);
	    set.addAll(list2);
	    return new ArrayList<>(set);
	}
	
	/** Removes duplicates from a list using ? */
	public static List<?> removeDuplicatesQM(List<?> list1, List<?> list2) {
	    Set<Object> set = new HashSet<>(list1); //If we use Set<?> we will have an error on .addAll()
	    set.addAll(list2); // since we don't know the type of the Set thus we cannot provide type safety when adding instances
	    return new ArrayList<>(set); // This will return a list of objects and not a list of the same type passed as parameters
	}

	/** Removes duplicates from a list using Object */
	public static List<Object> removeDuplicatesObj(List<Object> list1, List<Object> list2) {
	    Set<Object> set = new HashSet<>(list1);
	    set.addAll(list2);
	    return new ArrayList<>(set);
	}
	
	/*
	 * The following two methods act as the same, no difference at all
	 * */
	
	/* Find the maximum number in a list */
	public static double max(List<?> list) {
	    double max = Double.NEGATIVE_INFINITY;
	    for (Object obj : list) {
	        if (obj instanceof Number) {
	            double num = ((Number) obj).doubleValue();
	            if (num > max) {
	                max = num;
	            }
	        }
	    }
	    return max;
	}
	
	/* Find the maximum number in a list */
	public static <T> double maxT(List<T> list) {
	    double max = Double.NEGATIVE_INFINITY;
	    for (T obj : list) {
	        if (obj instanceof Number) {
	            double num = ((Number) obj).doubleValue();
	            if (num > max) {
	                max = num;
	            }
	        }
	    }
	    return max;
	}
	
	public static void mapPrinter(Map<String, Integer> m) {
		System.out.println(m);
	}
	
}
