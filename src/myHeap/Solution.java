package myHeap;

import java.io.*;
import java.util.*;

public class Solution
{
    

    public static void main(String[] args)
    {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        //String cin = "";
        String[] a = null;
        Scanner scan = new Scanner(System.in);
        while(scan.hasNext())
        {
            a = scan.nextLine().trim().split(" ");
            
            //for (String i : a)
                //{System.out.print(i + " " );}
            
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
    
        
    }

    //adding an element. Hard. Add to last then percolate
    //Delete element. Hard. Must find...delete, then rebalance heap
    //Print the minimum. Easy So this will be a min heap.
    
    
    public static void insert(int v)
    {
       System.out.println("1 " + v); 
    }
                           
    public static void delete(int v)
    {
        System.out.println("2 " + v); 
    }   
                           
    public static void printMin()
    {
        System.out.println("3 ");
    }
}