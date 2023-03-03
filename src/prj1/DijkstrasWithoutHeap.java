package prj1;
import java.util.ArrayList;
import java.util.List;

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
    public DijkstrasWithoutHeap(int n, int[][] edges) {
        // Each element is the distance from the vertex to the source, distances is the output array
        distances = new int[n];

        //copy over the edges so we can use them in our run method
        this.edges = adjacencyList(edges, n);

        // Each element is -1 for an unexplored vertex, or 1 for an explored vertex
        unexplored = new int[n];

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
        distances[source - 1] = 0; //distance from source to source is 0, stored one back
        for (int count = 0; count < unexplored.length; count++) {
            
            //find the node with the shortest distance from source
            int min = Integer.MAX_VALUE;
            int closestNode = -1;
            //loop through vertices and get the one with the lowest distance
            for (int vertex = 0; vertex < unexplored.length; vertex++)
            {
                //if unexplored and the distance is lower than min, grab those values
                if(unexplored[vertex] == -1 && distances[vertex] <= min)
                {
                    min = distances[vertex];
                    closestNode = vertex;
                }
            }
            //mark that node as explored
            unexplored[closestNode] = 1;

            //iterate through the rest of the vertices and update their distance values..
            //..to be distanceFromClosest + closestDistanceFromSource
            for (int vertex = 0; vertex < unexplored.length; vertex++)
            {
                //update the distances to each vertex only if
                //vertex is unexplored, there is a edge between those nodes
                //if we actually found a distance for closest node
                //and if the distance is smaller than the current value (we need to find the shortest path ofc)
                if((unexplored[vertex] == -1) 
                    && (getArrForVertex(edges.get(closestNode), vertex)[1] != -1)
                    && (distances[closestNode] != Integer.MAX_VALUE)
                    && (distances[closestNode] + getArrForVertex(edges.get(closestNode), vertex)[1] < distances[vertex]))
                {
                    //now we update the distance in the array
                    distances[vertex] = distances[closestNode] + getArrForVertex(edges.get(closestNode), vertex)[1];
                }
            }
        }
        //check that everyone has been explored, otherwise they are -1
        for(int i = 0; i < unexplored.length; i++)
        {
            if(unexplored[i] == -1 || distances[i] == Integer.MAX_VALUE)
            {
                distances[i] = -1;
            }
        }
        return distances;
    }
    /**
     * private helper method to change the list of edges to an adjacency list
     * @return the adjacency list
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