package practice_problems;

import java.util.HashMap;
import java.util.Map;

public class C_TrieContacts
{
	/*	If you wanted to add a dictionary, you would have to 
	 *  add(str) each str for the whole dictionary -- construct the Trie. 
	 * 	*/
	
	public static void main(String[] args)
	{
		Trie tree = new Trie();
	/*	tree.add("monday");
		tree.add("money");
		tree.add("monetize");
		tree.add("mon");
		tree.find("mone");	//returns 2
		tree.find("mon");	//returns 4
*/		
		
		//tree.add("hack");
		//tree.add("hackerrank");
		//tree.find("hac");
		
		
		
		//tree.find("hak");
		
		/*tree.add("ken");
		tree.add("kay");
		tree.add("ke");
		tree.find("ke");*/
		
		
		//__________________________________//__________________________________
		/*tree.add("hack");
		tree.add("hackerrank");
		tree.add("h");*/
		//tree.find("ha" or "h" or "hacke");	//will return 2, 3, 1 respectively		
		
		 /* above case doesn't work b/c counting 'hack' as part of the search
		  * 
		  *  **pseudocode**
		  *  
		  * 	if 'ha'
		  * 		go to last char 'a' and countLeaves&Words('a') (2), store in Count.
		  * 	if 'hacke'
		  * 		go to last char 'e' and countLeaves&Words('e') (1), store in Count.
		  * 	if 'h'
		  * 		go to last char 'h' and countLeaves&Words('h') (3), store in Count.
		  * 		because itself is a contact. So check if the find str iself is a contact.
		  * 
		  *		//when going to "last char", use the traverse(str) function 
		  * 		
		  *  -----------------------
		  *  	find ('hacke')
		  *  		iterate up to last char e
		  *  		countLeaves(e)
		  *  	
		 */		
		
		//tree.find("mond");
	}

	/* counts the words that match the str in find(str).
	 * Will count leaves, because leaves must be words.
	 * It also counts words before leaves -- subword
	 * 
	 * So add("hello") -- leaf, and add("hell") -- subword, returns 2 when calling find("he")
	 * */
	
	public static int countLeaves(Node root)
	{
		int leaves = 0;
		int subwordCounter = 0;
		
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
		
		public Node traverse(String str)
		{
			Node current = root;
			
			for (char ch : str.toCharArray())
			{
				if (current.children.containsKey(String.valueOf(ch)))
				{
					current = current.children.get(String.valueOf(ch));
					System.out.print(ch + " ");
				}
				else{System.out.println("|"+ch+"| is not in the tree.");}
				
				
			}
			System.out.println("");
			return current;
		}
	
		/*
		 * if I wanted to return the word instead of the # of words that match,
		 * I would have to do this in countLeaves function.
		 * 
		 *  */
		public void find(String str)
		{
			if (str.equals("")) {System.out.println("Empty string"); return;}
			
			if (contacts.containsKey(str))
			{
				System.out.println(countLeaves(contacts.get(str))+" results.");
			}
			else 
			{
				//traverse from root to last, return the last as the current
				Node current = traverse(str);
				
				//start counting the leaves here
				System.out.println("Current node is " + current);
				System.out.println("Number of leaves is: " + (countLeaves(current)));
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


