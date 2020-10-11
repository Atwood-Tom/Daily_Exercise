import java.util.Arrays;

public class 分割等和子集 {
    //递归方法(效率较低)
    public static boolean canPartition1(int[] nums) {
        if (nums.length<2){
            return false;
        }
        int sum=0;
        int index=0;
        for(int i=0;i<nums.length;sum+=nums[i],i++);
        if(sum%2==1) return false;
        sum=sum/2;
        Arrays.sort(nums);
        return helper1(index,sum,nums);
    }

    private static boolean helper1(int index, int sum, int[] nums) {
        if (index>=nums.length){
            return false;
        }
        if (sum-nums[index]==0){
            return true;
        }
        return helper1(index+1,sum,nums)||helper1(index+1,sum-nums[index],nums);
    }
    //方法二
    public static boolean canPartition(int[] nums) {
        Arrays.sort(nums);
        int sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
        }

        if(sum%2!=0){
            return false;
        }
        sum=sum/2;

        if(nums[nums.length-1]>sum){
            return false;
        }else if(nums[nums.length-1]==sum){
            return true;
        }

        sum=sum-nums[nums.length-1];

        for (int i = nums.length-1; i >= 0 ; i--) {
            if(nums[i]<=sum){
                int copy=sum;
                copy-=nums[i];
                if(copy==0){
                    return true;
                }
                for (int j = i-1; j >= 0; j--) {
                    if(nums[j]<=copy) {
                        copy -= nums[j];
                        if (copy == 0) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
