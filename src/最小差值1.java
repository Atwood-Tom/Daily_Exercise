import com.sun.xml.internal.ws.message.ByteArrayAttachment;

import java.util.Arrays;
import java.util.Scanner;

public class 最小差值1 {
    //链接:https://leetcode-cn.com/problems/smallest-range-i/
    public static int smallestRangeI(int[] arr, int K) {
        int min=arr[0], max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max=arr[i];
            }
            if (arr[i]<min){
                min=arr[i];
            }
        }
        return Math.max(0, max - min - 2*K);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s[]=sc.nextLine().split(" ");
        int K=sc.nextInt();
        int arr[]=new int[s.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        System.out.println(smallestRangeI(arr,K));;
    }
}
