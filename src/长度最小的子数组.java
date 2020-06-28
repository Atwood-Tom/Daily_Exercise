import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 长度最小的子数组 {
    //链接:https://leetcode-cn.com/problems/minimum-size-subarray-sum/
    public static int minSubArrayLen(int s, int[] nums) {
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
    public int minSubArrayLen1(int s, int[] nums) {
        int n = nums.length;
        if (n == 0) {
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        int start = 0, end = 0;
        int sum = 0;
        while (end < n) {
            sum += nums[end];
            while (sum >= s) {
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

  
}
