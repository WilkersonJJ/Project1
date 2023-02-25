package prj1;

import java.util.ArrayList;

/**
 * The implementation of Dijkstras shortest path algorithm by using a simple
 * linear search to find the unvisited node with the minimum distance estimate
 * 
 * @author Jasper Wilkeron
 * @author Jade Sherer
 * @version 1.1
 */
public class DijkstrasWithoutHeap {
    int [] distances;
    int [] prev;
    ArrayList<int[]> unexplored;

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
    public DijkstrasWithoutHeap(int n, int[][] edges) {
        // Set up stuffs
        distances = new int[edges.length];
        prev = new int[edges.length];
        unexplored = new ArrayList<int[]>();
        
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            prev[i] = -1;
            unexplored.add(edges[i]);
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
        while (unexplored.size() > 0) {
            
        }
        return null;
    }

}
