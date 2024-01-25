import java.util.Scanner;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BFS {
    private int number_of_vertices;
    private int number_of_edges;
    private ArrayList<ArrayList<Integer>> adjList;

    public BFS(){
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
        for (int i = 1; i < adjList.size(); i++){
            System.out.print(i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public void ExeBFS(int start_vertice){
        boolean visited[] = new boolean[number_of_vertices + 1];
        Queue<Integer> q = new LinkedList<Integer>();

        q.add(start_vertice);
        visited[start_vertice] = true;

        System.out.println("Breadth first search: ");

        while (!q.isEmpty()) {
            Integer front = q.poll();
            System.out.print(front + " ");

            for (int ele : adjList.get(front)){
                if (visited[ele] == false){
                    q.add(ele);
                    visited[ele] = true;
                }
            }
        }

    }
}
