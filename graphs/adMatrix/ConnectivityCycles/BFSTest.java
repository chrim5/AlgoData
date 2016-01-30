package graphs.adMatrix.ConnectivityCycles;

import graphs.adMatrix.ConnectivityCycles.BFS;

/**
 * Created by Marc Christen on 27.01.2016.
 */
public class BFSTest {

    public static void main(String[] args) {
        /*
        // set up a connected, acyclic graph
        /*
             4
           / | \
          /  |  \
         1   2  3
         */
        /*
        boolean[][] adjMatrix = {
                // connected graph
                {false,false,false,true},
                {false,false,false,true},
                {false,false,false,true},
                {true,true,true,false}};
        */


        // set up a graph with 8 vertices that looks like:
		/*
			0 --- 1        5---6
			| \    \       |  /
			|  \    \      | /
			2   3----4     7

			Notice this graph has 2 components -> not connected, cyclic
		*/
        /*
        boolean[][] adjMatrix = {
                // connected graph
                {false,true,true,true,false,false,false,false},
                {true,false,false,true,false,false,false,false},
                {true,false,false,false,false,false,false,false},
                {true,false,false,false,true,false,false,false},
                {false,true,false,true,true,false,false,false},
                {false,false,false,false,false,false,true,true},
                {false,false,false,false,false,true,false,true},
                {false,false,false,false,false,true,true,false}};
        */


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

        boolean[][] adjMatrix = {
                // connected graph
                {false,true,false,true},
                {true,false,true,false},
                {false,true,false,true},
                {true,false,true,false}};

        new BFS(adjMatrix);

    }
}
