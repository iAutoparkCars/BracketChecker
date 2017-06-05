package myHeap;
import java.io.*;
import java.util.*;

public class Solution
{
    
    static ArrayList<Integer> heap = new ArrayList<Integer>();
    
    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //String cin = "";
        heap.add(null);
        String[] a = null;
        
        //testing delete function on heap
       /* SolutionTest test0 = new SolutionTest();
        heap = test0.getTestArray3();
        
        delete(-419);
        
        System.out.println("After delete");
        print();*/
        
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            a = scan.nextLine().trim().split(" ");
            
            switch(a[0])
            {
                case "1":
                    insert(heap.size(),Integer.valueOf(a[1]));
                    break;
                case "2":
                    delete(Integer.valueOf(a[1]));
                    break;
                case "3":
                    printMin();
                    break;
                default:
                    break;
            }
        }
        
        //print the heap here. the null is a  placeholder
        
        print();
        
    }

    
    //inserting at heap.size() is like inserting at last spot that doesn't exist yet  
    public static void insert(int index, int v)
    {
    	System.out.println("After deleting last element");
        print();
    	
       //if heap is size 2, only placeholder & root, so don't check
       if (index>heap.size()-1)
       {
           heap.add(-5);
           heap.set(index,v); 
       }
        else 
       {heap.set(index,v);}
        
       System.out.println("After inserting last element");
       print();


        
        //if the parent is larger than the current, swap
       if (heap.size() > 2 && parentIndex(index)>0 && parentVal(index) > heap.get(index))
       {
           percolateDown(index,parentIndex(index));  //child index, parent index
       }
        
       
        
        
       //if current is larger than its left child, swap
        
       //if (heap.size() > 2 && l_childIndex(index) < heap.size())
         //System.out.println("current " + heap.get(index) + " child " + l_childVal(index));
       
       
       if (heap.size() > 2 && l_childIndex(index) < heap.size() && (l_childVal(index) < heap.get(index)))
       {
    	   System.out.println("About to swap current and child, current is " + heap.get(index) + " and child " + l_childVal(index));
    	   percolateUp(index,l_childIndex(index),"left");  //left child index, parent index
    	   
       }
       
        
       System.out.println("child's value " + r_childVal(index) + " current is " +  heap.get(index));
       if (heap.size() > 3 && r_childIndex(index) < heap.size() && (r_childVal(index) < heap.get(index)))
       {
    	   System.out.println("asdf");
           percolateUp(index,r_childIndex(index),"right");  //right child index, parent index
       } 
        
        
    }
    
    public static void percolateDown(int curr, int parent)
    {
        if (heap.get(parent)==null || parentVal(curr) < heap.get(curr))
            return;
        
        
        //System.out.println("About to swap parent " + parentVal(curr) + " and current " + heap.get(curr));
        
        int temp = heap.get(curr);
        heap.set(curr,heap.get(parent));
        heap.set(parent,temp);
        
       //print();
        
        //percolate the next level higher (new child, new parent)
        percolateDown(parent,parentIndex(parent));
    }
    
    public static void percolateUp(int curr, int child, String which)
    {
    	
    	
        if (heap.get(child)==null || child >= heap.size() || curr >= heap.size() ||
           (l_childVal(curr) > heap.get(curr) && which.equals("left")) )
            return;
         
        
        //if (heap.size() > 2 && l_childIndex(curr) < heap.size())
        //System.out.println("trying to swap child " + l_childVal(curr) + " and current " + heap.get(curr));
        
        int temp = heap.get(child);
        heap.set(child,heap.get(curr));
        heap.set(curr,temp);
       
        //percolate the next level higher (new child, new parent)
        //System.out.println("current is " + heap.get(curr) + "; child is " + l_childVal(curr));
        
        if (l_childIndex(child) < heap.size() && l_childVal(child) < heap.get(child))
        {
        	print();
            percolateUp(child,l_childIndex(child),"left");
        	print();

        }
        
        if (r_childIndex(child) < heap.size() && heap.size() > 3)
        {
        	System.out.println("does this recurse right");
            percolateUp(child,r_childIndex(child),"right");
        }
    }
    
    public static void delete(int v)
    {
    	
    	
        Integer targInd = -1;
        int last_i = heap.size()-1;
        for (int i =1 ; i < heap.size(); i++)
        {
            if (heap.get(i).equals(v))
            {
                targInd = i;
            }
        }
        if(targInd.equals(-1))
            {System.out.println("Couldn't find value to delete"); return; } //value not found
        
        
        
        //If deleting last element, remove it and finish function
        if (targInd.equals(last_i))
        {
            heap.remove(last_i);
            return;
        }
        else 
        {
	        //swap(last element in list, element in list you want to delete)
        	
        	
        	
	        int valTmp = heap.get(last_i);
	        heap.remove(last_i);
	        insert(targInd,valTmp);
	        
        }
    }   
    
    public static void print()
    {
        for (Integer i : heap)
        System.out.print(i + " " );
        System.out.println("\n____________________________");
    }
    
    public static void printMin()
    {
        //System.out.println(heap.get(1));
    }
    
    public static int parentVal(int i)
    {
        return heap.get(parentIndex(i));
    }
    
    public static int l_childVal(int i)
    {
        return heap.get(l_childIndex(i));
    }
     
    public static int r_childVal(int i)
    {
        return heap.get(r_childIndex(i));
    }
    
    public static int parentIndex(int i)
    {
        int parentInd;
        //int childIndex = heap.size()-1; //after child added to heap
        //System.out.println(childIndex);
        
        parentInd =  (int) (i/2.0);
        return parentInd;
    }
    
    public static int l_childIndex(int i)
    {
        return 2*i;
    }
    
    public static int r_childIndex(int i)
    {
        return (2*i)+1;
    }
    
}