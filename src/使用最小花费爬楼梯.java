public class 使用最小花费爬楼梯 {
    //链接:https://leetcode-cn.com/problems/min-cost-climbing-stairs/
    public static int minCostClimbingStairs(int[] cost) {
        if (cost.length==1){
            return cost[0];
        }
        if (cost.length==2){
            return Math.min(cost[0],cost[1]);
        }
        int[] arr =new int[cost.length];
        arr[0]=0;
        arr[1]=Math.min(cost[0],cost[1]);
        for (int i=2;i<cost.length;i++){
            arr[i]=Math.min(cost[i]+arr[i-1],cost[i-1]+arr[i-2]);
        }
        return arr[arr.length-1];
    }
}
