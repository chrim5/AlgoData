package graphs.adMatrix.examples; /**
 * Created by Marc Christen on 26.01.2016.
 */
import java.util.Stack;


public class DFS {

    Stack<Integer> st;
    int vFirst;

    int[][] adjMatrix;
    //int[] isVisited = new int[4];
    int[] isVisited;
    int firstNode;

    public DFS(int[][] Matrix) {

        this.adjMatrix = Matrix;
        this.isVisited = new int[adjMatrix.length];
        this.st = new Stack<Integer>();
        //int i;
        //int[] node = {0, 1, 2, 3};
        //int firstNode = node[0];
        //int firstNode = adjMatrix[0];
        this.firstNode = 0;
        depthFirst(firstNode, adjMatrix.length);
    }

    public void depthFirst(int vFirst,int n) {
        int v,i;
        st.push(vFirst);

        while(!st.isEmpty()) {
            v = st.pop(); // int on the top of stack
            if(isVisited[v]==0) {
                System.out.print("\n"+(v+1));
                isVisited[v]=1;
            }
            for ( i=0;i<n;i++) {
                if((adjMatrix[v][i] == 1) && (isVisited[i] == 0)) {
                    st.push(v);
                    isVisited[i]=1;
                    System.out.print(" " + (i+1));
                    v = i;
                }
            }
        }
    }
}