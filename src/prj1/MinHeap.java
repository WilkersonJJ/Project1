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
    private int count;

    // The array representation of your min-heap (It is not required to use
    // this)
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
        nodes = new HeapNode[n];
        this.d = d;
        count = 0;
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
        // Append new node to the end of the array
        HeapNode newNode = new HeapNode(id, value);
        nodes[count++] = newNode;

        // Swap elements until the min-heap property is satisfied
        heapifyUp(count - 1);

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
        // Create return array
        int[] minArray = { nodes[0].getId(), nodes[0].getValue() };
        
        // Swap the move the last element to the first and decrement the size
        nodes[0] = nodes[count - 1];
        count--;
        
        // Swap elements until the min-heap property is satisfied
        heapifyDown(0);
        
        return minArray;
        
        
    }


    /**
     * This method takes an id and a new value newValue for the corresponding
     * node, and updates the data structure accordingly
     * 
     * @param id
     * @param newValue
     */
    public void decreaseKey(int id, int newValue) {
        
        // Find the correct node
        int i = 0;
        while (i < count) {
            if (nodes[i].getId() == id) {
                break;
            }
            i++;
        }
        
        // Update value and heapify
        nodes[i].setValue(newValue);
        heapifyUp(i);
    }


    /**
     * This method returns the array representation of heap
     * 
     * @return the array representation of heap
     */
    public int[] getHeap() {
        int[] nodeValues = new int[count];
        for (int i = 0; i < count; i++) {
            nodeValues[i] = nodes[i].getValue();
        }
        return nodeValues;
    }
    
    /**
     * Helper method that takes a modified heap and swaps elements down
     * until the min-heap property is satisfied
     */
    private void heapifyDown(int start) {
        int smallestChildIndex;
        int currentIndex = start;
        HeapNode temp = nodes[currentIndex];
        
        // Loop until we hit the bottom of the tree
        while (d * currentIndex + 1 < count - 1) {
            
            // Find the smallest child in the current node
            smallestChildIndex = d * currentIndex + 1;
            for (int i = 1; i < d; i++) {
                if(nodes[d * currentIndex + i + 1].getValue() < nodes[smallestChildIndex].getValue()) {
                    smallestChildIndex = d * currentIndex + i + 1;
                }
            }
            
            // If the smallest child of the current node is smaller than the current node, switch them
            if (nodes[smallestChildIndex].getValue() < temp.getValue()) {
                nodes[currentIndex] = nodes[smallestChildIndex];
            }
            // If not, then the heap property is satisfied and break
            else {
                break;
            }
            currentIndex = smallestChildIndex;
        }
        // Finish the swap
        nodes[currentIndex] = temp;   
    }
    
    /**
     * Helper method that takes a modified heap and swaps elements up
     * until the min-heap property is satisfied
     */
    private void heapifyUp(int start) {
        // While the new element is smaller than it's parent, swap it upwards until the heapify property is satisfied
        int currentIndex = start;
        int parentIndex = (currentIndex - 1) / d;
        HeapNode temp;
        while( nodes[currentIndex].getValue() < nodes[parentIndex].getValue() ) {
            temp = nodes[currentIndex];
            nodes[currentIndex] = nodes[parentIndex];
            nodes[parentIndex] = temp;
            currentIndex = parentIndex;
            parentIndex = (currentIndex - 1) / d;
        }
    }
    
    /**
     * Returns true if the heap is empty, false otherwise
     */
    public boolean isEmpty() {
        return count == 0;
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
