import java.util.Scanner;

public class 末尾0的个数 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(Solution(n));
        }
    }

    private static int Solution(int n) {
        int res=0;
        while(n>0){
            res+=(n/5);
            n=n/5;
        }
        return res;
    }
}
