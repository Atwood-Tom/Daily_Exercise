import java.util.HashSet;
import java.util.Set;

public class 扑克牌中的顺子 {
    //链接:https://leetcode-cn.com/problems/bu-ke-pai-zhong-de-shun-zi-lcof/
    public boolean isStraight(int[] nums) {
        int max=1;
        int min=13;
        Set<Integer> set=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                continue;
            }
            max=Math.max(max,nums[i]);
            min=Math.min(min,nums[i]);
            if (!set.add(nums[i])){
                return false;
            }
        }
        return max - min <= 5;
    }
}
