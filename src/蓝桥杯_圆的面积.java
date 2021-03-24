import java.util.Scanner;

public class 蓝桥杯_圆的面积 {
    //链接:http://lx.lanqiao.cn/problem.page?gpid=T3
    private static final double PI=3.14159265358979323;

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextDouble()){
            double r=sc.nextDouble();
            double res=r*r*PI;
            System.out.printf(String.format("%.7f%n",res));
        }
    }
}
