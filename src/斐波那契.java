import java.math.BigInteger;
import java.util.Scanner;

public class 斐波那契 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        BigInteger sum=fsum(n);
        BigInteger p=new BigInteger(sc.next());
        System.out.println(sum.mod(f(m)).mod(p));
    }

    private static BigInteger fsum(int x) {
        BigInteger[] arr =new BigInteger[x+3];
        arr[1]=BigInteger.valueOf(1);
        arr[2]=BigInteger.valueOf(1);
        for (int i=3;i<arr.length;i++){
            arr[i]=arr[i-1].add(arr[i-2]);
        }
        return arr[arr.length-1].add(BigInteger.valueOf(-1));
    }

    //先创建斐波那契的式子
    public static BigInteger f(int x){
        if (x<=2){
            return BigInteger.valueOf(1);
        }
        BigInteger[] arr =new BigInteger[x+1];
        arr[1]=BigInteger.valueOf(1);
        arr[2]=BigInteger.valueOf(1);
        for (int i=3;i<arr.length;i++){
            arr[i]=arr[i-1].add(arr[i-2]);
        }
        return arr[arr.length-1];
    }
}


