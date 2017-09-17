package practice_problems;

import java.awt.List;
import java.util.ArrayList;

public class J_MedianOfArrays {

	public static void main (String[] args){
		Solution solution = new Solution();
	}
	
	public static class Solution {
	    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

	    	/*
	    	 * O(M+N)
	    	 * Do I merge sort into a 3rd array, and find the median of that 3rd array.
	    	 * The problem is that the whole array is sorted. 
	    	 * How to find the median of the array without sorting it?
	    	*/
	    	
	    	/*
	    	 * O(log(M+N))
	    	 * 
	    	 * Perhaps using two heaps to keep track of the median?
	    	*/
	    	
	    	int[] combined = {1, 2, 3, 4};
	    	Double median = getMedian(combined);
	    	
	    	
	    	// 1 2 3 4 5 6 //4/2 = 2 average(4/2 and 4/2 -1) 6/2 -> 3 2
	    	return 0.0;
	    }
	    
	    static double getMedian(int[] combined){
	    	
	    	double median = 0.0;
	    	
	    	int size = combined.length;
	    		// array's size is odd
	    	if (size % 2 != 2){
	    		median = combined[size/2];
	    	} 
	    		// size is even
	    	else {
	    		double medianLeft = combined[size/2];
	    		double medianRight = combined[size/2 -1];
	    		median = (medianLeft + medianRight)/2.0;
	    	}
	    	
	    	return median;
	    }
	
	
	}	// end my Solution 
	
}
