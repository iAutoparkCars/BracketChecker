package practice_problems;
import java.io.*;
import java.util.*;

/*
 * To execute Java, please define "static void main" on a class
 * named Solution.
 *
 * If you need more classes, simply define them inline.
 */

class Solution {
  public static void main(String[] args) {
   
	  String str = "hi";
	  
   /*
        for (each employee in the employee list)
          generate a Node in the graph
          
        for (each 'connection' in the list)
          generate an Edge in the graph
          
        for (each Node in the graph)
          print adjacency list
          
   */
    
     String[] employeesInput = {
      "1,Richard,Engineering",
      "2,Erlich,HR",
      "3,Monica,Business",
      "4,Dinesh,Engineering",
      "6,Carla,Engineering"};
    
    String[] friendshipsInput = {
      "1,2",
      "1,3",
      "2,4"};
    
    printAdjacencyList(employeesInput, friendshipsInput);
    
    
  

  }
  
  public static void printAdjacencyList(String[] empInput,
                                        String[] friendInput)
  {
      Graph network = new Graph(); 
        
        // parse array to get int[] ids
      int[] ids = parseId(empInput);
  
        // add employee to network
      for (int i = 0; i < ids.length; i++){
        network.addEmployee(ids[i]);
      }
    
    
          // parse array to get connections
      int[] connections = parseConnections(friendInput);
      
          // add edges based on int pairs
      for (int i = 0; i < connections.length/2; i++){
        
        int person = connections[2*i+0];
        int friend = connections[2*i+1];
        
        network.addConnection(person, friend);         
      }
    
          // print adjacency list of every Node in the network
      for (int personId : network.graph.keySet())
      {
            Node person = network.graph.get(personId);
            System.out.println(person + ": " + person.printAdjacency());
      }
      
    
      
      
    
      
      
    
      
    
      
    
      
  }
      
  

  
  public static class Node{
      private int id;
      public LinkedList<Node> adjacency = new LinkedList<Node>();  

      public Node(int id){
        this.id = id; }
    
      public String printAdjacency(){
        String result = "";
        
        for (Node friend : adjacency)
        {
            result = result + " " + friend;
        }
        return result;
      }
    
      @Override
      public String toString(){
        return String.valueOf(id);
      }
    
  }
  
  
  public static class Graph{
      public HashMap<Integer, Node> graph = new HashMap<Integer, Node>();


        // create bi-directional connection
      public void addConnection(int personId, int friendId){
        //System.out.println(person + " " + friend);
        
        Node person = graph.get(personId);
        Node friend = graph.get(friendId);
        
          // add each other
        person.adjacency.add(friend);
        friend.adjacency.add(person);
        
      }  

      public void addEmployee(int employeeId){

        Node employee = new Node(employeeId);
        graph.put(employeeId, employee); 
      }

  }
   
  
  public static int[] parseId(String[] employees){
      
    int[] ids = new int[employees.length];
    int idIndex = 0;
    
    for (int i = 0; i < employees.length; i++){
        String[] employeeDetail = employees[i].split(",");
        ids[idIndex] = Integer.parseInt(employeeDetail[0]);
        idIndex++;
    }
    
    return ids;
  }
  
  public static int[] parseConnections(String[] friendInput){
      
      int[] connections = new int[friendInput.length*2]; 
      
      int connIndex = 0;
      for (int i = 0; i < friendInput.length; i++){
          String[] temp = friendInput[i].split(",");
          connections[connIndex] = Integer.parseInt(temp[0]);
          connIndex++;
          connections[connIndex] = Integer.parseInt(temp[1]);
          connIndex++;
      }
      return connections;
  }
  
  
}
