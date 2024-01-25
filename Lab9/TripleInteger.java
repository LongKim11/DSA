public class TripleInteger {
    private int src;
    private int dest;
    private int weight;

    public TripleInteger(int src, int dest, int weight){
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }
    
    public int getSrc(){
        return src;
    }

    public int getDest(){
        return dest;
    }
    
    public int getWeight(){
        return weight;
    }

    public String toString(){
        return src + " " + dest + " " + weight;
    }
}
