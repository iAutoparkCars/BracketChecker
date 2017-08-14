package practice_problems;

import java.util.Comparator;
import java.util.PriorityQueue;

public class H_MergeLists {
	
	public static void main(String[] args) {
		
			// [ 1, 3]
		ListNode n1 = new ListNode(1);
		ListNode n3 = new ListNode(3);
		n1.next = n3;
			
			// [ 10, 11]
		ListNode n10 = new ListNode(10);
		ListNode n11 = new ListNode(11);
		n11.next = n10;
		
			// [ 5, 6]
		ListNode n5 = new ListNode(5);
		ListNode n6 = new ListNode(6);
		n6.next = n5;
			
			// [ [1, 3], [10, 11], [5, 6],]  unsorted
		ListNode[] test1 = {n1, n11, n6};
		
		Solution solution = new Solution();
		solution.mergeKLists(test1);
	}
	
	 /**
	  * Definition for singly-linked list.
	  */
	  public static class ListNode {
	     public int val;
	     ListNode next;
	     ListNode(int x) { val = x; }
	  }
	 
	  // returns the head of the list
	public static class Solution {
		
		final static int SIZE = 10;
		PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(SIZE, new Comparator<ListNode>() {
			@Override
			public int compare(ListNode x, ListNode y) {
				return x.val - y.val;
			}
		});
		
	    public ListNode mergeKLists(ListNode[] lists) {
	    	
	    	for (int i = 0; i < lists.length; i++) {
	    		//System.out.println(lists[i].val);
	    		insertIntoHeap(lists[i]);
	    	}
	    	
	    	ListNode[] sorted = removeNodes();
	    	
	    	for (int i = 0; i < sorted.length; i++) {
	    		System.out.println(sorted[i].val);
	    	}
	    	
	    		// wants to return the first node of the list
	        return sorted[0];
	    }
	
	    public void insertIntoHeap(ListNode head) {
	    	ListNode iterate = head;
	    	while(iterate!=null) {
	    		minHeap.add(iterate);
	    		//System.out.println(iterate.val);
	    		iterate = iterate.next;
	    	}
	    }
	    
	    public ListNode[] removeNodes() {
	    	ListNode[] sortedList = new ListNode[minHeap.size()];
	    	
	    	int i = 0;
	    	while(!minHeap.isEmpty()) {
	    		sortedList[i] = minHeap.remove();
	    		i++;
	    	}
	    	
	    	return sortedList;
	    }
	    
	}
}
