import java.util.Scanner;

public class 字符串压缩 {
    //链接:https://leetcode-cn.com/problems/compress-string-lcci/submissions/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        字符串压缩 x=new 字符串压缩();
        System.out.println(x.compressString(s));
    }
    public String compressString(String s) {
        if(s.length()==0){
            return s;
        }
        StringBuilder res=new StringBuilder();
        char a=s.charAt(0);
        int time=1;
        for (int i=1;i<s.length();i++){
            if (s.charAt(i)!=a){
                res.append(a);
                res.append(time);
                a=s.charAt(i);
                time=1;
            }else {
                time++;
            }
        }
        res.append(a);
        res.append(time);
        if (res.length()>=s.length()){
            return s;
        }
        return res.toString();
    }
}
