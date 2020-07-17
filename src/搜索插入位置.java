public class 搜索插入位置 {
    //链接:https://leetcode-cn.com/problems/search-insert-position/
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target<=nums[i]){
                return i;
            }
        }
        return nums.length;
    }
}
