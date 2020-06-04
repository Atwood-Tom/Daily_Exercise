public class 除自身以外数组的乘积 {
    public int[] productExceptSelf(int[] nums) {
        int x=1;
        int averzero=0;
        for (int i=0;i<nums.length;i++){
            if (nums[i]==0){
                averzero++;
            }
            if (nums[i]!=0){
                x*=nums[i];
            }
        }
        for (int i=0;i<nums.length;i++){
            if (averzero>=2){
                nums[i]=0;
                continue;
            }else if (averzero==1){
                if (nums[i]==0){
                    nums[i]=x;
                }else{
                    nums[i]=0;
                }
            }else if (averzero==0){
                nums[i]=x/nums[i];
            }
        }
        return nums;
    }
}
