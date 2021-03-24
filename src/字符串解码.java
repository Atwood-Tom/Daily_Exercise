import java.util.Scanner;
import java.util.Stack;
//链接:https://leetcode-cn.com/problems/decode-string/
public class 字符串解码 {
    public static Stack<String> myString=new Stack<>();
    public static String decodeString(String s) {
        String x="";
        char[] arr =s.toCharArray();
        for (int i=0;i<arr.length;){
            if (arr[i]==']'){
                for (;!"[".equals(myString.peek());){
                    x=myString.pop()+x;
                }
                myString.pop();
                String y=x;
                int j=Integer.parseInt(myString.pop());
                for (;j>1;j--){
                    x=y+x;
                }
                myString.push(x);
                x="";
                i++;
            }else if(arr[i]>='0'&&arr[i]<='9'){
                int j=s.indexOf("[",i);
                myString.push(s.substring(i,j));
                i=j;
            }else{
                myString.push(""+arr[i]);
                i++;
            }
        }
        x="";
        while(!myString.isEmpty()){
            x=myString.pop()+x;
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=decodeString(s);
        System.out.println(s);
    }
}
