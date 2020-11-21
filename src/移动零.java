public class 移动零 {
    //链接:https://leetcode-cn.com/problems/move-zeroes/
    public void moveZeroes(int[] nums) {
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                int j=i+1;
                for (;j<nums.length&&nums[j]==0;j++);
                if (j==nums.length){
                    break;
                }else {
                    int mid=nums[i];
                    nums[i]=nums[j];
                    nums[j]=mid;
                }
            }
        }
    }

    public void moveZeroes2(int[] nums) {
        int n = nums.length, left = 0, right = 0;
        while (right < n) {
            if (nums[right] != 0) {
                swap(nums, left, right);
                left++;
            }
            right++;
        }
    }

    public void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }
}
