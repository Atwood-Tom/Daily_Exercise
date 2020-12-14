import java.util.Comparator;
import java.util.PriorityQueue;

public class 数组中的第K个最大元素 {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> p=new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        });
        for (int i=0;i<nums.length;i++){
            if (i<k){
                p.add(nums[i]);
                continue;
            } else if (nums[i]>p.peek()){
                p.poll();
                p.add(nums[i]);
            }
        }
        return p.peek();
    }

    public static void main(String[] args) {
        数组中的第K个最大元素 x=new 数组中的第K个最大元素();
        System.out.println(x.findKthLargest(new int[]{2, 5, 8}, 2));
    }
}
