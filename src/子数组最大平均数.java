public class 子数组最大平均数 {
    public double findMaxAverage(int[] nums, int k) {
        //链接：https://leetcode-cn.com/problems/maximum-average-subarray-i/
        int sum=0;
        double max=0;
        for (int i=0;i<k;i++){
            sum+=nums[i];
        }
        max=sum;
        for(int i=1;i+k-1<nums.length;i++){
            sum-=nums[i-1];
            sum+=nums[i+k-1];
            max=Math.max(sum,max);
        }
        return max/k;
    }

    public static void main(String[] args) {
        子数组最大平均数 x=new 子数组最大平均数();
        System.out.println(x.findMaxAverage(new int[]{1,12,-5,-6,50,3},4));
    }
}
