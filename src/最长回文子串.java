public class 最长回文子串 {
    //链接:https://leetcode-cn.com/problems/longest-palindromic-substring/
    //暴力法:超出时间限制
    public String longestPalindrome1(String s) {
        String res="";
        for (int i=0;i<s.length();i++){
            for (int j=i+1;j<=s.length();j++){
                if (Solution(s.substring(i,j))){
                    if (res.length()<j-i){
                        res=s.substring(i,j);
                    }
                }
            }
        }
        return res;
    }

    private boolean Solution(String s) {
        for (int i=0,j=s.length()-1;i<j;i++,j--){
            if (s.charAt(i)!=s.charAt(j)){
                return false;
            }
        }
        return true;
    }

    //动态规划
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        for (int x = 0; x < n; ++x) {
            for (int i = 0; i + x < n; ++i) {
                int j = i + x;
                if (x == 0) {
                    dp[i][j] = true;
                } else if (x == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i + 1][j - 1]);
                }
                if (dp[i][j] && x + 1 > ans.length()) {
                    ans = s.substring(i, i + x + 1);
                }
            }
        }
        return ans;
    }
}
