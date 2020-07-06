import java.util.Scanner;

public class 数值的整数次方 {
    public static double myPow(double x, int n) {
        if(n == 0) return 1;
        if(n == 1) return x;
        if(n == -1) return 1 / x;
        double half = myPow(x, n / 2);
        double mod = myPow(x, n % 2);
        return half * half * mod;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(myPow(sc.nextDouble(),sc.nextInt()));;
    }
}
