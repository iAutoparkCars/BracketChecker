package practice_problems;

import java.util.HashMap;
import java.util.Map;

public class C_TrieContacts
{
	public static void main(String[] args)
	{
		Trie tree = new Trie();
		/*tree.add("monday");
		tree.add("money");
		tree.add("monetize");
		tree.add("mon");
		
		tree.find("mon");*/
		
		//tree.add("hack");
		//tree.add("hackerrank");
		//tree.find("hac");
		
		
		
		//tree.find("hak");
		
		/*tree.add("ken");
		tree.add("kay");
		tree.add("ke");*/
		
		
		tree.add("hack");
		tree.add("hackerrank");
		tree.add("h");
		//tree.find("ha" or "h" or "hacke");			
		tree.find("hacke");
		
		 /* above case doesn't work b/c counting 'hack' as part of the search
		  * 
		  * //difference searching between 'ha' and 'hacke'?
		  * 
		  * 	if 'ha'
		  * 		go to last char 'a' and countLeaves&Words('a') (2), store in Count.
		  * 	if 'hacke'
		  * 		go to last char 'e' and countLeaves&Words('e') (1), store in Count.
		  * 	if 'h'
		  * 		go to last char 'h' and countLeaves&Words('h') (3), store in Count.
		  * 		because itself is a contact. So check if the find str iself is a contact.
		  * 
		  *		//when going to "last char", consider using your traverse function 
		  * 		
		  * 	
		  * 	Result = Count + subCounter
		  * 
		  *  	//iterate appending chars 
		  *  	find('hacke')
		  *  	
		  *  	 
		  *  	if find('hacke')
		  *  -----------------------
		  *  	find ('hacke')
		  *  		iterate up to last char e
		  *  		countLeaves(e)
		  *  	
		  *  	
		  *  
		  *   	
		  *   
		  *  
		  *  
		 */		
		
		
		//System.out.println(countLeaves(tree.root.children.get("h")));
		
		
		
		
		//tree.find("mond");
	}

	public static int countLeaves(Node root)
	{
		int leaves = 0;
		int subwordCounter = 0;
		
		/*if (root.isWord)
			subwordCounter++;*/
		
		//base case. Increment leaves OR child. Increment both would be double-counting
		if (root.children.size()==0)
			leaves++;
		else if (!(root.children.size()==0) && root.isWord)
		{
			subwordCounter++;
		}
		
		for (Node child : root.children.values())
		{
			leaves = leaves + countLeaves(child);
		}
		
		return leaves+subwordCounter;
	}

	public static class Node
	{
		public Map<String,Node> children;
		private String value;
		public Node(String val) {children = new HashMap<String, Node>(); this.value = val;}
		public boolean isWord = false;
		
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
		//stores all contacts added, with value as the last relevant node. so "John" will store 'n" as its value
		public Node root;
		public Map<String,Node> contacts;
		
		public Trie() {root = new Node(null); contacts = new HashMap<String,Node>(); }
		
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
			
			contacts.put(str, current);
			
			System.out.println("last node is "+current);
			if (current.isWord)
			{System.out.println("\'"+str+"\' already exists. Not added"); return;}
			
			
			current.isWord = true;	
			
			//the first current becomes the new root of the tree
			root = newRoot;
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
			if (contacts.containsKey(str))
			{
				System.out.println(countLeaves(contacts.get(str))+" results.");
			}
			else 
			{
			    int subWordCounter = 0;
				Node current = root;
				String subWord = "";
				
				for (char ch : str.toCharArray())
				{
					if (!current.children.containsKey(String.valueOf(ch)))
					{
						System.out.println(str+" is not in the tree");
						return;
					}
					
					current = current.children.get(String.valueOf(ch));
					if (current.isWord)
						subWordCounter++;
					
					subWord = subWord+ch;
					if (contacts.containsKey(subWord))
					{
						
					}
				}
				
				//start counting the leaves here
				System.out.println("Current node is " + current);
				System.out.println("Number of leaves is: " + (subWordCounter + countLeaves(current)));
			}
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


