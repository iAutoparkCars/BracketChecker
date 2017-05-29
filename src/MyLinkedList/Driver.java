package MyLinkedList;



public class Driver
{

	public static void main(String[] args)
	{
		MyLinkedList list = new MyLinkedList();
		list.add("Four");
		list.add("Three");
		list.add("Two");
		list.add("One");

		//list.print();
		list.insert(4, "X");
		//System.out.println("________________________________________");
		list.print();
		
		
		/*
		 * [head] -> null
		 * 
		 * 
		 * [head] -> [first]
		 * 
		 * */
		
		
		//list = null;
		
	}
	
}
