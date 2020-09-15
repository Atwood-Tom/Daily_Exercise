import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class 数组中重复的数字 {
    //链接:https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
    //方法一
    public int findRepeatNumber1(int[] nums) {
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i+1<nums.length&&nums[i]==nums[i+1]){
                return nums[i];
            }
        }
        return 0;
    }
    //方法二
    public int findRepeatNumber2(int[] nums){
        Set<Integer> set=new HashSet<>();
        int i=0;
        while(i<nums.length){
            if (!set.add(nums[i])){
                break;
            }
            i++;
        }
        return nums[i];
    }
}
