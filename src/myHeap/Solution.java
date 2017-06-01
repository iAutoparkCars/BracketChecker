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
        for (Integer i : heap)
        System.out.print(i + " " );
        
    }

    //adding an element. Hard. Add to last then percolate
    //Delete element. Hard. Must find...delete, then rebalance heap
    //Print the minimum. Easy So this will be a min heap.
    
    //inserting at heap.size() is like inserting at last spot that doesn't exist yet  
    public static void insert(int index, int v)
    {
       //if heap is size 2, only placeholder & root, so don't check
       if (index>heap.size()-1)
       {
           heap.add(-5);
           heap.set(index,v); 
       }
        else 
        {heap.set(index,v);}
        
        //if the parent is larger than the current, percolate
       if (heap.size() > 2 && parentIndex(index)>2 && parentVal(index) > heap.get(index))
       {
           percolateDown(index,parentIndex(index));  //child index, parent index
       }
        
        //if child is smaller than current, percolate
       
       
      if (heap.size() > 2 && l_childIndex(index) < heap.size() && (l_childVal(index) < heap.get(index)))
       {
         percolateUp(index,l_childIndex(index),"left");  //left child index, parent index
       }
        
        if (heap.size() > 3 && r_childIndex(index) < heap.size() && (r_childVal(index) < heap.get(index)))
       {
           percolateUp(index,l_childIndex(index),"right");  //right child index, parent index
       } 
        
      
        
        
        
        
        //System.out.println("1 " + v); 
    }
    
    public static void percolateDown(int curr, int parent)
    {
        if (heap.get(parent)==null)
            return;
        
        int temp = heap.get(curr);
        heap.set(curr,heap.get(parent));
        heap.set(parent,temp);
        
        //percolate the next level higher (new child, new parent)
        percolateDown(parent,parentIndex(parent));
    }
    
    public static void percolateUp(int curr, int child, String which)
    {
        if (heap.get(child)==null || child >= heap.size() || curr >= heap.size())
            return;
        
        int temp = heap.get(child);
        heap.set(child,heap.get(curr));
        heap.set(curr,temp);
       
        
        //percolate the next level higher (new child, new parent)
        if (which.equals("left") && l_childIndex(child) < heap.size())
        {
            percolateUp(child,l_childIndex(child),"left");
        }
        else if (which.equals("right") && r_childIndex(child) < heap.size())
        {
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
            {return; } //value not found
        
        if (targInd.equals(last_i))
        {
            heap.remove(last_i);
            return;
        }
        
        //placing last element into element you want to delete
        int valTmp = heap.get(last_i);
        
       //System.out.println("delete " + v + " found at i=" + targInd + " by replacing it with value " +valTmp);
        
        heap.remove(last_i);
        
        //for (Integer i : heap)
        //System.out.print(i + " " );
        
        
        insert(targInd,valTmp);
    }   
                           
    public static void printMin()
    {
        //System.out.println("3 ");
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