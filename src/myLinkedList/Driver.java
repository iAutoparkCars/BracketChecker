package myLinkedList;



public class Driver
{

	public static void main(String[] args)
	{
		//create a test instance to test add, print, and insert
		MyLinkedListTest noCycle = new MyLinkedListTest();
		noCycle.CreateAcyclicLL();
		noCycle.PrintInsertTest();
		noCycle.hasCycleTest();
	
		System.out.println("_________________________________\n");
			
		MyLinkedListTest withCycle = new MyLinkedListTest();
		withCycle.CreateCyclicLL();	
		withCycle.hasCycleTest();
	}
	
}
