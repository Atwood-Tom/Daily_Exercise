import java.util.Scanner;

public class 最小公倍数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(Solution(a,b));
        }
    }

    private static int Solution(int a, int b) {
        if (a==0||b==0){
            return 0;
        }
        int x=Math.max(a,b);
        int y=Math.min(a,b);
        int i=1;
        for (;(i*y)%x!=0;i++);
        return y*i;
    }
}
