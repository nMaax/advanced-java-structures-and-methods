package recursion;

public class ReverseString {

    /*
        Init case: print last char
        
        i-case: apply recursion on the remaning chars
        
        Final case: print the first char
    
        Option (1)
        
        --> Take a string as a parameter; 
            Print the last char;
            Call the function on the remaining string
            
        
        If i have to modify the parameter  in place...
        
        Option (2)
        
        1) [a b c d e f]
        2) [f b c d e a]
        3) [f e c d b a]
        4) [f e d c b a]
        
        - Swap the element on the endges
        - Swap the ements on the second and before-last pos
        - Swap the element in the third and before-before-last pos
        - ...
        - Swap the middle elements (or do nothing if s has odd length)
        
        --> Swap the elements on index 0 and length-0
        --> Swap the elements on index 1 and length-1
        ...
        
        Take s as parameter, 
        Take index of swap as parameter
        Swap on index and length-index
        Recurse on index+1
        
        If index == Lenght / 2 --> Stop (Basic Case)
        
        c i a o --> i=0, i == 4 / 2 == 2 : false --> o i a c
        
        o i a c --> i=1, i == 4 / 2 == 2 : false --> o a i c
        
        o a i c --> i=2, i == 4 / 2 == 2 : true, stop
    
        ciao --> stop at i = 2
        abcdefg --> stop at i = 3 (7/2 = 3.5)

    */

	
	public static void main(String[] args) {
		char[] s = "Andromeda".toCharArray();
		System.out.println(s);
		reverseString(s);
		System.out.println(s);
	}
	    
    public static void reverseString(char[] s) {
        swap(s, 0);
    }
    
    public static void swap(char[] s, int i) {
        if (i == s.length / 2) return;

        char temp = s[s.length-1  - i];
        s[s.length-1 - i] = s[i];
        s[i] = temp;
        
        swap(s, i+1);
    }
}
