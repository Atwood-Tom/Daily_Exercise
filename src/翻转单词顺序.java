import java.util.Scanner;

public class 翻转单词顺序 {
    //链接:https://leetcode-cn.com/problems/fan-zhuan-dan-ci-shun-xu-lcof/
    public static String reverseWords1(String s) {
        String arr[]=s.split(" ");
        String end="";
        for (int i=arr.length-1;i>=0;i--){
            if ("".equals(arr[i])){
                continue;
            }else {
                end=end+arr[i]+" " ;
            }
        }
        for (;end.endsWith(" ");){
            end=end.substring(0,end.length()-1);
        }
        return end;
    }
    public static String reverseWords(String s) {
        String arr[]=s.split(" ");
        StringBuffer sb=new StringBuffer();
        for (int i=arr.length-1;i>=0;i--){
            if (!arr[i].equals("")){
                sb.append(arr[i].trim()+" ");
            }
        }
        return sb.toString().trim();
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(reverseWords(sc.nextLine()));
    }
}
