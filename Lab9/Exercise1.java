import java.util.Scanner;
import java.util.ArrayList;
import java.io.File;
import java.io.IOException;

public class Exercise1 {
    private int number_of_vertices;
    private int adjMatrix[][];

    public Exercise1 (){
        try {
            File f = new File("Ex1.txt");
            Scanner sc = new Scanner(f);
            System.out.println("Enter number of vertices:");
            number_of_vertices = sc.nextInt();
    
            adjMatrix = new int[number_of_vertices + 1][number_of_vertices + 1];
    
            System.out.println("Enter the adjacency matrix:");
            
            for (int row = 1; row <= number_of_vertices; row++){
                for (int column = 1; column <= number_of_vertices; column++){
                    adjMatrix[row][column] = sc.nextInt();
                }
            }
            
            sc.close();
        } catch (IOException e){
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }

    public void printAdjMatrix(){
        System.out.println("Adjacency Matrix:");
        for (int i = 1; i <= number_of_vertices; i++){
            for (int j = 1; j <= number_of_vertices; j++){
                System.out.print(adjMatrix[i][j] + " ");
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
            for (int j = i; j <= number_of_vertices; j++){
                if (adjMatrix[i][j] == 1){
                    count++;
                }
            }
        }
        return count;
    }

    public void getNeighbor(int v){
        ArrayList<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= number_of_vertices; i++){
            if (adjMatrix[v][i] == 1){
                list.add(i);
            }
        }
        
        System.out.print(v + ": ");

        for (Integer ele : list){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public boolean checkEdge(int src, int dest){
        return adjMatrix[src][dest] == 1;
    }
}
