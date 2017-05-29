package myLinkedList;

public class MyLinkedListTest
{
	private MyLinkedList list;
	MyLinkedListTest()
	{}
	
	//last node's next is null
	public void CreateAcyclicLL()
	{
		list = new MyLinkedList();
		list.add("Four");
		list.add("Three");
		list.add("Two");
		list.add("One");
	}
	
	public void PrintInsertTest()
	{
		//testing the insert at position
		list.print();
		list.insert(4, "X");
		list.print();
	}
	
	//last node points to head
	public void CreateCyclicLL()
	{
		list = new MyLinkedList();
		list.add("Four");
		list.add("Three");
		list.add("Two");
		list.add("One");
		
			//traverse to the end of the list
		Node current = list.head;
		while(current.next != null)
		{
			current = current.next;
		}
		
			//make current's next point to the head to create cycle
		current.next = list.head;
		
		//System.out.println(current.next.data + " " );
	}
	
	public void hasCycleTest()
	{
		if (list.hasCycle(list.head))
		{
			System.out.println("This list has a cycle.");
		}
		else 
			System.out.println("This list does not have a cycle.");
	}
	
	public MyLinkedList getList()
	{
		return list;
	}
}
