package practice_problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class I_SubstrConcat {

	public static void main(String[] args){
		
		String s = "barfoothefoobarman";
		String[] a = {"foo", "bar"};
		
		// should return [0,9] 
		Solution solution = new Solution();
		System.out.println(solution.findSubstring(s, a));
	}
	
	public static class Solution {
		
		HashSet<String> wordSet = new HashSet<String>();
		HashSet<String> stringSet = new HashSet<String>();
		
	    public List<Integer> findSubstring(String s, String[] words) {
	        
	    	List<Integer> result = new ArrayList<Integer>();
	    	
	    	int length = words[0].length();
	    	char[] chars = s.toCharArray();
	    	
	    	hashWords(words);
	    	
	    	for(int i = 0; i < chars.length; i+=length) {
	    		
	    		//System.out.println(chars[i]);
	    		/*
	    		 *  iterate through every word, length 3, if one word is found in the Set,
	    		 * 	check if the following word is in the Set. 
	    		 */
	    		
	    		//System.out.println(createSubStr(chars, i, length));
	    		
	    		// check if the string is in the set of words
	    		stringSet.add(currentSubStr(chars, i, length));
	    	
	    		if (wordSet.contains(currentSubStr(chars, i, length)) && 
	    				wordSet.contains(currentSubStr(chars, i+length, length)) ) {
	    			// check if next one over is also in wordSet
	    				
	    			result.add(i);
	    			
	    		}
	    		
	    	}
	    	
	    	return result;
	    }
	    
	    public void hashWords(String[] words) {
	    	for (int i = 0; i < words.length; i++) {
	    		wordSet.add(words[i]);
	    	}
	    }
	    
	    public String currentSubStr(char[] chars, int base, int length) {
	    	StringBuilder subStr = new StringBuilder();
	    	
	    	for (int i = base; i < base+length; i++) {
	    		subStr.append(chars[i]);
	    	}
	    	return subStr.toString();
	    }
	    
	}
	
}
