package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Anagrams {

	public static void main(String[] args) {
		System.out.println(anagramsSwap("ciao"));
		System.out.println(anagramsBottomUp("ciao"));
	}
	
	/*
	 * We take all the letters in a collection, then, starting from a void string we
	 * pop a letter from the collection and add it on the void string, making it a string
	 * of length 1; in the following step we pop again and we put this letter one time
	 * before the string, and another time after the string, on both of it we call the function again
	 * 
	 * Everytime we call the function on each position the letter can have
	 * 
	 * Inital case
	 * 		
	 * 		partial: "", letters: [a, b, c, ..., z], anagrams: []
	 * 
	 * i-case
	 * 
	 * 		partial: "a", letters: [b, c, ...], angrams: []
	 * 
	 * Final case
	 * 
	 * 		partial: "hkdjasd...", letters: [], anagrams: [wiqnid, ascas, aasad, ...]
	 * */
	
	public static List<String> anagramsBottomUp(String word) {
		List<Character> letters = new ArrayList<Character>();
		for (char c : word.toCharArray()) {
			letters.add(c);
		}
		List<String> anagrams = new ArrayList<String>();
		buildUppon("", letters, word.length(), anagrams);
		return anagrams;
	}
	
	public static void buildUppon(String partial, List<Character> letters, int originalWordLenght, List<String> anagrams) {
		
		if (partial.length() == originalWordLenght) {
			anagrams.add(partial);
			return;
		}
		
		LinkedList<Character> lettersDeepCopy = new LinkedList<Character>(letters);
		char newChar = lettersDeepCopy.pop();
		for (int i=0; i<partial.length()+1; i++) {
			String possibility = partial.substring(0, i) + newChar + partial.substring(i);
			buildUppon(possibility, lettersDeepCopy, originalWordLenght, anagrams);
		}
		
	}
	
	/**
	 * We pick the last letter in the string and try to move in every other position it can have
	 * each time we call the function again making it explode every possible anagram (sometimes
	 * repeated) and we pick unique copies of each string;
	 * 
	 * The explosion finishes when the level of the tree reaches the length of the word
	 * */
	
	public static Set<String> anagramsSwap(String word) {
		Set<String> part = new HashSet<String>();
		explodeTreeOfSwaps(part, word, 1, word.length());
		return part;
	}
	
	public static void explodeTreeOfSwaps(Set<String> partialSolution, String anagram, int recursionLevel, int originaWordLenght) {
		if (recursionLevel == originaWordLenght) {
			return;
		}
		
		List<String> swaps = crossWord(anagram);
		partialSolution.addAll(swaps);
		for (String swap : swaps) {
			explodeTreeOfSwaps(partialSolution, swap, recursionLevel+1, originaWordLenght);
		}
	}
	
	public static List<String> crossWord(String word) {
		if (word.length() <= 1) return new ArrayList<String>();
		if (word.length() == 2) return Arrays.asList("" + word.charAt(1) + word.charAt(0));
		
		String freePart = word.substring(0, word.length()-1);
		String blockedPart = word.substring(word.length()-1);
		
		List<String> swaps = new ArrayList<String>();
		for (int i=0; i<word.length()-1; i++) {
			String swap = freePart.substring(0, i) + blockedPart + freePart.substring(i);
			swaps.add(swap);
		}
		
		return swaps;
	}

}
