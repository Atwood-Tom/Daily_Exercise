import java.util.Arrays;
import java.util.Scanner;

public class 次数是奇数的节点 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr =new int[x];
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        Solution(arr);
    }

    private static void Solution(int[] arr) {
        Arrays.sort(arr);
        int z=0;
        int[] end =new int[2];
        for (int i=0;i<arr.length;){
            if (i+1<arr.length&&arr[i]==arr[i+1]){
                int j=1;
                for (;i+j<arr.length&&arr[i]==arr[i+j];j++);
                if (j%2==1){
                    end[z++]=arr[i];
                }
                i=i+j;
            }else {
                end[z++]=arr[i];
                i++;
            }
        }
        System.out.println(end[0]+" "+end[1]);
    }
}
