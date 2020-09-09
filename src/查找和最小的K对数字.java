import java.util.*;

public class 查找和最小的K对数字 {
    //链接:https://leetcode-cn.com/problems/find-k-pairs-with-smallest-sums/
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {//大堆
        List<List<Integer>> res = new LinkedList<>();
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return o2.get(0) + o2.get(1) - o1.get(0) - o1.get(1);
            }
        });
        int time = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (time < k) {
                    List<Integer> arr = new LinkedList<>();
                    arr.add(nums1[i]);
                    arr.add(nums2[j]);
                    pq.add(arr);
                    time++;
                } else if (k == time && nums1[i] + nums2[j] < pq.peek().get(0) + pq.peek().get(1)) {
                    pq.poll();
                    List<Integer> arr = new LinkedList<>();
                    arr.add(nums1[i]);
                    arr.add(nums2[j]);
                    pq.add(arr);
                } else {
                    break;
                }
            }
        }
        for (int i = 0; i < k && !pq.isEmpty(); i++) {
            res.add(0, pq.poll());
        }
        return res;
    }
    //小堆
    class Pair {
        int n1;
        int n2;
        int sum=n1+n2;
        public Pair(int n1, int n2) {
            this.n1=n1;
            this.n2=n2;
            this.sum=n1+n2;
        }
    }
    public List<List<Integer>> kSmallestPairs1(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> arr=new ArrayList<>();
        if (nums1.length==0||nums2.length==0){
            return arr;
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>(new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o1.sum-o2.sum;
            }
        });
        for (int i=0;i<nums1.length;i++){
            for (int j = 0; j < nums2.length ; j++) {
                Pair p=new Pair(nums1[i],nums2[j]);
                pq.offer(p);
            }
        }
        int i=0;
        while(!pq.isEmpty()&&i<k){
            List<Integer> x=new LinkedList<>();
            Pair y=pq.poll();
            x.add(y.n1);
            x.add(y.n2);
            arr.add(x);
            i++;
        }
        return arr;
    }
}
