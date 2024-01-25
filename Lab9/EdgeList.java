import java.util.ArrayList;

class TripleInteger {
    private int src;
    private int dest;
    private int weight;

    public TripleInteger(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    public String toString(){
        return src + "    " + dest + "    " + weight;
    }
}
public class EdgeList {
    private ArrayList<TripleInteger> list;
    
    public EdgeList(){
        list = new ArrayList<TripleInteger>();
    }

    public void setEdge(int src, int dest, int weight){
        list.add(new TripleInteger(src, dest, weight));
    }

    public void printGraph(){
        System.out.println("Src Dest Weight");
        for (TripleInteger ele : list){
            System.out.println(ele);
        }
    }
}
