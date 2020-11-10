import java.util.Arrays;

public class 下一个排列 {
    //链接:https://leetcode-cn.com/problems/next-permutation/
    public  void nextPermutation(int[] nums) {
        int pre;
        int cur;
        for (pre=nums.length-2;pre>=0;pre--){
            if (nums[pre]<nums[pre+1]){
                break;
            }
        }
        if (pre==-1){
            Arrays.sort(nums);
            return;
        }
        for (cur=nums.length-1;cur>pre;cur--){
            if (nums[cur]>nums[pre]){
                break;
            }
        }
        int mid=nums[cur];
        nums[cur]=nums[pre];
        nums[pre]=mid;
        change(nums,pre);
        System.out.println(Arrays.toString(nums));
    }

    private void change(int[] nums, int pre) {
        int x=pre+1;
        int y=nums.length-1;
        for (;x<y;x++,y--){
            int mid=nums[x];
            nums[x]=nums[y];
            nums[y]=mid;
        }
    }

    public static void main(String[] args) {
        下一个排列 x=new 下一个排列();
        x.nextPermutation(new int[]{1,3,2});
    }
}
