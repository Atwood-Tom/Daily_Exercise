import java.util.HashMap;
import java.util.Scanner;

public class 十六进制转化成十进制 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="";
        while(sc.hasNextLine()){
            s=sc.nextLine();
            long sum=0;
            long x=1;
            for (int i=s.length()-1;i> -1;i--){
                if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                    sum+=x*Integer.valueOf(s.charAt(i));
                }else if (s.charAt(i)>='A'&&s.charAt(i)<='Z'){
                    sum+=x*(Integer.valueOf(s.charAt(i))-55);
                }else if (s.charAt(i)>='a'&&s.charAt(i)<='z'){
                    sum+=x*(Integer.valueOf(s.charAt(i))-87);
                }
                x*=16;
            }
            System.out.println(sum);
        }
    }
}
