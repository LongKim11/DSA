import java.util.Scanner;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Exercise3 {
    private ArrayList<TripleInteger> edgeList;
    private ArrayList<Integer> vertices;

    public Exercise3(){
        try {
            File f = new File("Ex3.txt");
            Scanner sc = new Scanner(f);

            edgeList = new ArrayList<TripleInteger>();
            vertices = new ArrayList<Integer>();

            while(sc.hasNextLine()){
                String edge[] = sc.nextLine().split(" ");
                int weight = Integer.parseInt(edge[0]);
                int src = Integer.parseInt(edge[1]);
                int dest = Integer.parseInt(edge[2]);
                
                if (!vertices.contains(src)){
                    vertices.add(src);
                }

                if (!vertices.contains(dest)){
                    vertices.add(dest);
                }

                edgeList.add(new TripleInteger(src, dest, weight));
            }
            sc.close();
        } catch (IOException e){
            System.out.println("An error occured");
            e.printStackTrace();
        }
    }

    public void printEdgeList(){
        System.out.println("Src Dest Weight");
        for (TripleInteger ele : edgeList){
            System.out.println(ele);
        }
    }

    public int getNumberOfEdges(){
        return edgeList.size();
    }

    public int getNumberOfVertices(){
        return vertices.size();
    }

    public void getNeighbor(int v){
        ArrayList<Integer> neighbor = new ArrayList<Integer>();
        for (TripleInteger ele : edgeList){
            if (ele.getSrc() == v){
                neighbor.add(ele.getDest());
            }
            if (ele.getDest() == v){
                neighbor.add(ele.getSrc());
            }
        }
        System.out.print(v + ": ");
        for (Integer ele : neighbor){
            System.out.print(ele + " ");
        }
        System.out.println();
    }

    public boolean checkEdge(int src, int dest){
        for (TripleInteger ele : edgeList){
            if((ele.getSrc() == src && ele.getDest() == dest) || (ele.getSrc() == dest && ele.getDest() == src)){
                return true;
            }
        }
        return false;
    }
}
