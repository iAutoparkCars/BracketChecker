package print_max_BST;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class Solution
{
	public static void main(String args[] ) throws Exception {
        
        //* Read input from stdin and provide input before running
        //* Use either of these methods for input
		
		StringBuilder sb = new StringBuilder();
		sb.append("5 \n")
			.append("4 7 8 6 3 \n")
			.append("3 7");
			
       //BufferedReader
       /*BufferedReader br = new BufferedReader(new InputStreamReader());
       String line = br.readLine();
       int N = Integer.parseInt(line);*/

		//Scanner
		
	   BST graph = new BST();
		
       Scanner s = new Scanner(sb.toString());
       int N = s.nextInt();
      
       for (int i = 0; i < N; i++)
       {
    	   graph.insert(s.nextInt());
    	   //System.out.print(s.nextInt() + " " );  
       }
      
      int start = s.nextInt();
      int end = s.nextInt();
      
      graph.printTree();
      //findMax(start,end);
      
      s.close(); 

   }
	
	public static class BST
	{
		ArrayList<Integer> tree = new ArrayList<Integer>();
		public Integer root;
		
		public BST()
		{}
		
		public void insert(Integer e)
		{
			if (e != null && root == null)
			{
				tree.add(null);
				tree.add(e);
				root = tree.get(1);
			}
			else if (e == null)
			{
				
			}
			//else if (parent(e))
		}
		
		public void parent(Integer e)
		{
			
		}
		
		public void leftChild(Integer e)
		{
			
		}
		
		public void rightChild(Integer e)
		{
			
		}
		
		public void printTree()
		{
			
			System.out.print(tree);
			
		}
	}
	
	public static void findMax(int start, int end)
	{
		System.out.println("\n" + start + " " + end);
	}
}
