package prj1;

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
    int [] explored;
    MinHeap heap;
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
        for (int index = 0; index < n; index++)
        {
            //set all distances to be infinity
            heap.insert(index, Integer.MAX_VALUE);
            //set all to -1 for unexplored
            explored[index] = -1;
        }
        //set the distance of 0 to 0 to be 0
        heap.decreaseKey(0, 0);
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
        //TODO complete
        return distances;
    }

}
