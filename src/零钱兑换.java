public class 零钱兑换 {
    public int change(int amount, int[] coins) {
        //链接：https://leetcode-cn.com/problems/coin-change-2/
        int[] res = new int[amount + 1];
        res[0] = 1;
        for (int i=0;i<coins.length;i++){
            for (int j=coins[i];j<res.length;j++){
                res[j]+=res[j-coins[i]];
            }
        }
        return res[amount];
    }

    public static void main(String[] args) {
        零钱兑换 x=new 零钱兑换();
        System.out.println(x.change(5,new int[]{1,2,5}));
    }
}
