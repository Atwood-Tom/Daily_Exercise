import java.util.Arrays;
import java.util.Scanner;
//https://leetcode-cn.com/problems/new-21-game/
public class 新21点 {
    public static double new21Game(int N, int K, int W) {
        if (K==0){
            return 1.0;
        }
        double arr[]=new double[W+K];
        for (int i=K;i<arr.length;i++){
            arr[i]=i<=N?1:0;
        }
        for (int j=1;j<=W;j++){
            arr[K-1]+=arr[j+K-1]/W;
        }
        for (int j=K-2;j>=0;j--){
            arr[j]=(arr[j+1]*W+arr[j+1]-arr[j+1+W])/W;
        }
        return arr[0];
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a,b,c;
        a=sc.nextInt();
        b=sc.nextInt();
        c=sc.nextInt();
        System.out.println(new21Game(a,b,c));
    }
}
