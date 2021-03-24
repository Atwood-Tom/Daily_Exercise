import java.util.HashMap;
import java.util.Map;

public class 和为s的两个数字 {
    //链接:https://leetcode-cn.com/problems/he-wei-sde-liang-ge-shu-zi-lcof/
    //方法一
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] result =new int[2];
        for (int i=0;i<nums.length;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        for (int i=0;i<nums.length;i++){
            int mid=target-nums[i];
            if (!map.containsKey(mid)){
                continue;
            }
            int x=map.get(mid);
            if (mid==nums[i]||x<2){
                continue;
            }else if (x>=1){
                result[0]=mid;
                result[1]=nums[i];
            }
        }
        return result;
    }
    //方法二
    public int[] twoSum1(int[] nums, int target){
        int i=0;
        int j=nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            if (sum>target) j--;
            else if (sum<target) i++;
            else return new int[]{nums[i],nums[j]};
        }
        return new int[2];
    }
}
