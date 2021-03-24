import java.util.Arrays;
import java.util.Scanner;

public class 代价 {
    //链接:https://www.nowcoder.com/questionTerminal/b7985769dc434d85a16717908669bcab
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] x =sc.nextLine().split(" ");
        int[] arr =new int[x.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(x[i]);
        }
        Arrays.sort(arr);
        int max=arr[arr.length-1]-arr[0];
        System.out.println(max);
    }
}
