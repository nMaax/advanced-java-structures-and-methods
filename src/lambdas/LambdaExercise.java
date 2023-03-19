package lambdas;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class LambdaExercise {
	
	@SuppressWarnings("unchecked")
	public static void main(String args[]) {
		//Calculator calculator = new Calculator();
		/*
		 * A lambda expression is a shorthand way of creating an instance 
		 * of a functional interface. 
		 * 
		 * For example, if you have a functional interface that represents 
		 * a mathematical operation, you can create a lambda expression 
		 * to represent the operation, like this:
		 * 
		   MathOperation add = (a, b) -> a + b;
		 * 
		 * Avoiding you to create a class like Calculator that implements the desired interface
		 * 
		   Calculator calculator = new Calculator();
		 * 
		 * */
		
		/*Exercise 1: Write a lambda expression that takes two integers and returns their sum.*/
		Sum sumLambda = (a, b) -> { // Same as (a, b) -> a + b;
			return a + b;
		}; 
		printSum(sumLambda, 1.5, 2);
		
		/*Exercise 2: Write a lambda expression that takes a string and returns its length.*/
		Sizer length = (s) -> {
			int i = 0;
			for (@SuppressWarnings("unused") char c : s.toCharArray()) {
				i++;
			}
			return i;
		};
		printLenght(length, "Ciao");
		
		/*Exercise 3: Write a lambda expression that takes an array of integers and returns the sum of all even numbers in the array.*/
		SumOfEvenOperator sumOfEvenOperator = (n) -> {
			int result = 0;
			for (int i : n) {
				if (i%2 == 0) result += i;
			}
			return result;
		};
		int[] x = {1, 2, 3, 4};
		System.out.println(sumOfEvens(sumOfEvenOperator, x));
		
		/*Exercise 4: Write a lambda expression that takes an array of strings and returns a new array containing only the strings that start with the letter "a".*/
		List<String> listOfStrings = new LinkedList<String>();
		listOfStrings.add("FdI");
		listOfStrings.add("FI");
		listOfStrings.add("AVSI");
		listOfStrings.add("AzIv");
		listOfStrings.add("PD");
		listOfStrings = (List<String>) pulpList(listOfStrings, (list) -> {
			List<Object> copy = new ArrayList<Object>(list);
			for (Object s : list) {
				String casted = (String) s;
				if (!casted.substring(0, 1).toLowerCase().equals("a")) {
					copy.remove(s);
				}
			}
			return copy;
		});
		System.out.println(listOfStrings);
		
		/* Exercise 5: Write a lambda expression that takes a list of strings and returns a new list containing the lengths of each string, sorted in descending order. */
		List<String> toBeConverted = Arrays.asList( "Ciao", "Hello", "Bye", "Konichiwa", "Sayonara");
		List<Integer> listOfLenght = convertToListOfLenghts(toBeConverted, (listToBeConverted) -> {
			List<Integer> result = new ArrayList<Integer>();
			for (String s : listToBeConverted) {
				result.add(s.length());
			}
			Collections.sort(result);
			return result;
		});
		System.out.println(toBeConverted);
		System.out.println(listOfLenght);
	}
	
	public static void printSum(Sum calculator, double a, double b) {
		System.out.println(calculator.sum(a, b));
	}
	
	public static void printLenght(Sizer sizer, String s) {
		System.out.println(sizer.lenght(s));
	}
	
	public static int sumOfEvens(SumOfEvenOperator s, int[] n) {
		return s.sumOfEven(n);
	}
	
	public static List<?> pulpList(List<?> list, ListCleaner operator) {
		return operator.listCleaner(list);
	}
	
	public static List<Integer> convertToListOfLenghts(List<String> listToBeConverted, ToListOfLenghtsOperator operator) {
		return operator.convertToListOfLenghts(listToBeConverted);
	}
	
}
