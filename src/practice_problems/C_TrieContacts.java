package practice_problems;

import java.util.HashMap;
import java.util.Map;

public class C_TrieContacts
{
	public static void main(String[] args)
	{
		Trie tree = new Trie();
		tree.add("monday");
		tree.add("money");
		tree.add("monetize");
		tree.add("mon");
		
		tree.find("mon");
		
		//tree.add("hack");
		//tree.add("hackerrank");
		//tree.find("hac");
		
		
		
		//tree.find("hak");
		
		
		
		//tree.find("mond");
	}

	public static int countLeaves(Node root)
	{
		int leaves = 0;
		
		//base case
		if (root.children.size()==0)
			leaves++;
		else
		{
			for (Node child : root.children.values())
			{
				leaves = leaves + countLeaves(child);
			}
		}
		
		return leaves;
	}

	public static class Node
	{
		private Map<String,Node> children;
		private String value;
		public Node(String val) {children = new HashMap<String, Node>(); this.value = val;}
		
		public void put(String letter, Node nxtNode)
		{
			children.put(letter, nxtNode);
		}
		
		@Override
		public String toString() {return value;}
		
		public boolean hasNext() {return !children.isEmpty();}
	}
	
	public static class Trie
	{
		public Node root;
		private int redundantCounter;
		public Trie() {root = new Node(null);}
		
		public void add(String str)
		{
			//current to iterate through the whole tree
			Node current = root;
			
			//need a place to store the place of the current(but now at root)
			Node newRoot = current;
			
			for (char ch : str.toCharArray())
			{
				
				if (current.children.containsKey(String.valueOf(ch)))
				{
					current = current.children.get(String.valueOf(ch));
				}
				else //if not in children, add it
				{
					current.children.put(String.valueOf(ch), new Node(String.valueOf(ch)));
					current = current.children.get(String.valueOf(ch));
				}
				if (current==null) {System.out.println("current is null."); return;}
			}
			
			
			
			//the first current becomes the new root of the tree
			root = newRoot;
			
			//check here if the tree is the same as before. If "added" and tree is same, then add to counter
		}
		
		public void traverse(String str)
		{
			Node current = root;
			
			for (char ch : str.toCharArray())
			{
				if (current.children.containsKey(String.valueOf(ch)))
				{
					System.out.print(ch + " ");
				}
				else{System.out.println("|"+ch+"| is not in the tree.");	return;}
				
				current = current.children.get(String.valueOf(ch));
			}
			System.out.println("");
		}
	
		public void find(String str)
		{
			String substr = "";
			int substrCounter = 0;
			
			String tempStr = "";
			
			Node current = root;
			
			for (char ch : str.toCharArray())
			{
				if (!current.children.containsKey(String.valueOf(ch)))
				{
					System.out.println(str+" is not in the tree");
					return;
				}
				current = current.children.get(String.valueOf(ch));
				
				tempStr = tempStr + ch;
			}
			
			
			
			//start counting the leaves here
			
			System.out.println("Current node is " + current);
			System.out.println("Number of leaves is: " + countLeaves(current) + substrCounter );
		}
	
		
		
	}
	
	public static class Test
	{
		//correctly returns 3
		public void case1(){
			Trie tree = new Trie();
			tree.add("nd");
			tree.add("ne");
			tree.add("nxf");
			tree.find("n");
		}
		
		//correctly says that n is not in the tree
		public void case2() {
			Trie tree = new Trie();
			tree.find("n");
		}
	}
}


