import java.util.Scanner;

public class 计算糖果 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s =sc.nextLine().split(" ");
        int[] arr =new int[s.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int a=(arr[0]+arr[2])/2;
        int b=(arr[1]+arr[3])/2;
        int c=(arr[3]-arr[1])/2;
        if (a-b!=arr[0]){
            System.out.println("No");
            return;
        }else if (b-c!=arr[1]){
            System.out.println("No");
            return;
        }else if (a+b!=arr[2]){
            System.out.println("No");
            return;
        }else if (b+c!=arr[3]){
            System.out.println("No");
            return;
        }
        System.out.println(a+" "+b+" "+c);
    }
}
