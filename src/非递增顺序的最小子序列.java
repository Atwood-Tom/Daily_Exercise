import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 非递增顺序的最小子序列 {
    //链接 :https://leetcode-cn.com/problems/minimum-subsequence-in-non-increasing-order/
    public List<Integer> minSubsequence(int[] nums) {
        List<Integer> list=  new ArrayList<Integer>();
        int total=0;
        for(int s:nums){
            total+=s;
        }
        Arrays.sort(nums);
        System.out.println(Arrays.toString(nums));
        int temp=0;
        for(int i=nums.length-1;i>=0;i--){
            temp+=nums[i];
            list.add(nums[i]);
            if(2*temp>total){
                break;
            }
        }
        return list;

    }

}
