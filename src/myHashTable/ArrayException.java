package myHashTable;

public class ArrayException {
	
	public static void main(String[] args){
		
		//case1();
		case2();
		
	}
		
		static void case1(){
			Object[] objects = "a;b".split(";");
			objects[0] = 22;
		}
		
		static void case2(){
			
			
				// new array of Objects, the RESULT
			Object[] result = new Object[3];
			
			MyLinkedList[] old = {new MyLinkedList(), new MyLinkedList()};
			
				// move String values into Object array
			for (int i = 0; i < old.length; i++){
				result[i] = old[i];
			}
			
				// now I can assign different type into RESULT
			result[0] = 22;
			
		}
		
		public static class Node{
			Object data;
			Node next;
			Node(Object data){
				this.data = data;
			}
		}
		
		public static class MyLinkedList{
			Node head;
			
			MyLinkedList(){
				head = null;
			}
			
			void addEnd(Object data){
				if (head==null){
					head = new Node(data);
				}
				else{
					//traverse to end
					Node end = getLastNode();
					end.next = new Node(data);
				}
				
			}
			
				// Don't use this on an empty LinkedList
			Node getLastNode(){
				Node temp = head;
				
				while (temp.next != null){
					temp = temp.next;
				}
				return temp;
			}
			
		}
}
