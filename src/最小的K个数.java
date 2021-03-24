import java.util.Comparator;
import java.util.PriorityQueue;

public class 最小的K个数 {
    //链接:https://leetcode-cn.com/problems/zui-xiao-de-kge-shu-lcof/
    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length==0||k==0){
            return new int[0];
        }
        PriorityQueue<Integer> pq=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for (int i=0;i<arr.length;i++){
            if (pq.size()<k){
                pq.add(arr[i]);
            }else {
                if (pq.peek()>arr[i]){
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }
        int[] result =new int[k];
        for (int i=0;!pq.isEmpty();i++){
            result[i]=pq.remove();
        }
        return result;
    }
}
