public class URL化 {
    //链接:https://leetcode-cn.com/problems/string-to-url-lcci/
    public static String replaceSpaces1(String S, int length) {
        StringBuffer sb=new StringBuffer("");
        for (int i=0;i<length;i++){
            if (i>=S.length()||S.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(S.charAt(i));
            }
        }
        return sb.toString();
    }
    public static String replaceSpaces2(String S, int length){
        return S.substring(0,length).replaceAll(" ","%20");
    }
}
