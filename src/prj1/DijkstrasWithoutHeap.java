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
    int [] unexplored;
    int exploredNodes;

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
        // Each element is the distance from the vertex to the source
        distances = new int[edges.length];
        
        // Each element is -1 for an unexplored vertex, or 1 for an explored vertex
        unexplored = new int[edges.length];
        
        // The number of nodes that are explored
        exploredNodes = 0;
        
        // Each distance starts at infinity and each node as unexplored
        for (int i = 0; i < n; i++) {
            distances[i] = Integer.MAX_VALUE;
            unexplored[i] = -1;
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
        distances[source] = 0;
        while (exploredNodes < unexplored.length) {
            
        }
        return null;
    }

}
