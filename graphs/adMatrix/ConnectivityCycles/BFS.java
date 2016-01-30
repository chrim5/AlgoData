package graphs.adMatrix.ConnectivityCycles;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Marc Christen on 27.01.2016.
 */
public class BFS {

    Queue<Integer> queue;
    boolean[][] adjMatrix; // the graph as an adjacency matrix
    boolean[] visited; // array for visited nodes
    int startNode;
    int numComponents;
    int edges;

    public BFS (boolean[][] Matrix){
        this.adjMatrix = Matrix;
        this.visited = new boolean[adjMatrix.length];
        this.startNode = 0;
        this.numComponents = 0;
        this.queue = new LinkedList<Integer>(); // A queue to process nodes

        // do the graphs.adMatrix.ConnectivityCycles.BFS from each node not already visited
        for (int i=0; i < adjMatrix.length; ++i)
            if (!visited[i])
            {
                ++numComponents;
                System.out.printf("Starting a BFS for component %d starting at node %d%n", numComponents,i);

                breadthFirst(i,visited);
            }

        System.out.println();
        // Output whether graph (adjMatrix) is connected or not
        if(numComponents > 1){
            System.out.printf("Finished with BFS - found %d components.%n", numComponents);
            System.out.println("Graph is not connected!");
        } else {
            System.out.printf("Finished with BFS - found %d components.%n", numComponents);
            System.out.println("Graph is connected!");
        }
        // Output whether graph (adjMatrix) is cyclic or acyclic
        System.out.println();
        // devide counted true statements with 2 to get edges
        edges = edges/2;
        if(edges > adjMatrix.length-1) {
            System.out.printf("Graph is cyclic! Edges: %d %n", edges);
        } else {
            System.out.printf("Graph is acyclic! Edges: %d %n", edges);
        }
    }

    public void breadthFirst(int startNode, boolean[] visited) {
        // start with only the start node in the queue and mark it as visited
        queue.offer(startNode);
        visited[startNode] = true;

        while (!queue.isEmpty()) {

            int head = queue.poll(); // get the head of the queue
            System.out.printf("At node %d in the BFS%n", head);

            // add any unseen nodes to the queue to process, then mark them as visited so they don't get re-added
            for (int i = 0; i < adjMatrix.length; ++i) {
                if ((adjMatrix[head][i]) && (!visited[i])) {
                    queue.offer(i);
                    visited[i] = true;

                    System.out.printf("Adding node %d to the queue in the BFS%n", i);
                }
                // count true statements in adjMatrix to detect cylces
                if(adjMatrix[head][i]){
                    edges++;
                }
            }
            System.out.printf("Done processing node %d%n", head);
        }
        System.out.printf("Finished with the BFS from start node %d%n", startNode);
    }
}
