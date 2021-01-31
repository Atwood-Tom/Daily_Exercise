import java.util.Scanner;

public class 单调栈结构 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int number=sc.nextInt();
        int arr[]=new int[number];
        int res[][]=new int[arr.length][2];
        for (int i=0;i<arr.length;arr[i]=sc.nextInt(),i++);
        for (int i=0;i<arr.length;i++){
            int l=i-1;
            int r=i+1;
            for (;l>=0&&arr[l]>arr[i];l=res[l][0]);
            res[i][0]=l;
            for (;r<arr.length&&arr[r]>arr[i];r++);
            if (r==arr.length){
                r=-1;
            }
            res[i][1]=r;
        }
        for (int i=0;i<arr.length;i++){
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
}
