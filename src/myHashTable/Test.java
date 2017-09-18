package myHashTable;

public class Test {
	
public static void main(String[] args){
		
		/*
		 * Shows same key hashed again with new value with replace old value. (re-set values)
		 * HashTable size small to also show different keys hashing to same place in the hashTable.
		 */
		testSetGet();
	
		
		/*
		 * Deleting and getting elements that don't exist; return null
		*/
		testGetDelete();
	
		/*
		 * Deleting and getting elements from a chain of collisions.
		*/
		testGetDeleteChain();
		
	}
	
		// array size intentionally small to cause collisions
	public static void testSetGet(){
		
		System.out.println("\t>> Test 1:");
		
		MyHashTable table = new MyHashTable(2);
		table.set("Hello",  new String("Object1"));
		table.set("Hello",  new String("Object2"));
		table.set("Hello",  new String("Object3"));
		
		table.set("Key3",  new String("Object4"));
		table.set("Test1",  new String("Object5"));
		table.displayTable();
		
		String str = (String)table.get("Test1");
		System.out.println(str);
		System.out.println("Load: " + table.load() + "\n");
	}
	
		// deleting things from the Chain of Collisions
	public static void testGetDelete(){

		System.out.println("\t>> Test 2:");
		
		MyHashTable table = new MyHashTable(2);

		table.set("Hello",  new String("Object1"));
		table.set("Hello",  new String("Object2"));
		table.set("Hello",  new String("Object3"));
		
		System.out.println(table.get("Key3"));
		
		System.out.println(table.delete("Key3"));
		System.out.println(table.delete("Hello"));
		
		table.displayTable();
		System.out.println("Load: " + table.load() + "\n");
	}
	
	public static void testGetDeleteChain(){

		System.out.println("\t>> Test 3:");
		
		MyHashTable table = new MyHashTable(2);

		table.set("Hello",  new String("Object1"));
		table.set("Key3", "Object2");
		table.set("Key5", "Object3");
		
		System.out.println(table.get("Key3"));
		
			// testing deleting value from middle of chain
		System.out.println(table.delete("Key3"));
		
		table.displayTable();
		System.out.println("Load: " + table.load() + "\n");
	}
}
