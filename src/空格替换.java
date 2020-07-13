public class 空格替换 {
    //链接:https://www.nowcoder.com/questionTerminal/b0850698cb41449188344cdb647f3e99
    public String replaceSpace1(String iniString, int length) {
        // write code here
        iniString=iniString.replaceAll(" ","%20");
        return iniString;
    }
    public String replaceSpace2(String iniString, int length) {
        // write code here
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<length;i++){
            if (iniString.charAt(i)==' '){
                sb.append("%20");
            }else {
                sb.append(iniString.charAt(i));
            }
        }
        return sb.toString();
    }
}
