public class 打家劫舍2 {
    public static int rob(int[] nums) {
        if (nums.length==1){
            return nums[0];
        }
        return Math.max(helper(nums,0,nums.length-1),helper(nums,1,nums.length));
    }
    public static int helper(int[] arr,int start,int end){
        if (start>end){
            return 0;
        }
        if (start==end){
            return arr[start];
        }
        int num[]=new int[end-start+1];
        num[0]=0;
        num[1]=arr[start];
        for (int i=2;i<num.length;i++){
            if (num[i-2]+arr[start+i-1]>num[i-1]){
                num[i]=num[i-2]+arr[start+i-1];
            }else {
                num[i]=num[i-1];
            }
        }
        return num[num.length-1];
    }

    public static void main(String[] args) {
        int arr[]=new int[]{0};
        System.out.println(rob(arr));
    }
}
