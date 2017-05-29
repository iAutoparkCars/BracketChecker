package bracketChecker;
import java.util.*;

public class Solution {

    public static void main(String[] args)
    {
    	SolutionTest t1 = new SolutionTest();
    	
    	//String hi = "";
        Scanner in = new Scanner(t1.testString);
        int t = in.nextInt();   //the int specifies the number of strings to read in
        
        for(int a0 = 0; a0 < t; a0++)
        {
            String s = in.next();
            convert(s);
        }
        in.close();
    	
    }
    
    public static void convert(String bracket)
    {
        if(bracket.length()%2 != 0)
        {
            System.out.println("NO");
            return;
        }    
        
        //create stack and convert to char array
        char[] array = bracket.toCharArray();
        //System.out.print(bracket + " ");
        useStack(array);
        
    }
    
    public static void useStack(char[] array)
    {
        Stack<Character> stack = new Stack();
        for (int i = 0; i< array.length; i++)
        {
            Character ch = array[i];
            if (isOpen(ch))
            {    
                stack.push(ch);
            }
            else if (isClosed(ch) && stack.isEmpty())
            {System.out.println("NO"); return;}
            
            else if(isClosed(ch))
            {
                if (isMatched(stack.peek(),ch))
                {
                    stack.pop();
                } 
            }
                    
        }
        if (stack.isEmpty())
            {System.out.println("YES"); return;}
        else
            {System.out.println("NO"); return;}
        
        //while(!stack.isEmpty())
        //{System.out.println(stack.pop());}    
    }
    
    
    
        public static Boolean isOpen(char ch)
        {
            return (ch=='{' || ch=='[' || ch=='(');
        }
        
       
        public static Boolean isClosed(char ch)
        {
             return (ch=='}' || ch==']' || ch==')');
        }
        
        public static Boolean isMatched(char open, char close)
        {
            Boolean result = false;
         if (open=='{' && close=='}')
         {result = true;}
         else if (open=='(' && close==')')
             {result = true;}
         else if (open=='[' && close==']')
         {result = true;  } 
            return result;
         }
}