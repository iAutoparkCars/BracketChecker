package practice_problems;

import java.util.HashMap;
import java.util.LinkedList;

public class F_Cache {
	
	interface Cache {
		  String get(String key);
		  void put(String key, String value);
	}
	
	public static class LRU_Cache implements Cache{
		
		private int size;
		HashMap<String,String> keys = new HashMap<String,String>();
		LinkedList<String> cache = new LinkedList<String>();
		
		public LRU_Cache(int size){
			this.size = size;
		}
		
		@Override
		public String get(String key){
			
				// if used, move to front
			if (keys.containsKey(key)){
				moveKeyToFront(key);
			}
			return keys.get(key);
		}
		
		@Override
		public void put(String key, String value){
			
			
				// check size; if more than max; kick off oldest
			if ((keys.size() + 1) > size){
				String oldKey = cache.get(0);
				cache.remove(0);
				keys.remove(oldKey);
			}
			
				// if key does not exist, add to front of cache
			if (!keys.containsKey(key)){
				keys.put(key, value);
				cache.addLast(key);
			}
			
				// if key does exist, add to front of cache
			else if (keys.containsKey(key)){
				moveKeyToFront(key);
			}
			
			for (String s : keys.keySet()){
				System.out.print(s + " ");
			}
			System.out.println("");
			
		}
	
		public void moveKeyToFront(String key){
			cache.remove(key);
			cache.addLast(key);
		}
		
	}	//end LRU Cache class
	
	
	public static void main(String[] args) {
		LRU_Cache cache = new LRU_Cache(3);
	    cache.put("key1", "value1");
	    cache.put("key2", "value2");
	    cache.put("key3", "value3");
	    cache.put("key4", "value4");
	    
	    System.out.println(cache.get("key1"));
	}
	
	

}
