import java.util.Scanner;

public class 球的半径和体积 {
    public static void main(String[] args) {
        double PI=Math.acos(-1);
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            double r;
            double v;
            double x1,y1,z1;
            double x2,y2,z2;
            x1=sc.nextDouble();
            y1=sc.nextDouble();
            z1=sc.nextDouble();
            x2=sc.nextDouble();
            y2=sc.nextDouble();
            z2=sc.nextDouble();
            r=Math.sqrt((Math.pow(x1-x2,2))+(Math.pow(y1-y2,2))+(Math.pow(z1-z2,2)));
            v=PI*r*r*r*4/3;
            System.out.println(String.format("%.3f",r)+" "+String.format("%.3f",v));
        }
    }
}
