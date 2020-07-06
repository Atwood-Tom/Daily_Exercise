import java.util.Arrays;
import java.util.Scanner;

public class 在霍格沃茨找零钱 {
    public static final int first=493;
    public static final int second=29;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        //记录应付的钱
        String p=sc.next();
        //记录实付的钱
        String a=sc.next();
        long p1=Solution(p);
        long a1=Solution(a);
        long x=a1-p1;
        String end="";
        if (x<0){
            end="-";
            x=x*-1;
        }
        end+=(x/first)+".";
        x=x%first;
        end+=(x/second)+".";
        x=x%second;
        end+=x;
        System.out.println(end);
    }

    private static long Solution(String a) {
        int arr[]=new int[3];
        String x[]=a.split("\\.");
        for (int i=0;i<3;i++){
            arr[i]=Integer.parseInt(x[i]);
        }
        return (arr[0]*first)+arr[1]*second+arr[2];
    }
}
