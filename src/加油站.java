public class 加油站 {
    //链接:https://leetcode-cn.com/problems/gas-station/
    public int canCompleteCircuit(int[] gas, int[] cost) {
        for (int i = 0; i < gas.length; i++) {
            if(helper(gas,cost,i)){
                return i;
            }
        }
        return -1;
    }

    private boolean helper(int[] gas, int[] cost, int i) {
        int start=0;
        for (int j=i;j<gas.length;j++){
            start+=gas[j];
            if (start-cost[j]<0){
                return false;
            }else {
                start-=cost[j];
            }
        }
        for (int j=0;j<i;j++){
            start+=gas[j];
            if (start-cost[j]<0){
                return false;
            }else {
                start-=cost[j];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        加油站 x=new 加油站();
        System.out.println(x.canCompleteCircuit(new int[]{1, 2, 3, 4, 5}, new int[]{3, 4, 5, 1, 2}));
    }
}
