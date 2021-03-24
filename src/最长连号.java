import java.util.Arrays;
import java.util.Scanner;

public class 最长连号 {
    //链接:https://nanti.jisuanke.com/t/T1606
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if (n==0){
            System.out.println(0);
        }
        int max=0;
        int helper=1;
        int[] arr =new int[10000];
        for (int i=0;i<n;arr[i]=sc.nextInt(),i++);
        for (int i=0;i<n;i++){
            if (arr[i]+1==arr[i+1]){
                helper++;
            }else {
                max=Math.max(max,helper);
                helper=1;
            }
        }
        System.out.println(max);
    }
}
