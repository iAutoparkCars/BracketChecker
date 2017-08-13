package practice_problems;

import java.util.HashMap;

  /*
   * Print the max number of points that lie on the same line
   * 
   */
public class G_MaxPoints {
	
	public static void main(String[] args){
		
		Solution solution = new Solution();
			
			// 5 points on line y = 3
		Point[] test1 = {new Point(2,4), new Point(4,3), new Point(4,3), 
				         new Point(4,3), new Point(1,3), new Point(4,3)};
		
			// 4 points on line x = 2
		Point[] test2 = {new Point(2,4), new Point(2,5), new Point(2,3), 
		         new Point(4,3), new Point(2,4), new Point(3,3)};
		
		System.out.println(solution.maxPoints(test2));
	}
	
	/**
	 * Definition for a point.
	 * class Point {
	 *     int x;
	 *     int y;
	 *     Point() { x = 0; y = 0; }
	 *     Point(int a, int b) { x = a; y = b; }
	 * }
	 */
	
	
	public static class Solution {
		
		HashMap<Integer, Integer> linesX = new HashMap<Integer, Integer>();
    	HashMap<Integer, Integer> linesY = new HashMap<Integer, Integer>();
    	
	    public int maxPoints(Point[] points) {
	    	/*
	    	 *  Iterate through the x,y coordinates, hashing each with its respective frequency (value)
	    	 *  
	    	 *  Loop through both hashmaps and see which has highest frequency
	    	 *   	--this will be the line with the most number of points
	    	 */
	    	
	    	
	    	for (int i = 0; i < points.length; i++) {
	    		countFreqX(points[i].x);
	    		countFreqY(points[i].y);
	    	}
	    	
	    	printMap(linesX);
	    	printMap(linesY);
	    	
	    	return getHighestFreq();
	    }
	    
	    	// increment the value by 1
	    public void countFreqX(int xCoord) {
	    	if (linesX.containsKey(xCoord)) {
	    		
	    		int currFreq = linesX.get(xCoord);
	    		currFreq++;
	    		linesX.put(xCoord, currFreq);
	    		
	    	}
	    	
	    	// else init freq to 0
	    	else {
	    		linesX.put(xCoord, 1);
	    	}
	    }
	    
	    public void countFreqY(int yCoord) {
	    	if (linesY.containsKey(yCoord)) {
	    		
	    		int currFreq = linesY.get(yCoord);
	    		currFreq++;
	    		linesY.put(yCoord, currFreq);
	    		
	    	}
	    	
	    	// else init freq to 0
	    	else {
	    		linesY.put(yCoord, 1);
	    	}

	    }
	
	    public int getHighestFreq() {
	    	int mostCommon = 0;
	    	
	    	int maxX = -1;
	    	for (int i : linesX.keySet()) {
	    		if (linesX.get(i) > maxX) {
	    			maxX = linesX.get(i);
	    		}
	    	}
	    	
	    	int maxY = -1;
	    	for (int i : linesY.keySet()) {
	    		if (linesY.get(i) > maxY) {
	    			maxY = linesY.get(i);
	    		}
	    	}
	    	
	    	if (maxX > maxY) {
	    		mostCommon = maxX;
	    	}
	    	else {
	    		mostCommon = maxY;
	    	}
	    	
	    	return mostCommon;
	    }
	    
	    public void printMap(HashMap map) {
	    	for (Object key : map.keySet()) {
	    		System.out.print("{"+key+": "+map.get(key)+"} ");
	    	}
	    	System.out.println("");
	    }
	}
	
	public static class Point{
		public int x;
		public int y;
		public Point(){
			x = y = 0;
		}
		
		public Point(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
	
	
	
}
