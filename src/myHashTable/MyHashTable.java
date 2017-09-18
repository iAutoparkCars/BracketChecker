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
		this.array = new MyLinkedList[this.size];
	}
	
	public void displayTable(){
		// iterate through the whole table and show the elements
		
		
		
		for (int i = 0; i < this.array.length; i++){
			StringBuilder str = new StringBuilder();
			str.append("["+i+"] = ");
			
			if (this.array[i] instanceof MyLinkedList){
				
				MyLinkedList chain = (MyLinkedList) this.array[i];
				str.append(chain.displayChain());
				
			}
				// else should be null
			else {
				
				str.append("null");
				
			}
			
			System.out.println(str.toString());
		}
		
	}
	
		// resolves collision with by chaining a node
	public void resolveCollision(int hashIndex, String key, Object value){
		
		MyLinkedList object = (MyLinkedList) this.array[hashIndex];
		
			// case 1: overwrite value with existing key
		if (object.searchReplaceValueSuccess(key, value)){
			
			System.out.println("key: " + key + " exists. Its value was replaced with value: " + value);
			
		} 
			// case 2: Key not found. Two different keys hashed to same index. append to end
		else {
				object.addEnd( new Node(key, value) );
				System.out.println("No key found, but different keys hashed to same index. Value appended to chain.");
		
		}
		
	}
	/*
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
			
				// create a chain with a first Node
			MyLinkedList newChain = new MyLinkedList(new Node(key, value));
			this.array[hashIndex] = newChain;
			
			System.out.println("Hashed into i = " + hashIndex + " without collision.");
		}
			// else a value already is here; Collision.
		else {
			resolveCollision(hashIndex, key, value);
		}
		
		return true;
	}
	
	/*
	 * return a float value representing the load factor
	 */
	public float load(){

		int numHashed = 0;
		for (int i = 0; i < this.array.length; i++){
			if (this.array[i] != null){
				numHashed++;
			}
		}
		
		return ((float)numHashed/this.array.length);
	}
	
	/*
	 *  return the value associated with the given key, or null if no value is set
	*/
	public Object get(String key){
		
			// get the right chain
		int hashIndex = key.hashCode() % this.size;
		MyLinkedList chain = (MyLinkedList) this.array[hashIndex];
		
			// look for the key in the chain
		Node i = chain.head;
		
			// check all nodes for target key
		while (i != null){
			
			if (i.key.equals(key)){
				return i.data;
			}
			
			i = i.next;
		}
		
			// if key not found, return null
		return null;
	}
	
	public Object delete(String key){
		
			// get the right chain
		int hashIndex = key.hashCode() % this.size;
		MyLinkedList chain = (MyLinkedList) this.array[hashIndex];
		
		/*if (chain.searchReplaceValueSuccess(key, null)){
			return true;
		}*/
		
			// look for the key in the chain
		Node i = chain.head;
		
			// return data that is deleted
		Object data;
		
			// check all nodes for target key
		while (i != null){
			
			if (i.key.equals(key)){
				data = i.data;
				
				
					//if first Node in chain
				if (i.next != null && i.prev == null){
					i.next.prev = null;
					chain.head = i.next;
					return data;
				
				}
					// if nothing after(last Node), delete current Node
				if (i.next == null){
					i.prev.next = null;
					i = null;
					return data;
				}
				
					// if Node in between other Nodes
				if (i.next != null && i.prev != null){
						// Connect previous to next Node
					i.prev.next = i.next;
					i.next.prev = i.prev;
					
						// delete current
					i.next = null;
					i.prev = null;
					return data;
					}
				}
			
				i = i.next;
		}
		
		return null;
	}
	

	public static void main(String[] args){
		
		MyHashTable table = new MyHashTable(2);
		
		
		table.set("Hello",  new String("Object1"));
		table.set("Hello",  new String("Object2"));
		table.set("Hello",  new String("Object3"));
		
		
		table.set("Key3",  new String("Object4"));
		//table.set("Test1",  new String("Object5"));
		
		table.set("index",  new String("Object5"));
		
		
		/*
		 * Now to simulate two different keys hashing to same place in the hashTable
		*/
		
		
		
		/*//test with table size 7
		System.out.println(table.get("Hello"));
		System.out.println(table.get("Key3"));*/
		
		//now test changing table size to 2
		//System.out.println(table.get("index"));
		
			// testing delete
		//System.out.println(table.delete("Hello"));
		System.out.println(table.delete("index"));
		
		table.displayTable();
		
		
		//System.out.println(table.load());
		
	}
	
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
	
    public boolean isPrime(int n) {
        
    	if (n == 2) return true;
    	if (n < 2) return false;
        if (n % 2 == 0) return false;
        for (int i = 3; i * i <= n; i += 2)
            if (n % i == 0) return false;
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
		Node prev;
		
		Node(String key, Object data){
			this.data = data;
			this.key = key;
		}
		
		@Override
		public String toString(){
			return "("+data+")";
		}
	}
	
	public static class MyLinkedList{
		Node head;
		
		MyLinkedList(){
			head = null;
		}
		
		MyLinkedList(Node node){
			head = node;
		}
		
			// args: Node to add to end
		void addEnd(Node node){
			if (head==null){
				head = node;
			}
			else{
				//traverse to end
				Node oldEnd = getLastNode();
				oldEnd.next = node;
				node.prev = oldEnd;
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
		
		/*
		 * Search for the key in this LinkedList. Replace the value if key was found.
		 */
		boolean searchReplaceValueSuccess(String key, Object value){
			boolean result = false;

			Node i = head;
			
				// check all nodes for target key
			while (i != null){
				
				if (i.key.equals(key)){
					i.data = value;
					return true;
				}
				
				i = i.next;
			}
			
			return result;
		}
		
		String displayChain(){
			
			StringBuilder str = new StringBuilder();

			Node i = head;
			
			while (i != null){
				
				str.append("-> "+i);
				i = i.next;
				
			}
			
			return str.toString();
		}
		
	}
}
