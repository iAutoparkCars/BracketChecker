package practice_problems;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class D_DFS {
	
	public static void main(String[] args){
		 HashMap<String, Node> graph = new HashMap<String, Node>();
		 
	}

	public static class Node{
        public String id;
        public LinkedList<Node> adjacencies = new LinkedList<Node>();
        public Node(String id){
          this.id = id;
        }
  	}
	
	public static class Graph{
	
		public HashMap<String, Node> graph = new HashMap<String, Node>();
    
		public Node getNode(String id){
        return graph.get(id);         
		}
    
	public void addEdge(String source, String destination){
    	
        if (graph.containsKey(source) && graph.containsKey(destination))
        {
          graph.get(source).adjacencies.add(graph.get(destination));
          graph.get(destination).adjacencies.add(graph.get(source));
        }
      
        
          // create nodes for each ID
        Node srcNode = new Node(source);
        Node destNode = new Node(destination);
        
          // add one node in the other's adjacency list
        srcNode.adjacencies.add(graph.get(source));  
        destNode.adjacencies.add(graph.get(destination));
      
          // now add both Nodes to the graph
        graph.put(source, srcNode);
        graph.put(destination, destNode);
        
		}
  
	}
}
  	
  	

	

