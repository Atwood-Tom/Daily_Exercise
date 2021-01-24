public class 最长连续递增序列 {
    public static int findLengthOfLCIS(int[] nums) {
        if (nums.length==0||nums.length==1){
            return nums.length;
        }
        int l=0;
        int r=1;
        int maxlength=0;
        for (;l<nums.length&&r<nums.length;){
            if (nums[r-1]<nums[r]){
                r++;
            }else {
                maxlength=Math.max(maxlength,r-l);
                l=r;
                r=l+1;
            }
        }
        maxlength=Math.max(maxlength,r-l);
        return maxlength;
    }
}
