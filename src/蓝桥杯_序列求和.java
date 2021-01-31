import java.math.BigInteger;
import java.util.Scanner;

public class 蓝桥杯_序列求和 {
    //链接:http://lx.lanqiao.cn/problem.page?gpid=T2
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        while(sc.hasNextLine()){
            String end=sc.nextLine();
            BigInteger res=new BigInteger(end);
            res=res.add(BigInteger.ONE);
            res=res.multiply(new BigInteger(end));
            res=res.divide(new BigInteger("2"));
            System.out.println(res);
        }
    }
}
