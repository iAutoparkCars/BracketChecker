package zen_challenge;

import java.util.Scanner;
import java.util.Stack;

public class MakePalindrome {

	public static void main(String[] args) {

		System.out.println("Input is: \n" + buildTest());
		Scanner cin = new Scanner(buildTest());
		String input = cin.nextLine().trim();
		
		System.out.println("The output is ");

		makePalindrome(input);

	
	}

	public static String buildTest()
	{
		StringBuilder sb = new StringBuilder();
		sb.append(" aabbabb \n");
			
		return sb.toString();
	}
	
	public static Boolean isAPalindrome(String input)
	{
		Stack<Character> stack = new Stack<Character>();
		
		char[] arr = input.toCharArray();
		
		for (char c : arr)
		{
			stack.push(c);
		}
		
		String reverse = "";
		
		while (!stack.isEmpty())
		{
			reverse = reverse + stack.pop();
		}
		
		return reverse.equals(input);
	}
	
	public static void makePalindrome(String input)
	{
		char[] arr = input.toCharArray();
		int i = 0;
		String result = "";
		
		while(!isAPalindrome(input))
		{
			input = input + arr[i];
			result = result + arr[i];
			
			if (input.length() > arr.length*2)
			{
				System.out.println("Cannot be added to make a palindrome using this method");
				break;
			}
		}
		
		System.out.println(result);
	}
}
