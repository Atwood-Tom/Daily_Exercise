public class 最长公共前缀 {
    //
    // 链接：https://leetcode-cn.com/problems/longest-common-prefix/
    public static String longestCommonPrefix(String[] strs) {
        String x="";
        if (strs.length==0){
            return x;
        }
        for (int i=0;i<=strs[0].length();i++){
            String y=strs[0].substring(0,i);
            for (int j=1;j<strs.length;j++){
                if (strs[j].startsWith(y)){
                    continue;
                }else {
                    return x;
                }
            }
            x=y;
        }
        return x;
    }
}
