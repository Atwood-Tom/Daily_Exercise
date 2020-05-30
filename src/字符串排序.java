import java.util.Arrays;
import java.util.Scanner;

public class 字符串排序 {
    //https://www.nowcoder.com/questionTerminal/0425aa0df74646209d3f56f627298ab2
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int i=sc.nextInt();
        int arr[]=new int[i];
        for (int j=0;j<i;j++){
            String s=sc.next();
            int length=s.length();
            s=s.substring(length-6,length);
            int x=Integer.parseInt(s);
            arr[j]=x;
        }
        Arrays.sort(arr);
        for (int x=0;x<arr.length;x++){
            System.out.println(arr[x]);
        }
    }
}
