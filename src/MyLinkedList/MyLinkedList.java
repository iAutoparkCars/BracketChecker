package MyLinkedList;


public class MyLinkedList
{
	Node head; 
	
	
	public MyLinkedList()
	{
		head = null;
		//why am I able to compare if head is null, but I'm unable to compare if head.next is null? (NullPointer)
	}
	
	public Boolean isEmpty()
	{
		//System.out.println(head);
		//System.out.println(head.next);

		return head==null;
	}

	public void add(String str)
	{
		if (isEmpty())
		{
			head = new Node(str);
		}
		else 
		{
			Node newHead = new Node(str);
			newHead.next = head;
			head = newHead; 		//head becomes newHead
			
			//OR
			
			//newHead = head;
		}
	}

	//if i = 0, make the new node the head
	//if i=1, make new node between head and first
	public void insert(int i, String str)
	{
		Integer counter = 0;
		Node temp = head;
		//System.out.println(temp);
		while(temp!=null)
		{
			if (i==0)
			{
				add(str);
				return;
			}
			else if (i==counter+1)
			{
				Node newNode = new Node(str);
				/*temp.next = newNode;
				newNode.next = temp.next;	//newNode is now temp.next, so will be referencing itself!
				*/
				
				newNode.next = temp.next;	
				temp.next = newNode;
				
				
				return;
			}
			
			temp = temp.next;
			counter++;
		}
		
	}
	
	public void print()
	{
		if (isEmpty())
		{
			return;
		}
		else
		{
			Node temp = new Node();
			temp = head;
			while(temp != null)
			{
				System.out.println(temp);
				temp = temp.next;
			}
			//System.out.println(temp);
		}
	}
}