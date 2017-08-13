package practice_problems;

import java.io.*;
import java.util.*;


interface Cache {
  String get(String key);
  void put(String key, String value);
}

class LRU_Cache implements Cache {

  private final int size;
  
    // storing all the keys in the LinkedList
  private LinkedList<String> keys = new LinkedList<String>();
  
    // mapping each key to a value when I put it in the Cache
  private HashMap<String, String> map = new HashMap<String, String>();

  public LRU_Cache(int size) {
	  
    this.size = size;
  }

  public void moveKeyToFront(String key){
        // remove key and append it to the end
      keys.remove(key);
      keys.add(key);
  }
  
  public void kickOffOldestKey(){
      //remove from front of linked list & remove from the map 
      keys.remove(0);
  }
  
  
  @Override
  public String get(String key)  {
    // TODO get something out of the cache
    System.out.println("get!");
    
    
    
    
    
    
    return null;      //returns value associated with the key
  }

  @Override
  public void put(String key, String value)  {
    
     // case: if max has not been reached, no kicking off
    
      /* if # keys are less than max size AND map doesn't contain the key
              add normally
      */
    
    // 2. less than size, doesn't contain key
    if (map.size() < size && !map.containsKey(key)){
        
        keys.add(key);
        map.put(key, value);
    }
    
      //1. less than size, already contains key
      // if map already contains the key, move the key to the front
    else if (map.size() < size && map.containsKey(key)){
        keys.add(key);
        map.put(key, value);
        moveKeyToFront(key);
    }
    
    // 3. greater than/equal to size, already contains key
    else if (map.size() >= size && map.containsKey(key)){
      
        //insert because the key will be replaced, but
        //move the value to the front
      
        map.put(key, value);
        moveKeyToFront(key);
    
    }
      //4. greater than/equal to size, doesn't contain key
    else if (keys.size() >= size && !map.containsKey(key)){
      
        //kick off oldest key, add new key
        
      
      
    }
          
    
    System.out.println("put!");
  }
}

  


class SolutionCache {
  public static void main(String[] args) {
    
    LRU_Cache cache = new LRU_Cache(10);
    System.out.println(cache.get("test"));
    cache.put("key", "value");
    System.out.println(cache.get("key"));
    
    
    // cache size 3
    // put "foo"
    // put "bar"
    // put "baz"
    // put "uhoh"
    // get "foo" - nonexistent
    
    /*
      [baz, foo uhoh]
      
      
    
    */
    
    // cache size 3
    // put "foo"
    // put "bar"
    // put "baz"
    // get "foo"
    // put "uhoh"
    // get "foo" - exists
    // get "bar" - nonexistent
    
    //[ foo, bar, baz, uhoh] -> 
    
    
    
  }
  
    
  
}
