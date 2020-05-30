import java.util.Scanner;

public class 斐波那契数 {
    //链接:https://leetcode-cn.com/problems/fibonacci-number/
    public static int fib(int N) {
        int a=0;int b=1;
        if (N==0){
            return 0;
        }
        if (N==1){
            return 1;
        }
        for (int i=2;i<=N;i++){
            int y=a;
            a=b;
            b=a+y;
        }
        return b;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        x=fib(x);
        System.out.println(x);
    }
}
