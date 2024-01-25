public class AdjacencyMatrix {
    private int arr[][];
    private int number_of_vertices;

    public AdjacencyMatrix (int number_of_vertices){
        this.number_of_vertices = number_of_vertices;
        arr = new int[number_of_vertices][number_of_vertices];
    }

    public void setEdge(int src, int dest, int weight){
        arr[src][dest] = 1;
        arr[dest][src] = 1;
    }

    public boolean checkEdge(int src, int dest){
        return arr[src][dest] != 0;
    }

    public int getWeight (int src, int dest){
        if (checkEdge(src, dest) == false) {
            return -1;
        }
        return arr[src][dest];
    }

    public void printGraph(){
        for (int[] rows : arr) {
            for (int ele : rows){
                System.out.print(ele + " ");
            }
            System.out.println();
        }

    }

    public AdjacencyList convertToAL (){
        AdjacencyList adjList = new AdjacencyList(number_of_vertices);
        for (int i = 0; i < number_of_vertices; i++){
            for (int j = i; j < arr[i].length; j++){
                if (arr[i][j] != 0){
                    adjList.setEdge(i, j);
                }
            }
        }
        return adjList;
    }
}
