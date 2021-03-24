import java.util.Arrays;
import java.util.Scanner;

public class n个数中最小的k个 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String[] x =sc.nextLine().split(" ");
            int time=Integer.parseInt(x[x.length-1]);
            int[] arr =new int[x.length-1];
            for (int i=0;i<arr.length;i++){
                arr[i]=Integer.parseInt(x[i]);
            }
            Arrays.sort(arr);
            for (int i=0;i<time;i++){
                if (i==time-1){
                    System.out.println(arr[i]);
                    break;
                }
                System.out.print(arr[i]+" ");
            }
        }
    }
}
