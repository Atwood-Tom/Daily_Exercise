import java.util.Comparator;
import java.util.PriorityQueue;

public class 寻找第K大 {
    //链接:https://www.nowcoder.com/practice/e016ad9b7f0b45048c58a9f27ba618bf?tpId=191&&tqId=35236&rp=1&ru=/activity/oj&qru=/ta/job-code-high-algorithm/question-ranking
    public int findKth(int[] a, int n, int K) {
        // write code here
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i = 0; i < n; i++) {
            if (i<K){
                pq.add(a[i]);
            }else {
                if (pq.peek()<a[i]){
                    pq.poll();
                    pq.add(a[i]);
                }
            }
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        寻找第K大 x=new 寻找第K大();
        System.out.println(x.findKth(new int[]{1,2,3,45,7},5,3));
    }
}
