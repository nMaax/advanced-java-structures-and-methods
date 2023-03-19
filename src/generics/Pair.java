package generics;

import java.util.List;

/*
 * public class Pair <?, ?> is illegal
 * 
 * ? is a wildcard type that represents an unknown type. 
 * It cannot be used as a type parameter by itself because it is too generic 
 * and doesn't specify any specific type. In other words, you can't use ?
 * as a type for a field, variable, or parameter.
 * 
 * On the other hand, F and S are type parameters 
 * that specify the types of the first and second elements of the pair. 
 * This is legal because it defines two specific types that can be used for 
 * the fields and methods of the Pair class.
 * 
 * In short, you need to specify a specific type or a type 
 * parameter (like F and S) when defining a class, field, variable, or parameter,
 * and you can't use the wildcard ? by itself.
 * */
public class Pair <F, S>{
	
	F first;
	S second;
	
	public Pair(F first, S second) {
		super();
		this.first = first;
		this.second = second;
	}

	public F getFirst() {
		return first;
	}
	
	/* 
	 * The following is illegal:
	   
	   public ? getSecond() {
	    	return second;
	   }
	   
	 * The reason why public S getSecond() {...} is valid and public ? getSecond() {...} is not,
	 * is because S is a type parameter that has been defined as part of the class declaration, 
	 * while ? is a wildcard type that represents an unknown type.
	 * 
	 * When you use S as a type parameter, you are telling the compiler that there is 
	 * a specific type that will be used for the second element of the pair, but you 
	 * don't know what that type is yet. By declaring public S getSecond() {...}, 
	 * you are telling the compiler that the getSecond() method will return an object of type S, 
	 * which is a specific type that has been defined as part of the class declaration.
	 * 
	 * On the other hand, when you use ? as a wildcard type, you are telling 
	 * the compiler that the type of the object is unknown. This means that you can't use ? 
	 * as a return type for a method because the caller of the method would not know what type to expect. 
	 * 
	 * */
	
	/*
 	 * IMPORTANT! --> The only place where you can use ? is in 
	 * the declaration of a variable or a parameter to indicate 
	 * that the type is unknown or irrelevant.
	 * 
	 * */
	public S getSecond() {
		return second;
	}
	
	/*Note that this is not the same as before where we tried to write
 	   
 	   public ? getSecond() {
	    	return second;
	   }
	   
	 * Here the type of the result is List<?> not just ?, the wildcard mark ? is not into the method
	 * but inside the list itself, so is not a problem of the method takeSomethingAndDoSomething(...)
	 * to handle the wildcard. It is a problem of the List itself! 
	 * */
	public List<?> takeSomethingAndDoSomething(List<?> list) {
		System.out.println("Doing something...");
		return list;
	}
	
	@Override
	public String toString() {
		return "First: " + first.toString() + "; Second: " + second.toString();
	}
	
}
