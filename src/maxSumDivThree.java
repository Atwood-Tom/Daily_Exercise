public class maxSumDivThree {
    //https://leetcode-cn.com/problems/greatest-sum-divisible-by-three/
    public int maxSumDivThree(int[] nums) {
        int arr[][]=new int[nums.length+1][3];
        for(int i=0;i<nums.length;i++){
            int a=arr[i][0];
            int b=arr[i][1];
            int c=arr[i][2];
            if(nums[i]%3==0){
                arr[i+1][0]=a+nums[i];
                arr[i+1][1]=b==0?0:b+nums[i];
                arr[i+1][2]=c==0?0:c+nums[i];

            }else if(nums[i]%3==1){
                arr[i+1][0]=a;
                arr[i+1][1]=Math.max(a+nums[i],b);
                arr[i+1][2]=b==0?c:b+nums[i];
                if(c!=0){
                    arr[i+1][0]=Math.max(a,c+nums[i]);
                }
            }else if(nums[i]%3==2){
                arr[i+1][0]=a;
                arr[i+1][1]=c==0?b:c+nums[i];
                arr[i+1][2]=Math.max(a+nums[i],c);
                if(b!=0){
                    arr[i+1][0]=Math.max(a,b+nums[i]);
                }
            }
        }
        return arr[arr.length-1][0];
    }

    public static void main(String[] args) {
        int arr[]=new int[]{1,8,7,3,6};
        maxSumDivThree maxSumDivThree=new maxSumDivThree();
        System.out.println(maxSumDivThree.maxSumDivThree(arr));
    }
}
