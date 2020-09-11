import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class 丑数 {
    //链接:https://leetcode-cn.com/problems/chou-shu-lcof/
    public static int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i = 1; i < n; i++) {
            int n2 = dp[a] * 2, n3 = dp[b] * 3, n5 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n2, n3), n5);
            if(dp[i] == n2) a++;
            if(dp[i] == n3) b++;
            if(dp[i] == n5) c++;
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(nthUglyNumber(sc.nextInt()));
    }
}
