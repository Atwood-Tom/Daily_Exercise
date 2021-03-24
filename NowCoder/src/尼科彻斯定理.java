import java.util.Scanner;

public class 尼科彻斯定理 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            int x=sc.nextInt();
            Solution((x)*(x-1)/2,x);
        }
    }

    private static void Solution(int x, int time) {
        int[] arr =new int[time];
        for (int i=0;i<time;i++,x++){
            if (i==time-1){
                System.out.println((2*x+1));
            }else {
                System.out.print((2*x+1)+"+");
            }
        }
    }
}
