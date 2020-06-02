import java.util.Scanner;

public class 前N项之和 {
    //链接:https://leetcode-cn.com/problems/qiu-12n-lcof/
    //递归方法
    public static int sumNums(int n) {
        return n==1?1:sumNums(n-1)+n;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        System.out.println(sumNums(x));
    }
}
