import java.util.Scanner;

public class 左旋转字符串 {
    //链接:https://leetcode-cn.com/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof/
    public static String reverseLeftWords(String s, int n) {
        String result=s.substring(n)+s.substring(0,n);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(reverseLeftWords(sc.nextLine(),sc.nextInt()));
    }
}
