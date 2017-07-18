package bracketChecker;
import java.util.*;

public class Solution {

    public static void main(String[] args)
    {
    	/*SolutionTest t1 = new SolutionTest();
    	
    	//String hi = "";
        Scanner in = new Scanner(t1.testString);
        int t = in.nextInt();   //the int specifies the number of strings to read in
        
        for(int a0 = 0; a0 < t; a0++)
        {
            String s = in.next();
            convert(s);
        }
        in.close();*/
    	
    	
    	//String a = " have a lot of fun  ";
    	//System.out.println(a.trim());
    	
    	String s = "ringtones-exntesion.txt";
    	
    	System.out.println(removePrefix(s));
    	
    }
    static String prefix = "ringtones-";
    private static String removePrefix(String name)
    {
        char[] result = new char[name.length()-prefix.length()];
        int res_i = 0;
        char[] nameCh = name.toCharArray();


        if (name.contains(prefix))
        {
            for (int i = prefix.length(); i < nameCh.length; i++)
            {
               result[res_i] = nameCh[i];
               res_i++;
            }
        }
        else
        {
            System.out.println(name + "has no file prefix");
            return "NoPrefix";
        }

        return String.valueOf(result).trim();
    }

    
    
    private enum Ringtone
    {
        NORMAL(0),
        LOUD(1),
        VERYLOUD(2),
        DANGER(3);

        private int ringtone;
        
        Ringtone(int ringtone){
        	this.ringtone = ringtone;
        }
        
        @Override
        public String toString()
        {
        	if (super.toString().equals("VERYLOUD"))
        	{
        		return "VERY LOUD";
        	}
        	else 
        		return super.toString();
        }
    
        public int toInt()
        {
        	return this.ringtone;
        }
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