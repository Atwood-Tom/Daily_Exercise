import java.math.BigInteger;
import java.util.Scanner;

class 蓝桥杯_斐波那契数列 {
    //蓝桥杯入门:http://lx.lanqiao.cn/problem.page?gpid=T4
    public static void main(String[] arg){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int a=sc.nextInt();
            //Solution1(a);
            Solution2(a);
        }
    }

    private static void Solution2(int a) {
        long f1=1;
        long f2=1;
        long res=1;
        for (int i=3;i<=a;i++){
            res=(f1+f2)%10007;
            f1=f2;
            f2=res;
        }
        System.out.println(res%10007);
    }

    private static void Solution1(int a) {
        BigInteger f1=BigInteger.ONE;
        BigInteger f2=BigInteger.ONE;
        BigInteger res=BigInteger.ONE;
        for(int i=3;i<=a;i++){
            res=f1.add(f2);
            f1=f2;
            f2=res;
        }
        System.out.println(res.mod(new BigInteger("10007")));
    }
}