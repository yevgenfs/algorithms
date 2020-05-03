import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class A {

	
	

static class Node{
  public final String name;
  // cost so far to reach destination
  public double g_cost = Integer.MAX_VALUE;
  // total estimated cost of path through current node
  public double f_cost = Integer.MAX_VALUE;
  // estimated cost from this node to destination
  public final double h_cost;
  public List<Edge> adjacency = new ArrayList<>();
  public Node parent;
  public Node(String name, double h_cost){
    this.name = name;
    this.h_cost = h_cost;
  }
  public void addNeighbour(Node neighbour, int cost) {
    Edge edge = new Edge(neighbour, cost);
    adjacency.add(edge);
  }
  public String toString(){
    return name;
  }
}
	
	static class Edge{
		  public final double cost;
		  public final Node target;
		  public Edge(Node target, double cost){
		    this.target = target;
		    this.cost = cost;
		  }
		}
	
	public static void AStarSearch(Node source, Node destination) {
		  source.g_cost = 0;
		  // total estimated cost of path through current node will be in this case equal to h_cost
		  source.f_cost = source.h_cost;
		  PriorityQueue<Node> frontier = new PriorityQueue<>(new Comparator<Node>() {
		    @Override
		    public int compare(Node o1, Node o2) {
		      return Double.compare(o1.f_cost, o2.f_cost);
		    }
		  });
		  frontier.add(source);
		  int numberOfSteps = 0;
		  while (!frontier.isEmpty()) {
		    numberOfSteps++;
		    // get the node with minimum distance
		    Node current = frontier.poll();
		    System.out.println("Current node: " + current.name);
		    // we have found the destination
		    if (current.name.equals(destination.name)) {
		      break;
		    }
		    // check all the neighbours
		    for (Edge edge: current.adjacency) {
		      Node neigh = edge.target;
		      double cost = edge.cost;
		      double new_g_cost = current.g_cost + cost;
		      double new_f_cost = neigh.h_cost + new_g_cost;
		      if (new_f_cost < neigh.f_cost) {
		        neigh.parent = current;
		        neigh.g_cost = new_g_cost;
		        neigh.f_cost = new_f_cost;
		        if (frontier.contains(neigh)) {
		          frontier.remove(neigh);
		        }
		        frontier.add(neigh);
		      }
		    }
		  }
		  System.out.println("Number of steps: " + numberOfSteps);
		}
	
	public static void main(String[] args) {
		
		Node Arad = new Node("Arad",366);
		Node Zerind = new Node("Zerind",374);
		Node Oradea = new Node("Oradea",380);
		Node Timisoara = new Node("Timisoara",329);
		Node Sibiu = new Node("Sibiu",253);
		Node RimnicuVilcea = new Node("Rimnicu Vilcea",193);
		Node Lugoj = new Node("Lugoj",244);
		Node Fagaras = new Node("Fagaras",176);
		Node Mehadia = new Node("Mehadia",241);
		Node Pitesti = new Node("Pitesti",100);
		Node Craiova = new Node("Craiova",160);
		Node Drobeta = new Node("Drobeta",242);
		Node Bucharest = new Node("Bucharest",0);
		Arad.addNeighbour(Zerind, 75);
		Arad.addNeighbour(Sibiu, 140);
		Arad.addNeighbour(Timisoara, 118);
		Zerind.addNeighbour(Oradea, 71);
		Oradea.addNeighbour(Sibiu, 151);
		Sibiu.addNeighbour(Fagaras, 99);
		Sibiu.addNeighbour(RimnicuVilcea, 97);
		Fagaras.addNeighbour(Bucharest, 211);
		RimnicuVilcea.addNeighbour(Pitesti, 97);
		RimnicuVilcea.addNeighbour(Craiova, 146);
		Pitesti.addNeighbour(Bucharest, 101);
		Craiova.addNeighbour(Pitesti, 138);
		Timisoara.addNeighbour(Lugoj, 111);
		Lugoj.addNeighbour(Mehadia, 70);
		Mehadia.addNeighbour(Drobeta, 75);
		Drobeta.addNeighbour(Craiova, 75);
		AStarSearch(Arad,Bucharest);
		
	}

}
