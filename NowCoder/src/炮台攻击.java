import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;

public class 炮台攻击 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            int result=0;
            String arr[]=sc.nextLine().split(" ");
            System.out.println(Arrays.toString(arr));
            int r =Integer.parseInt(arr[0]);
            int x1=Integer.parseInt(arr[1]);
            int y1=Integer.parseInt(arr[2]);
            int x2=Integer.parseInt(arr[3]);
            int y2=Integer.parseInt(arr[4]);
            int x3=Integer.parseInt(arr[5]);
            int y3=Integer.parseInt(arr[6]);
            int x0=Integer.parseInt(arr[7]);
            int y0=Integer.parseInt(arr[8]);
            if(r*r>=Math.pow(x1-x0,2)+Math.pow(y1-y0,2)){
                result++;
            }
            if(r*r>=Math.pow(x2-x0,2)+Math.pow(y2-y0,2)){
                result++;
            }
            if(r*r>=Math.pow(x3-x0,2)+Math.pow(y3-y0,2)){
                result++;
            }
            System.out.println(result+"x");
        }
    }
}
