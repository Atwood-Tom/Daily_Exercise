import java.util.HashSet;

public class 存在重复元素 {
    //链接:https://leetcode-cn.com/problems/contains-duplicate/
    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> hashSet=new HashSet<>();
        for (int i=0;i<nums.length;i++){
            if (!hashSet.add(nums[i])){
                return true;
            }
        }
        return false;
    }
}
