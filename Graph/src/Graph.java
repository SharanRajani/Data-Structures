import java.util.*;

class node {
	int vertex;
	int weight;

	node(int vertex, int weight) {
		this.vertex = vertex;
		this.weight = weight;
	}
}

class UndirectedGraph {

	LinkedList<node>[] aList;
	int noOfVertices;

	UndirectedGraph() {
		aList = null;
		noOfVertices = 0;
	}

	static Scanner scan = new Scanner(System.in);

	void create() {
		/*
		 * for (int i = 0; i < noOfVertices; i++) {
		 * System.out.println("Enter the edges connected to vertex " + i + ":"); int
		 * count = scan.nextInt(); for (int j = 0; j < count; j++) {
		 * System.out.println("Enter the 2nd vertex of the edge starting from " + i +
		 * ":"); int v = scan.nextInt();
		 * System.out.println("Enter the weight of the edge:"); int w = scan.nextInt();
		 * node nev = new node(v, w); aList[i].add(nev); } }
		 */
		System.out.println("Enter the number of vertices:");
		noOfVertices = scan.nextInt();
		aList = new LinkedList[noOfVertices];
		for (int i = 0; i < noOfVertices; i++) {
			aList[i] = new LinkedList<node>();
		}
		System.out.println("Enter the number of edges(Considering Undirected Graph):");
		int noOfEdges = scan.nextInt();
		for (int i = 0; i < noOfEdges; i++) {
			System.out.println("Enter vertex 1,vertex 2 and weight:");
			int u = scan.nextInt();
			int v = scan.nextInt();
			int w = scan.nextInt();
			node nev1 = new node(v, w);
			aList[u].add(nev1);
			node nev2 = new node(u, w);
			aList[v].add(nev2);
		}
	}

	void display() {
		for (int i = 0; i < aList.length; i++) {
			System.out.print(i + ":");
			for (int j = 0; j < aList[i].size(); j++) {
				node temp = aList[i].get(j);
				System.out.print("\t(" + temp.vertex + "," + temp.weight + ")");
			}
			System.out.println();
		}
	}

	void DFS(int begin) {
		boolean[] visited = new boolean[noOfVertices];
		DFSUtil(aList, begin, visited);
	}

	static void DFSUtil(LinkedList<node>[] al, int v, boolean[] visited) {
		System.out.print("\t" + v);
		visited[v] = true;
		for (int i = 0; i < al[v].size(); i++) {
			node nev = al[v].get(i);
			if (!visited[nev.vertex]) {
				DFSUtil(al, nev.vertex, visited);
			}
		}
	}

	void BFS(int begin) {
		LinkedList<Integer> queue = new LinkedList<Integer>();
		queue.add(begin);
		boolean[] visited = new boolean[noOfVertices];
		while (!queue.isEmpty()) {
			int v = queue.poll();
			if (!visited[v])
				System.out.print("\t" + v);
			visited[v] = true;
			for (int i = 0; i < aList[v].size(); i++) {
				node nev = aList[v].get(i);
				if (!visited[nev.vertex]) {
					queue.add(nev.vertex);
				}
			}
		}
	}
}

public class Graph {

	static Scanner scan = new Scanner(System.in);

	public static void main(String[] args) {
		UndirectedGraph g1 = new UndirectedGraph();
		g1.create();
		g1.display();
		System.out.println("\nEnter the vertex from where the DFS is to be started:");
		int begin = scan.nextInt();
		System.out.print("The DFS traversal is as follows:");
		g1.DFS(begin);
		System.out.println("\n\nEnter the vertex from where the BFS is to be started:");
		begin = scan.nextInt();
		System.out.print("The BFS traversal is as follows:");
		g1.BFS(begin);
	}
}
