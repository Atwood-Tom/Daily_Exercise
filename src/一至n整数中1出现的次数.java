import java.util.Scanner;

public class 一至n整数中1出现的次数 {
    //链接:https://leetcode-cn.com/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof/
    public int countDigitOne(int n) {
       int result=0;
       int digit=1;
       int high=n/10;int low=0;
       int cur=n%10;
       while(high!=0||cur!=0){
           if (cur<1){
               result+=high*digit;
           }else if (cur==1){
               result+=high*digit+low+1;
           }else if (cur>1){
               result+=(high+1)*digit;
           }
           low+=cur*digit;
           cur=high%10;
           high/=10;
           digit*=10;
       }
       return result;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            一至n整数中1出现的次数 p=new 一至n整数中1出现的次数();
            System.out.println(p.countDigitOne(sc.nextInt()));
        }
    }
}
