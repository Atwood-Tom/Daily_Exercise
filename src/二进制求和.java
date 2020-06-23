import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

public class 二进制求和 {
    //链接:https://leetcode-cn.com/problems/add-binary/
    public static String addBinary(String a, String b) {
        int ai=a.length()-1;
        int bi=b.length()-1;
        String end="";
        int go=0;
        for (;ai>=0||bi>=0;ai--,bi--){
            int valueA=0;
            int valueB=0;
            if (ai>=0){
                 valueA=a.charAt(ai)-'0';
            }
            if (bi>=0){
                 valueB=b.charAt(bi)-'0';
            }
            if (valueA+valueB+go==3){
                end="1"+end;
                go=1;
            } else if (valueA+valueB+go==2) {
                go=1;
                end="0"+end;
            }else if (valueA+valueB+go==1){
                go=0;
                end="1"+end;
            }else {
                go=0;
                end="0"+end;
            }
        }
        if (go>0){
            end="1"+end;
        }
        return end;
    }

    public static void main(String[] args) {
        String a="1010";
        String b="1011";
        System.out.println(addBinary(a,b));
    }
}
