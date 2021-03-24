public class 重新排列字符串 {
    //链接:https://leetcode-cn.com/problems/shuffle-string/
    public String restoreString(String s, int[] indices) {
        char[] result =new char[indices.length];
        for (int i=0;i<indices.length;i++){
            result[indices[i]]=s.charAt(i);
        }
//        String end=new String(result);
//        return end;
        return String.valueOf(result);
    }
}
