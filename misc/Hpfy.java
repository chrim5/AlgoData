package misc;

/**
 * Created by Marc Christen on 31.01.2016.
 */
public class Hpfy {
    //unknown algorithm from an older exam.
    //The question was: what is the time complexity?
    private static void hpfy(int[] a){
        int n= a.length;
        for (int i=1; i<n; i++){
            int pos = i;
            while (pos > 0){
                int parent = (pos-1)/2;
                if (a[parent] <= a[pos]) break;
                //swap
                int tmp = a[pos];
                a[pos] = tmp;
                // continue with the parent
                pos = parent;
            }
        }
    }

    public static void main(String[] args) {
        Hpfy sort = new Hpfy();
        int[] a = {5,6,9,1,8,3};
        sort.hpfy(a);
    }
}
