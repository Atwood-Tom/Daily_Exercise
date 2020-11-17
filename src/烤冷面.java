import java.util.*;
public class 烤冷面 {
    public static void main(String[] args) {
        D();
    }
    public static void D(){
        Scanner sc=new Scanner(System.in);
        while (sc.hasNextLong()) {
            long x=sc.nextLong();
            long y=sc.nextLong();
            long result=helperD2(x,y);
            System.out.println(result);
            result=helperD(x,y);
            System.out.println(result);
        }
    }

    public static  long helperD2(long x,long y){
        long result=0;
        while(x!=0&&y!=0){
            if (x<y){
                long mid=x;
                x=y;
                y=mid;
            }
            result+=(4*y*(x/y));
            x=x%y;
        }
        return result;
    }
    private static long helperD(long x, long y) {
        if (x==y){
            return (4*x);
        }else if (x>y){
            return helperD(x-y,y)+(4*y);
        }
        return helperD(x,y-x)+(4*x);
    }
}
