import java.util.Scanner;

public class 打家劫舍x {
    //链接:https://leetcode-cn.com/problems/house-robber/9
    public static int rob(int[] arr) {
        if (arr.length==0){
            return 0;
        }
        if(arr.length==1){
            return arr[0];
        }
        int nums[]=new int[arr.length+1];
        nums[0]=0;
        nums[1]=arr[0];
        for (int i = 2; i <nums.length ; i++) {
            if (nums[i-2]+arr[i-1]>nums[i-1]){
                nums[i]=nums[i-2]+arr[i-1];
            }else {
                nums[i]=nums[i-1];
            }
        }
        return nums[nums.length-1];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int arr[]=new int[s.length];
        for (int i=0;i<s.length;i++){
            if (s[i].equals("")){
                continue;
            }
            arr[i]=Integer.parseInt(s[i]);
        }
        int x=rob(arr);
        System.out.println(x);
    }
}
