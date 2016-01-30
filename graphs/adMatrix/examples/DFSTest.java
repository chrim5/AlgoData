package graphs.adMatrix.examples;

/**
 * Created by Marc Christen on 26.01.2016.
 */
public class DFSTest {
    public static void main(String[] args) {
        int[][] adjMatrix = {
/*                {0,0,0,1},
                {0,0,0,1},
                {0,0,0,1},
                {1,1,1,0}};*/
                {0,1,0,1},
                {1,0,1,0},
                {1,1,0,1},
                {1,1,1,0}};

        new DFS(adjMatrix);
    }
}
