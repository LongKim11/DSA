import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Exercise2 {
    private int number_of_vertices;
    private ArrayList<ArrayList<Integer>> adjList;

    public Exercise2 (){
        try {
            File f = new File("Ex2.txt");
            Scanner sc = new Scanner (f);
            adjList = new ArrayList<ArrayList<Integer>>();

            number_of_vertices = sc.nextInt();

            sc.nextLine();

            for (int i = 0; i <= number_of_vertices; i++){
                adjList.add(new ArrayList<Integer>());
            }

            while(sc.hasNextLine()){
                String neighbor[] = sc.nextLine().split(" ");
                
                for (int i = 1; i < neighbor.length; i++){
                    adjList.get(Integer.parseInt(neighbor[0])).add(Integer.parseInt(neighbor[i]));
                }
            }
        
            sc.close();
        } catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void printAdjList(){
        System.out.println("Adjacency List:");
        for (int i = 1; i <= number_of_vertices; i++){
            System.out.print(i + ": ");
            for (int j = 0; j < adjList.get(i).size(); j++){
                System.out.print(adjList.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    public int getNumberOfVertices(){
        return number_of_vertices;
    }

    public int getNumberOfEdges(){
        int count = 0;
        for (int i = 1; i <= number_of_vertices; i++){
            for (int ele : adjList.get(i)){
                if (i > ele){
                    count++;
                }
            }
        }
        return count;
    }

    public void getNeighbor(int v){
        System.out.print(v + ": ");
        for (int ele : adjList.get(v)){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public boolean checkEdge(int src, int dest){
        for (int ele : adjList.get(src)){
            if (ele == dest){
                return true;
            }
        }
        return false;
    }
}
