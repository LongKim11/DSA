import java.util.Scanner;
import java.util.ArrayList;

public class DFS {
    private int number_of_vertices;
    private int number_of_edges;
    private ArrayList<ArrayList<Integer>> adjList;

    public DFS (){
        adjList = new ArrayList<ArrayList<Integer>>();

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of vertices and edges:");
        number_of_vertices = sc.nextInt();
        number_of_edges = sc.nextInt();

        for (int i = 0; i <= number_of_vertices; i++){
            adjList.add(new ArrayList<Integer>());
        }

        System.out.println("Enter edges:");
        for (int i = 0; i < number_of_edges; i++){
            int src = sc.nextInt();
            int dest = sc.nextInt();
            
            adjList.get(src).add(dest);
            adjList.get(dest).add(src);
        }

        sc.close();
    }

    public void printGraph(){
        System.out.println("Adjacency List:");
        for (int i = 1; i <= number_of_vertices; i++){
            System.out.print(i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void ExeDFS(int start_vertice){
        boolean visited[] = new boolean[number_of_vertices + 1];
        DFSHelper(start_vertice, visited);
    }

    public void DFSHelper(int vertice, boolean visited[]){
        visited[vertice] = true;

        System.out.print(vertice + " ");

        for (Integer ele : adjList.get(vertice)){
            if (!visited[ele]){
                DFSHelper(ele, visited);
            }
        }
    }
}
