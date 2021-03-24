public class 买卖股票的最佳时机 {
    //链接:https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/
    public static int maxProfit(int[] prices, int fee) {
        //cash为当天不持有股票的最大利润
        //hold为当天持有股票 的最大利润
        int cash = 0, hold = -prices[0];
        for (int i = 1; i < prices.length; i++) {
            cash = Math.max(cash, hold + prices[i] - fee);
            hold = Math.max(hold, cash - prices[i]);
        }
        return cash;
    }

    public static void main(String[] args) {
        int[] arr =new int[]{1,3,2,8,4,9};
        int fee=2;
        System.out.println(maxProfit(arr,fee));
    }
}
