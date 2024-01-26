import java.io.IOException;
import java.util.Scanner;
import java.io.File;

public class Dijkstra {
    private int number_of_vertices;
    private int number_of_edges;
    private int adjMatrix[][];

    public Dijkstra(){
        try {
            File f = new File("Graph.txt");
            Scanner sc = new Scanner(f);

            number_of_vertices = sc.nextInt();
            number_of_edges = sc.nextInt();

            adjMatrix = new int[number_of_vertices][number_of_vertices];

            for (int i = 0; i < number_of_vertices; i++){
                for (int j = 0; j < number_of_vertices; j++){
                    adjMatrix[i][j] = sc.nextInt();
                }
            }

            sc.close();
        } catch(IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void printAdjMatrix(){
        for (int[] rows : adjMatrix){
            for (int ele : rows){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}