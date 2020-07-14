import java.util.Arrays;
import java.util.Scanner;

public class 二维数组打印 {
    //链接:https://www.nowcoder.com/questionTerminal/6fadc1dac83a443c9434f350a5803b51?orderByHotValue=2&done=0&pos=1&onlyReference=false
    public static int[] arrayPrint(int[][] arr, int n) {
        // write code here
        int newarr[]=new int[n*n];
        int z=0;
        for (int i = n-1; i >=0 ; i--) {
            for (int j=i,k=0;j<n&&k<n;j++,k++){
                newarr[z++]=arr[k][j];
            }
        }
        for (int i=1;i<n;i++){
            for (int j=i,k=0;j<n&&k<n;j++,k++){
                newarr[z++]=arr[j][k];
            }
        }
        return newarr;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int arr[][]=new int[4][4];
        for (int i=0;i<arr.length;i++){
            for (int j=0;j<arr[0].length;j++){
                arr[i][j]=sc.nextInt();
            }
        }
        for (int i=0;i<4;i++){
            System.out.println(Arrays.toString(arr[i]));
        }
        System.out.println(Arrays.toString(arrayPrint(arr,4)));
    }
}
