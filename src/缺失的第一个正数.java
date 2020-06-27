import java.util.Arrays;
//链接:https://leetcode-cn.com/problems/first-missing-positive/
public class 缺失的第一个正数 {
    public static int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int i=0;
        int j=1;
        for (i=0;i<nums.length&&nums[i]<=0;i++);
        for (;i<nums.length;){
            if (nums[i]==j&&i+1<nums.length&&nums[i]!=nums[i+1]){
                i++;
                j++;
                continue;
            }else if (nums[i]==j&&i+1<nums.length&&nums[i]==nums[i+1]){
                i++;
                continue;
            }else if (nums[i]==j&&i+1>=nums.length){
                i++;
                j++;
                continue;
            }else {
                return j;
            }
        }
        return j;
    }
}
