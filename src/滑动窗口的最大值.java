import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class 滑动窗口的最大值 {
    //链接:https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
    //暴力求解
    public int[] maxSlidingWindow1(int[] nums, int k) {
        if (nums.length==0){
            return new int[0];
        }
        int[] arr =new int[nums.length-k+1];
        for (int i=0;i<arr.length;i++){
            int max=Integer.MIN_VALUE;
            for (int j=i;j<i+k&&j<nums.length;j++){
                max=max>nums[j]?max:nums[j];
            }
            arr[i]=max;
        }
        return arr;
    }
    //双向队列
    public static int[] maxSlidingWindow(int[] nums, int k){
        if(nums.length == 0 || k == 0) return new int[0];
        Deque<Integer> deque = new LinkedList<>();
        int[] res = new int[nums.length - k + 1];
        for(int i = 0; i < k; i++) { // 未形成窗口
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
        }
        int j=0;
        res[j++] = deque.peekFirst();
        for(int i = k; i < nums.length; i++) { // 形成窗口后
            if(deque.peekFirst() == nums[i - k]) deque.removeFirst();
            while(!deque.isEmpty() && deque.peekLast() < nums[i]) deque.removeLast();
            deque.addLast(nums[i]);
            res[j++] = deque.peekFirst();
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int i=sc.nextInt();
            int[] arr =new int[i];
            for (int j=0;j<arr.length;arr[j]=sc.nextInt(),j++);
            System.out.println(Arrays.toString(maxSlidingWindow(arr,sc.nextInt())));
        }
    }
}
