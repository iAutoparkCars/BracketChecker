package c_TrieContacts;

import java.util.HashMap;
import java.util.Map;

public class TrieContacts
{
	public static void main(String[] args)
	{
		Trie tree = new Trie();
		tree.add("hello");
		tree.traverse("hello");
	}


	public static class Node
	{
		private Map<String,Node> children;
		public Node() {children = new HashMap<String, Node>();}
		
		public void put(String letter, Node nxtNode)
		{
			children.put(letter, nxtNode);
		}
		
		public boolean hasNext() {return !children.isEmpty();}
	}
	
	public static class Trie
	{
		public Node root;
		public Trie() {root = new Node();}
		
		public void add(String str)
		{
			//current to iterate through the whole tree
			Node current = root;
			
			//need a place to store the place of the current(but now at root)
			Node newRoot = current;
			
			for (char ch : str.toCharArray())
			{
				current.children.put(String.valueOf(ch), new Node());
				
				
				current = current.children.get(String.valueOf(ch));
				if (current==null) {System.out.println("current is null."); return;}
			}
			
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
					System.out.println(ch + " ");
				}
				else{System.out.println("Reached end of the tree");	return;}
				
				current = current.children.get(String.valueOf(ch));
			}
		}
	}
	
	
}


