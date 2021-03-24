

import java.util.Scanner;

public class 最高分是多少 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n=sc.nextInt();
            int m=sc.nextInt();
            int[] arr =new int[n];
            for (int i=0;i<n;i++){
                arr[i]=sc.nextInt();
            }
            for (int i=0;i<m;i++){
                String c=sc.next();
                int A=sc.nextInt();
                int B=sc.nextInt();
                if ("Q".equals(c)){
                    if(A>B){
                        int mid=A;
                        A=B;
                        B=mid;
                    }
                    int max=arr[A-1];
                    for (int j=A;j<B;j++){
                        if (max<arr[j]){
                            max=arr[j];
                        }
                    }
                    System.out.println(max);
                }else if ("U".equals(c)){
                    arr[A-1]=B;
                }
            }
        }
    }
}
