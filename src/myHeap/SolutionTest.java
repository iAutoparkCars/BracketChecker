package myHeap;

import java.util.ArrayList;

public class SolutionTest
{
	public static ArrayList heapTest;
	
	SolutionTest(){}
	
	public ArrayList<Integer> getTestArray()
	{
		heapTest = new ArrayList<Integer>();
		
		heapTest.add(null);
		heapTest.add(255);
		heapTest.add(286);
		heapTest.add(274);
		heapTest.add(494);
		return heapTest;
	}
	
	public ArrayList<Integer> getTestArray2()
	{
		heapTest = new ArrayList<Integer>();
		
		heapTest.add(null);
		heapTest.add(-737);
		heapTest.add(-419);
		heapTest.add(258);
		heapTest.add(63);
		heapTest.add(777);
		return heapTest;
	}
	
	public ArrayList<Integer> getTestArray3()
	{
		heapTest = new ArrayList<Integer>();
		
		heapTest.add(null);
		heapTest.add(-419);
		heapTest.add(52);
		heapTest.add(777);
		heapTest.add(258);
		heapTest.add(170);
		heapTest.add(841);
		return heapTest;
	}
	
	public String getTestInput()
	{
		StringBuilder str = new StringBuilder();
		str.append("2 255");
		
		return str.toString();
	}
	
	/* produces wrong tree
    1 -419
	1 950
	1 63
	1 841
	1 170
	1 835
	2 835
	2 950
	1 258
	1 -734
	1 52
	1 777
	2 -734
	2 -419*/
	
	/*1 -419
	1 63
	1 258
	1 -734
	1 52
	1 777
	2 -734
	2 -419*/
}
