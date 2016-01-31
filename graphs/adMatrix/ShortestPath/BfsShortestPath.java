package graphs.adMatrix.ShortestPath;

import java.util.*;

/**
 * Created by Marc Christen on 27.01.2016.
 * This program finds the shortest path
 * between two given vertices in an unweighted graph.
 * The graph is represented as an adjacency matrix (2d array):
 * If A[i]=1 & A[j]=1 => true (edge between two vertices)
 */
public class BfsShortestPath {

    Queue<Integer> queue;
    boolean[][] adjMatrix; // the graph as an adjacency matrix
    boolean[] visited; // array for visited nodes
    int startVertex;
    int endVertex;
    int[] connectedTo;
    List<Integer> path;
    Queue<Integer> parentsQueue;


    public BfsShortestPath (boolean[][] Matrix, int startVertex, int endVertex){
        this.adjMatrix = Matrix;
        this.visited = new boolean[adjMatrix.length];
        this.startVertex = startVertex;
        this.endVertex = endVertex;
        this.queue = new LinkedList<>(); // A queue to process nodes for BFS
        this.path = new ArrayList<>(); // path as a list of nodes
        this.connectedTo = new int[adjMatrix.length];
        this.parentsQueue = new ArrayDeque<>();

        // do the BFS from each node not already visited
        for (int i=0; i < adjMatrix.length; ++i) {
            if (!visited[i]) {
                breadthFirst(startVertex, visited);
            }
        }
        System.out.println();
        // print the shortest path between two given vertices
        printShortestPath();
    }

    public void breadthFirst(int startVertex, boolean[] visited) {
        // start with only the start node in the queue and mark it as visited
        queue.offer(startVertex);
        visited[startVertex] = true;

        while (!queue.isEmpty()) {
            // get the head of the queue (and remove it from the queue)
            int head = queue.poll();
            System.out.printf("At node %d in the BFS%n", head);

            // add any unseen nodes to the queue to process,
            // then mark them as visited so they don't get re-added
            for (int i = 0; i < adjMatrix.length; ++i) {
                if ((adjMatrix[head][i]) && (!visited[i])) {
                    System.out.printf("Adding node %d to the queue in the BFS%n", i);
                    connectedTo[i] = head;
                    visited[i] = true;
                    queue.offer(i); // add i to the queue
                }
            }
            System.out.printf("Done processing node %d%n", head);
        }
        System.out.printf("Finished with the BFS from start node %d%n", startVertex);
    }

    public void printShortestPath(){

        // find all shortest paths and print them e.g. Path from 1 to 2 : 1-2
        Stack<Integer> pathStack = new Stack<Integer>();
        for (int vertex = startVertex + 1; vertex < adjMatrix.length; vertex++){

            //Make sure that there is path to the vertex
            if (hasPathTo(vertex) && vertex == endVertex){
                System.out.print("Shortest path from " + startVertex + " to " + vertex + ": ");
                //Put the path in a list (this will be a backwards path)

                path = pathTo(vertex);
                //Put the path in a Stack so we can reverse it
                for (Integer connection: path){
                    pathStack.push(connection);
                }
                //Go over the stack to print a path
                while (!pathStack.isEmpty()){
                    //Remove an item form the stack and put it in theVertex variable
                    int theVertex = pathStack.pop();
                    if (theVertex == endVertex){
                        System.out.print(theVertex);
                    } else {
                        System.out.print(theVertex + "-");
                    }
                }
                System.out.println();
            }
        }
    }

    //This method just allows us to check if a vertex is connected to the source.
    //If a vertex has been checked then it is connected
    public boolean hasPathTo(int vertex){
        return visited[vertex];
    }

    //This method returns the path from the startNode to a given vertex
    public List pathTo(int vertex){
        if (!hasPathTo(vertex)) return null;
        List path = new ArrayList<>();
        //First add the vertex passed in to the method
        path.add(vertex);
        //Since we are iterating through a queue,
        //we check form vertex(goal) to source
        while (connectedTo[vertex] != startVertex){
            vertex = connectedTo[vertex];
            path.add(vertex);
        }
        path.add(startVertex); //Now we add the source at the very end
        return path; //We return a path from the vertex to the source
    }

    public static void main(String[] args) {

        // set up a connected, cyclic graph
        /*
             0----------|
           /   \        |
          /     \       |
         1      4       |
          \    / \      |
           \  /   \     6
            2------5    |
            \           |
             \          |
              3---------|
               \
                \
                 7
         */
        boolean[][] adjMatrix = {
                {false,true,false,false,true,false,true,false},
                {true,false,true,false,false,false,false,false},
                {false,true,false,true,true,true,false,false},
                {false,false,true,false,false,false,true,true},
                {true,false,true,false,false,true,false,false},
                {false,false,true,false,true,false,false,false},
                {true,false,false,true,false,false,false,false},
                {false,false,false,true,false,false,false,false}};

        new BfsShortestPath(adjMatrix, 1, 7);



        // set up a connected, cyclic graph
        /*
             2
           /   \
          /     \
         3      1
          \    /
           \  /
            4

         */

/*        boolean[][] adjMatrix = {
                // connected graph
                {false,true,false,true},
                {true,false,true,false},
                {false,true,false,true},
                {true,false,true,false}};*/


    }
}
