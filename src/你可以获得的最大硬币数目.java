import java.util.*;
public class 你可以获得的最大硬币数目 {
    //链接:https://leetcode-cn.com/problems/maximum-number-of-coins-you-can-get/
    public int maxCoins(int[] piles) {
        Arrays.sort(piles);
        int res=0;
        for(int i=1;i*3<=piles.length;i++){
            res+=piles[piles.length-1-(2*i-1)];
        }
        return res;
    }
}
