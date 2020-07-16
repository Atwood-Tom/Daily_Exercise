import java.util.Scanner;

public class 连续最大和 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int number=sc.nextInt();
            int arr[]=new int[number];
            for (int i=0;i<number;i++){
                arr[i]=sc.nextInt();
            }
            int sum=Solution(arr);
            System.out.println(sum);
        }
    }

    private static int Solution(int[] arr) {
        int sum=arr[0];
        int max=arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]<0){
                if (sum+arr[i]<0){
                    sum=0;
                    max=max>arr[i]?max:arr[i];
                }else {
                    sum+=arr[i];
                }
            }else {
                if (sum<0){
                    sum=0;
                }
                sum+=arr[i];
                max=max>sum?max:sum;
            }
        }
        return max;
    }
}
