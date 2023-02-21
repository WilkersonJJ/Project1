package prj1;

/**
 * In this class, we implement the d-ary min-heap data structure
 * 
 * @author Jasper Wilkerson
 * @author Jade Sherer
 *
 */
public class MinHeap {
    // The parameter d in the d-ary min-heap
    private int d;

    // The array representation of your min-heap (It is not required to use this)
    private HeapNode[] nodes;

    /**
     * Constructor
     * 
     * @param n:
     *            maximum number of elements in the min-heap at each time
     * @param d:
     *            parameter d in the d-ary min-heap
     */
    public MinHeap(int n, int d) {
        // TODO complete
        nodes = new HeapNode[n];
        this.d = d;
    }


    /**
     * This method inserts a new element with "id" and "value" into the min-heap
     * 
     * min heap: min priority item is stored at 0
     * the top of the tree is stored at 0, 1-d are its children
     * Thus, the parent of the item at position i
     * is the item at position (i − 1)/d and its children are the 
     * items at positions di + 1 through di + d
     * 
     * @param id
     * @param value
     */
    public void insert(int id, int value) {
        // TODO complete
    }


    /**
     * This method extracts the min value of the heap
     * 
     * @return an array consisting of two integer elements: id of the minimum
     *         element and the value of the minimum element
     * 
     *         So for example, if the minimum element has id = 5 and value = 1,
     *         you should return the array [5, 1]
     */
    public int[] extractMin() {
        // TODO complete
        return null;
    }


    /**
     * This method takes an id and a new value newValue for the corresponding
     * node, and updates the data structure accordingly
     * 
     * @param id
     * @param newValue
     */
    public void decreaseKey(int id, int newValue) {
        // TODO complete: find node with id and then update new value

    }


    /**
     * This method returns the array representation of heap
     * 
     * @return the array representation of heap
     */
    public int[] getHeap() {
        // TODO complete
        return null;
    }


    /**
     * the toString method that returns a string with the values of the heap in
     * the array representation.
     * This method can help you find the issues of your code when you want to
     * debug.
     * 
     * @return string form of the array representation of heap
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.nodes.length; i++) {
            if (nodes[i] != null) {
                sb.append(nodes[i].getValue());
                sb.append(' ');
            }
        }
        return sb.toString();
    }

}
