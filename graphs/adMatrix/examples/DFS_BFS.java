package graphs.adMatrix.examples; /**
 * Created by Marc Christen on 27.01.2016.
 */
// Stephen Fulwider
//	A sample program to show working examples of Depth First Search (graphs.adMatrix.examples.DFS) and Breadth First Search (graphs.adMatrix.ConnectivityCycles.BFS)

import java.util.LinkedList;
import java.util.Queue;


public class DFS_BFS
{

    public static void main(String[] args)
    {
        new DFS_BFS(); // I like doing things this way so I don't have to use static objects
    }

    int N; // number of vertices in the graph
    boolean[][] G; // the graph as an adjacency matrix
    // G[i][j] is true if there is an edge from i to j


    DFS_BFS()
    {
        setupGraph();

        System.out.println("------------------------------");
        System.out.println();

        // perform a graphs.adMatrix.examples.DFS on the graph
        DFS();

        System.out.println();
        System.out.println("------------------------------");
        System.out.println();


        // perform a graphs.adMatrix.ConnectivityCycles.BFS on the graph
        BFS();

        System.out.println();
        System.out.println("------------------------------");
        System.out.println();
        System.out.println("All done - have a good day!");
    }

    // initial setup of the graph
    void setupGraph()
    {
        // set up a graph with 8 vertices that looks like:
		/*
			0 --- 1        5---6
			| \    \       |  /
			|  \    \      | /
			2   3----4     7

			Notice this graph has 2 components
		*/

        N=8;
        G=new boolean[N][N];

        G[0][1]=G[1][0]=true; // notice that for each edge G[i][j] == G[j][i]
        G[0][2]=G[2][0]=true;	// this means that the graph is undirected
        G[0][3]=G[3][0]=true;
        G[1][4]=G[4][1]=true;
        G[3][4]=G[4][3]=true;
        G[5][6]=G[6][5]=true;
        G[5][7]=G[7][5]=true;
        G[6][7]=G[7][6]=true;
    }

    // perform a graphs.adMatrix.examples.DFS on the graph G
    void DFS()
    {
        boolean[] V=new boolean[N]; // a visited array to mark which vertices have been visited while doing the graphs.adMatrix.examples.DFS

        int numComponets=0; // the number of components in the graph

        // do the graphs.adMatrix.examples.DFS from each node not already visited
        for (int i=0; i<N; ++i)
            if (!V[i])
            {
                ++numComponets;
                System.out.printf("Starting a graphs.adMatrix.DFS for component %d starting at node %d%n",numComponets,i);

                DFS(i,V);
            }

        System.out.println();
        System.out.printf("Finished with graphs.adMatrix.DFS - found %d components.%n", numComponets);
    }

    // perform a graphs.adMatrix.examples.DFS starting at node at (works recursively)
    void DFS(int at, boolean[] V)
    {
        System.out.printf("At node %d in the graphs.adMatrix.examples.DFS%n",at);

        // mark that we are visiting this node
        V[at]=true;

        // recursively visit every node connected to this that we have not already visited
        for (int i=0; i<N; ++i)
            if (G[at][i] && !V[i])
            {
                System.out.printf("Going to node %d...",i);
                DFS(i,V);
            }

        System.out.printf("Done processing node %d%n", at);
    }

    // perform a graphs.adMatrix.ConnectivityCycles.BFS on the graph G
    void BFS()
    {
        boolean[] V=new boolean[N]; // a visited array to mark which vertices have been visited while doing the graphs.adMatrix.ConnectivityCycles.BFS

        int numComponets=0; // the number of components in the graph

        // do the graphs.adMatrix.ConnectivityCycles.BFS from each node not already visited
        for (int i=0; i<N; ++i)
            if (!V[i])
            {
                ++numComponets;
                System.out.printf("Starting a graphs.adMatrix.ConnectivityCycles.BFS for component %d starting at node %d%n",numComponets,i);

                BFS(i,V);
            }

        System.out.println();
        System.out.printf("Finished with graphs.adMatrix.ConnectivityCycles.BFS - found %d components.%n", numComponets);
    }

    // perform a graphs.adMatrix.ConnectivityCycles.BFS starting at node start
    void BFS(int start, boolean[] V)
    {
        Queue<Integer> Q=new LinkedList<Integer>(); // A queue to process nodes

        // start with only the start node in the queue and mark it as visited
        Q.offer(start);
        V[start]=true;

        // continue searching the graph while still nodes in the queue
        while (!Q.isEmpty())
        {
            int at=Q.poll(); // get the head of the queue
            System.out.printf("At node %d in the graphs.adMatrix.ConnectivityCycles.BFS%n",at);

            // add any unseen nodes to the queue to process, then mark them as visited so they don't get re-added
            for (int i=0; i<N; ++i)
                if (G[at][i] && !V[i])
                {
                    Q.offer(i);
                    V[i]=true;

                    System.out.printf("Adding node %d to the queue in the graphs.adMatrix.ConnectivityCycles.BFS%n", i);
                }

            System.out.printf("Done processing node %d%n", at);
        }

        System.out.printf("Finished with the graphs.adMatrix.ConnectivityCycles.BFS from start node %d%n", start);
    }

}