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

    public int findMin(int[] distance, boolean marked[]){
        int result = -1;
        int min_value = Integer.MAX_VALUE;

        for (int i = 0; i < number_of_vertices; i++){
            if (marked[i] == false && distance[i] < min_value) {
                min_value = distance[i];
                result = i;
            }
        }
        return result;
    }

    public void exeDijkstra(int start_vertice){
        boolean marked[] = new boolean[number_of_vertices];
        int distance[] = new int[number_of_vertices];

        for (int i = 0; i < distance.length; i++){
            if (i != start_vertice){
                distance[i] = Integer.MAX_VALUE;
            }
        }

        int min = start_vertice;
        for (int count = 0; count < number_of_vertices; count++){
            
            for (int i = 0; i < number_of_vertices; i++){
                if (adjMatrix[min][i] != 0 && marked[i] == false){
                    int cmp_distance = distance[min] + adjMatrix[min][i];
                    System.out.println("Cpm dis " + cmp_distance + " " + i);
                    if (distance[i] > cmp_distance){
                        distance[i] = cmp_distance;
                    } 
                }
            }
            marked[min] = true;

            min = findMin(distance, marked);
            System.out.println("Min " + min);
            for (int ele : distance) {
                System.out.print(ele + " ");
            }
            System.out.println();
            
            for (boolean ele : marked) {
                System.out.print(ele + " ");
            }
            System.out.println();

        }

        printShortestPath(distance);
    }

    public void printShortestPath(int[] distance){
        for(int i = 0; i < number_of_vertices; i++){
            System.out.println(i + "  " + distance[i]);
        }
    }
}