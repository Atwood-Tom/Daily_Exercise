import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

public class 前K个高频元素 {
    //链接:https://leetcode-cn.com/problems/top-k-frequent-elements/
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr =new int[k];
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        for (int i=0;i<nums.length;hashMap.put(nums[i],hashMap.getOrDefault(nums[i],0)+1),i++);
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer a, Integer b) {
                return hashMap.get(a) - hashMap.get(b);
            }
        });
        for (Integer key : hashMap.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (hashMap.get(key) > hashMap.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        for (int i=0;i<k;i++){
            arr[i]=pq.remove();
        }
        Arrays.sort(arr);
        return arr;
    }
}
