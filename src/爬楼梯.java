public class 爬楼梯 {
    //链接：https://leetcode-cn.com/problems/climbing-stairs/
    //动态规划
    public int climbStairs1(int n) {
        if (n==1){
            return 1;
        }
        if (n==2){
            return 2;
        }
        int arr[]=new int[n-1];
        arr[0]=1;
        arr[1]=2;
        for (int i=2;i<arr.length;i++){
            arr[i]=arr[i-1]+arr[i-2];
        }
        return arr[n-1];
    }
    //滚动数组
    public int climbStairs2(int n){
        if (n==1){
            return 1;
        }
        int first=1,second=2;
        for (int i=3;i<=n;i++){
            int thrid=first+second;
            first=second;
            second=thrid;
        }
        return second;
    }
}
