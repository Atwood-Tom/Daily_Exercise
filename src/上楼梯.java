import java.util.Scanner;

public class 上楼梯 {
    public static int countWays(int n) {
        // write code here
        if (n==0){
            return 0;
        }else if (n==1){
            return 1;
        }else if (n==2){
            return 2;
        }else if (n==3){
            return 4;
        }
        int[] arr =new int[n+1];
        arr[n-1]=1;
        arr[n-2]=2;
        arr[n-3]=4;
        for (int i=n-4;i>=0;i--){
            arr[i]=(arr[i+1]+(arr[i+2]+arr[i+3])%1000000007)%1000000007;
        }
        return arr[0];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            System.out.println(countWays(sc.nextInt()));
        }
    }
}
