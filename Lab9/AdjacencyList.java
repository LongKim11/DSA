import java.util.LinkedList;
import java.util.ArrayList;

public class AdjacencyList {
    private ArrayList<LinkedList<Integer>> list;

    public AdjacencyList(int number_of_vertices){
        list = new ArrayList<LinkedList<Integer>>();
        for (int i = 0; i < number_of_vertices; i++){
            list.add(new LinkedList<Integer>());
        }
    }

    public void setEdge(int src, int dest){
        // LinkedList<Integer> srcList = list.get(src);
        // srcList.add(dest);

        list.get(src).add(dest);
        list.get(dest).add(src);
    }

    public void printGraph(){
        for (int i = 0; i < list.size(); i++){
            System.out.print(i + ": ");
            for (Integer ele : list.get(i)){
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
