package prj1;
import java.util.List;
import java.util.ArrayList;
/**
 * 
 * The implementation of Dijkstras shortest path algorithm by using
 * min-heaps
 * 
 * @author Jasper Wilkerson
 * @author Jade Sherer
 */
public class DijkstrasWithHeap {
    int [] distances;
    int [] unexplored;
    MinHeap heap;
    ArrayList<List<int[]>> edges;
    /**
     * Constructor of the class
     * 
     * @param n:
     *            number of nodes of the graph
     * @param edges:
     *            the set of edges of the graph. Each row of 'edges' is in the
     *            form of [u, v, w], which means that there is an edge between u
     *            and v with weight w. So edges[i][0] and edges[i][1] are the
     *            end-points of the i-th edge and edges[i][2] is its weight
     */
    public DijkstrasWithHeap(int n, int[][] edges) {
        heap = new MinHeap(n, 2);
        unexplored = new int[n];
        distances = new int[n];
        this.edges = adjacencyList(edges, n);

        //initialize all the lists
        for (int index = 0; index < n; index++)
        {
            distances[index] = Integer.MAX_VALUE;
            //set all distances to be infinity
            heap.insert(index, Integer.MAX_VALUE);
            //set all to -1 for unexplored
            unexplored[index] = -1;
        }
    }
    /**
     * This method computes and returns the distances of all nodes of the graph
     * from the source node
     * 
     * @param source
     * 
     * @return an array containing the distances of the nodes of the graph from
     *         source. Element i of the returned array represents the distance
     *         of node i from the source
     */
    public int[] run(int source) {
        distances[source - 1] = 0; //distance from source to source is 0, stored one back
        heap.decreaseKey(source - 1, 0); //set the source distance to be 0

        while (!heap.isEmpty()) {
            int[] min = heap.extractMin();
            //if our min is the max value, then we have come to the end of the graph
            if (min[1] == Integer.MAX_VALUE)
            {
                break;
            }
            unexplored[min[0]] = 1;
            for (int i = 0; i < unexplored.length; i++)
            {
                //if the node is:
                //1. a neighbor of min
                //2. not explored
                //3. would result in a lower distance
                //then update its distance
                if ((unexplored[i] == -1) 
                && (getArrForVertex(edges.get(min[0]), i)[1] != -1)
                && (distances[min[0]] != Integer.MAX_VALUE)
                && (distances[min[0]] + getArrForVertex(edges.get(min[0]), i)[1] < distances[i]))
                {
                    int newValue = distances[min[0]] + getArrForVertex(edges.get(min[0]), i)[1];
                    distances[i] = newValue;
                    heap.decreaseKey(i, newValue);
                }
            }
        }
        //check that everyone has been explored, otherwise they are -1
        for(int i = 0; i < unexplored.length; i++)
        {
            if(unexplored[i] == -1)
            {
                distances[i] = -1;
            }
        }
        return distances;
    }
    /**
     * 
     * @param edges
     * @param n
     * @return
     */
    private ArrayList<List<int[]>> adjacencyList(int[][] edges, int n)
    {
        // Creates an adjacency list and populates it with empty sub-lists
        ArrayList<List<int[]>> adjList = new ArrayList<List<int[]>>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<int[]>());
        }
        //takes in both vertices, plop them in adjList
        for (int i = 0; i < edges.length; i++) {
            int one = edges[i][0];
            int two = edges[i][1];
            
            int[] arr1 = {two - 1, edges[i][2]};
            adjList.get(one - 1).add(arr1);
            
            int[] arr2 = {one - 1, edges[i][2]};
            adjList.get(two - 1).add(arr2);
        }
        return adjList;
    }
    private int[] getArrForVertex(List<int[]> list, int v)
    {
        for (int i = 0; i < list.size(); i++)
        {
            if (list.get(i)[0] == v)
            {
                return list.get(i);
            }
        }
        int[] nullArray = {-1, -1};
        return nullArray;
    }
}
