import java.util.Scanner;

public class 小易的升级之路 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int n,a;
            n=sc.nextInt();
            a=sc.nextInt();
            int[] arr =new int[n];
            for (int i=0;i<arr.length;arr[i]=sc.nextInt(),i++);
            for (int i=0;i<arr.length;i++){
                if (a>arr[i]){
                    a=a+arr[i];
                }else {
                    for (int j=a;j>=1;j--){
                        if (a%j==0&&arr[i]%j==0){
                            a=a+j;
                            break;
                        }
                    }
                }
            }
            System.out.println(a);
        }
    }
}
