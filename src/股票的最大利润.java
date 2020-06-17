public class 股票的最大利润 {
    //链接:https://leetcode-cn.com/problems/gu-piao-de-zui-da-li-run-lcof/
    public int maxProfit(int[] prices) {
        if (prices.length==0){
            return 0;
        }
        int end=0;
        int t=prices[0];
        for (int i=1;i<prices.length;i++){
            if (end<prices[i]-t){
                end=prices[i]-t;
            }
            if (t>prices[i]){
                t=prices[i];
            }
        }
        return end;
    }
}
