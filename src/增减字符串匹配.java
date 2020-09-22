public class 增减字符串匹配 {
    //链接:https://leetcode-cn.com/problems/di-string-match/
    public int[] diStringMatch(String S) {
        int arrays[]=new int[S.length()+1];
        int start=0;
        int end=S.length();
        for (int i=0;i<S.length();i++){
            if (S.charAt(i)=='I'){
                arrays[i]=start++;
            }else {
                arrays[i]=end--;
            }
        }
        arrays[S.length()]=end;
        return arrays;
    }
}
