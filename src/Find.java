
import java.util.Arrays;

public class Find {
    public static int findKth(int[] a, int n, int K) {
        //排序区间(a,length-i,a.length)
        for (int i=0;i<a.length;i++){
            int max=0;
            for (int j = 1; j < a.length-i; j++) {
                if (a[max]<a[j]){
                    max=j;
                }
                int mid=a[max];
                a[max]=a[a.length-i-1];
                a[a.length-i-1]=mid;
            }
        }
        int i=a.length-1;
        for (;i>=0&&K>0;i--){
            if (a[i]>n){
                K--;
            }
        }
        return a[i+1];
    }
}
