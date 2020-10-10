public class 把数字翻译成字符串 {
    //链接:https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof/
    public int translateNum(int num) {
        String helper=String.valueOf(num);
        if (helper.length()==0){
            return 0;
        }
        
        int result[]=new int[helper.length()+1];
        result[0]=result[1]=1;
        for (int i=1;i<helper.length();i++){
            String x=helper.substring(i-1,i+1);
            if (x.compareTo("25")<=0&&x.compareTo("10")>=0){
                result[i+1]=result[i]+result[i-1];
            }else {
                result[i+1]=result[i];
            }
        }
        return result[helper.length()];
    }
}
