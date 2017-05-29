package MyLinkedList;



	public class Node
	{
		String data = "";
		Node prev = null;
		Node next = null;
		
		public Node()
		{
			data = "";
			prev = null;
		}
		
		
		public Node(String str)
		{
			this.data = str;
		}
		
		@Override
		public String toString()
		{
			return data;
		}
	}

