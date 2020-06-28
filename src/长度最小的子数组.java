import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 长度最小的子数组 {
    //链接:https://leetcode-cn.com/problems/minimum-size-subarray-sum/
    //暴力
    public static int minSubArrayLen2(int s, int[] nums) {
        int j=nums.length;
        boolean x=false;
        for (int i=0;i<nums.length;i++){
            int sum=0;
            int length=0;
            for (int k = i; k < nums.length&&sum<s; sum+=nums[k] ,k++,length++) ;
            if (sum>=s&&length<=j){
                j=length;
                x=true;
            }
        }
        if(x){
            return j;
        }
        return 0;
    }
    //队列
    public static int minSubArrayLen1(int s, int[] nums){
        Queue<Integer> queue=new LinkedList<>();
        int length=Integer.MAX_VALUE;
        int queueLength=0;
        int sum=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            queue.add(nums[i]);
            queueLength++;
            while(sum>=s){
                length=Math.min(length,queueLength);
                sum-=queue.poll();
                queueLength--;
            }
        }
        return length==Integer.MAX_VALUE?0:length;
    }
    //双指针
    public static int minSubArrayLen(int s, int[] nums) {
        int x=nums.length;
        if (x==0){
            return x;
        }
        int y=Integer.MAX_VALUE;
        int start=0;
        int end=0;
        int sum=0;
        while (end<x){
            sum+=nums[end];
            while(sum>=s){
               y=Math.min(y,end-start+1);
               sum-=nums[start];
               start++;
            }
            end++;
        }
        return y==Integer.MAX_VALUE?0:y;
    }
}
