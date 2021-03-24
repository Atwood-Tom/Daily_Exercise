
import java.util.*;

public class Competition {
    //求质数
    public void A(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            int sum=0;
            int[] arr =new int[x];
            for (int i=0;i<x;i++){
                arr[i]=sc.nextInt();
            }
            for (int i=0;i<x;i++){
                sum+=helperA(arr[i]);
            }
            System.out.println(sum);
        }
    }

    private int helperA(int ave) {
        if (ave<2){
            return 0;
        }
        for (int i=2;i<=ave-1;i++){
            if (ave%i==0){
                return 0;
            }
        }
        return ave;
    }

    //格式化补码
    public void B(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            StringBuilder sb=new StringBuilder();
            int x=sc.nextInt();
            int[] arr =new int[32];
            for (int i=0;i<arr.length;i++){
                arr[i]=(x>>i)&1;
            }
            for (int i=31;i>=0;i--){
                System.out.print(arr[i]);
                if (i!=0&&i!=31&&(i)%4==0){
                    System.out.print("-");
                }
            }
        }
    }

    //动态规划
    public void C(){
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            int[] arr =new int[x];
            for (int i=0;i<arr.length;i++){
                arr[i]=sc.nextInt();
            }
            int result=helperC(arr);
            System.out.println(result);
        }
    }

    private int helperC(int[] arr) {
        int[] result =new int[arr.length+1];
        result[0]=0;
        result[1]=arr[0];
        for (int i=1;i<arr.length;i++){
            result[i+1]=Math.max(arr[i]+result[i-1],arr[i-1]);
        }
        return result[result.length-1];
    }

    public static void main(String[] args) {
        Competition competition=new Competition();
        competition.B();
    }
}
