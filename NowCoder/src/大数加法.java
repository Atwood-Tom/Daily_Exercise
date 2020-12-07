import java.math.BigInteger;
import java.util.Scanner;

public class 大数加法 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String x=sc.nextLine();
            String y=sc.nextLine();
            BigInteger a=new BigInteger(x);
            BigInteger b=new BigInteger(y);
            System.out.println(a.add(b));
            System.out.println(Solution(x, y));
        }
    }

    private static String Solution(String x, String y) {
        String sb=new String();
        int up=0;
        int i=x.length()-1,j=y.length()-1;
        for (;i>=0&&j>=0;i--,j--){
            int a=x.charAt(i)-'0';
            int b=y.charAt(j)-'0';
            int add=(a+b+up)%10;
            sb=add+sb;
            up=(a+b+up)/10;
        }
        if (i>=0){
            for (;i>=0;i--){
                int a=x.charAt(i)-'0';
                int add=(a+up)%10;
                up=(a+up)/10;
                sb=add+sb;
            }
        } else if (j>=0){
            for (;j>=0;j--){
                int a=y.charAt(j)-'0';
                int add=(a+up)%10;
                up=(a+up)/10;
                sb=add+sb;
            }
        }
        if (up!=0){
            sb=up+sb;
        }
        return sb;
    }
}
