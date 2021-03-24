public class 连续子数组的最大和 {
    //链接:https://leetcode-cn.com/problems/lian-xu-zi-shu-zu-de-zui-da-he-lcof/
    public static int maxSubArray(int[] nums) {
        int max=Integer.MIN_VALUE;
        int sum=0;
        int i = 0;
        for (; i < nums.length; i++) {
            sum+=nums[i];
            max=Math.max(sum,max);
            if (sum<0){
                sum=0;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(arr));
    }
}
