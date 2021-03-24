import java.util.Scanner;

public class 找X {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr =new int[n];
        for (int i=0;i<n;i++){
            arr[i]=sc.nextInt();
        }
        int x=sc.nextInt();
        int i=arr.length-1;
        for (;i>=0&&x!=arr[i];i--);
        System.out.println(i);
    }
}
