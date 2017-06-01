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
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            a = scan.nextLine().trim().split(" ");
            
           // for (String i : a)
             //   {System.out.print(i + " " );}
            
            switch(a[0])
            {
                case "1":
                    insert(Integer.valueOf(a[1]));
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
        for (Integer i : heap)
        System.out.print(i + " " );
        
    }

    //adding an element. Hard. Add to last then percolate
    //Delete element. Hard. Must find...delete, then rebalance heap
    //Print the minimum. Easy So this will be a min heap.
    
    
    public static void insert(int v)
    {
       //if heap is size 2, only placeholder & root, so don't check
       heap.add(v);
        
       //if the parent is larger than the child, percolate
       int currInd = heap.size()-1;
       if (heap.size() > 2 && parentVal(currInd) > heap.get(currInd))
       {
         //System.out.println(heap.size()-1);
         System.out.println("parent of " + v + " is " + parentVal(currInd) + 
                           " so I want to swap");
           
         percolate(currInd,parentIndex(currInd));  //child index, parent index
         //check here
       }

        //System.out.println("1 " + v); 
    }
    
    public static void percolate(int child, int parent)
    {
        if (heap.get(parent)==null)
            return;
        
        int temp = heap.get(child);
        heap.set(child,heap.get(parent));
        heap.set(parent,temp);
        
        //percolate the next level higher (new child, new parent)
        percolate(parent,parentIndex(parent));
    }
                           
    public static void delete(int v)
    {
        //System.out.println("2 " + v); 
    }   
                           
    public static void printMin()
    {
        //System.out.println("3 ");
    }
    
     public static int parentVal(int i)
    {
        return heap.get(parentIndex(i));
    }
    
    public static int l_childVal()
    {
        return heap.get(l_childIndex());
    }
     
    public static int r_childVal()
    {
        return heap.get(r_childIndex());
    }
    
    
    public static int parentIndex(int i)
    {
        int parentInd;
        //int childIndex = heap.size()-1; //after child added to heap
        //System.out.println(childIndex);
        
        parentInd =  (int) (i/2.0);
        return parentInd;
    }
    
    public static int l_childIndex()
    {
        int i = heap.size()-1;
        return 2*i;
    }
    
    public static int r_childIndex()
    {
        int i = heap.size()-1; //childIndex
        return (2*i)+1;
    }
}