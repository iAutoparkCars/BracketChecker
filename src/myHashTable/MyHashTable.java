package myHashTable;

public class MyHashTable {
	
	// only primitive types
	int size;
	Object[] array;
	
	int SEARCH_LIMIT = 15;
	
	public MyHashTable(int size){
		
			// get prime number. 
		try{
			this.size = getNextPrime(size, SEARCH_LIMIT);
		} catch(Exception e){
			System.out.println("Run-time error occured while trying to find next prime.");
			e.printStackTrace();
		}
		
			// check for error
		if (this.size == -1){
			System.out.println("Prime wasn't found within search limit.");
			System.exit(0);
		}
		
			// makes an array of prime size
		this.array = new String[this.size];
	}
	
	public void showTable(){
		// iterate through the whole table and show the elements
		
	}
	
		// resolves collision with by chaining a node
	public void resolveCollision(int hashIndex, String key, Object value){
		
		Object object = this.array[hashIndex];
		
			// if a chain exists, then append a new Node to end of chain
		if (object instanceof MyLinkedList){
			System.out.println("Collision. Chain already exists; append value to end.");
			
				// add new Node to end of the chain
			((MyLinkedList) object).addEnd(new Node(key, value));
		}
			// chain is not created, create the first Node
		else {
			
			
			
			/* 
			 * Replacing a key with a new value. 
			 * 
			 * Problem: There is a value here. Do I create chain, or replace value?  
			 * 
			 * the value you are re-setting is a result of trying to store
			 * a different value with same key, or is it a collision?
			 * 
			*/
			System.out.println("Create a chain now. First value in chain.");
			
				// create new chain; add value
			MyLinkedList chain = new MyLinkedList();
			chain.addEnd(new Node(key, value));
			
				// this will be the resulting array
			Object[] result = new Object[this.array.length];
			
				// copy original array into result
			for (int i = 0; i < this.array.length; i++){
				result[i] = this.array[i];
			}
			
				// now I can store a MyLinkedList object
			result[hashIndex] = chain;
			this.array = result;
		}
		
		
			
		
		
		
		

			
	}
	/*
	 * 	Problem: deleting. What if you delete an entry with collisions?
	 * 		Then the whole chain would be gone, the value of another key will be removed.
	 * 
	 *  To make sure you want to delete the item associated with a key, make the array
	 *  Store Nodes that have the String key as a marker
	 * 	
	 * 
	 * 
	 *  If a key already exists, must delete the old key, then re-insert.
	 *  
	 *  if two different keys produce the same hashIndex, they will get stored in the same place.
	 *  
	 *  If you want to change the value of the key with a key already already hashed,
	 *  	check if it's a LinkedList
	 *  		which value do I replace? This is problem that needs another mechanism to solve it
	 *  	if not LinkedList,
	 *  		just replace the value
	 *  
	*/
	public boolean set(String key, Object value){
		
		int hashIndex = key.hashCode() % this.size;
		
			// if no value here, store it
		if (this.array[hashIndex] == null){
			
			System.out.println("Hashed into i = " + hashIndex + " without collision.");
			this.array[hashIndex] = value;
		}
			// else a value already is here; Collision.
		else {
			resolveCollision(hashIndex, key, value);
		}
		
		return true;
	}
	
	public static void main(String[] args){
		
		MyHashTable table = new MyHashTable(9);
		
		table.set("Hello",  new String("Object1"));
		table.set("Hello",  new String("Object2"));
		table.set("Hello",  new String("Object3"));
		table.set("Hello",  new String("Object4"));
		
		
		//printArray(table.array);
	}
	
	/*public static boolean isPrime(int number){ 
		
		boolean isPrime = true;
		int temp;
		
		for(int i=2;i<=number/2;i++)
		{
	           temp=number%i;
		   if(temp==0)
		   {
		      isPrime=false;
		      break;
		   }
		}
		
		return isPrime;
	}*/

	// if size is prime, use size. If not, get next highest prime for array size. 
	private int getNextPrime(int number, int search_cap){
		
		
		for (int i = 0; i < search_cap; i++){
			
			if (isPrime(number)){
				//System.out.println(number);
				return number;
			}
				// it's odd; go to next odd to find prime
			else if (number%2 != 0){
					number+=2;
			}
				// it's even. go to odd
			else{
				number++;
			}
		}
		
			// getting here means error
		return -1;
	}
	
    static boolean isPrime(int n) {
        
    	if (n < 2) return false;

        int maxIteration = (int) Math.ceil(Math.sqrt(n));

        for (int i = 2; i < maxIteration; i++) {
            if(n % i == 0)
                return false;
        }

        return true;
    	
    }
	
	public static void printArray(Object[] arr){
		System.out.print("[ ");
		for (int i = 0; i < arr.length; i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println("] ");
	}

	public static class Node{
		String key;
		Object data;
		Node next;
		Node(String key, Object data){
			this.data = data;
			this.key = null;
		}
	}
	
	public static class MyLinkedList{
		Node head;
		
		MyLinkedList(){
			head = null;
		}
		
			// args: Node to add to end
		void addEnd(Node node){
			if (head==null){
				head = node;
			}
			else{
				//traverse to end
				Node end = getLastNode();
				end.next = node;
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
