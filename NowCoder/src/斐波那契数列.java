import java.util.Scanner;

public class 斐波那契数列 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            System.out.println(Solution(x));
        }
    }

    private static int Solution(int x) {
        int res=x;
        if (x==0){
            return 0;
        }
        int pre=0;
        int next=1;
        for (;pre+next<=x;){
            res=Math.min(res,x-pre-next);
            int mid=pre+next;
            pre=next;
            next=mid;
        }
        res=Math.min(res,pre+next-x);
        return res;
    }
}
