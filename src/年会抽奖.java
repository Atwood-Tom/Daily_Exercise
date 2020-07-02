import java.util.Scanner;

public class 年会抽奖 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while (sc.hasNext()){
            int n=sc.nextInt();
            double denominator=1;
            double molecule;
            for (int i=1;i<=n;denominator=denominator*i,i++);
            molecule=Solution(n);
            System.out.println(String.format("%.2f",molecule*100/denominator)+"%");
        }
    }

    private static double Solution(int n) {
        if (n==1){
            return 0;
        }
        if (n==2){
            return 1;
        }
        return (n-1)*(Solution(n-1)+Solution(n-2));
    }
}
