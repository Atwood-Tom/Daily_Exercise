import java.util.Scanner;

public class 剪绳子 {
    //链接:https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
    //方法一:
    public static int cuttingRope(int n) {
        if (n<=3){
            return n-1;
        }
        int arr[]=new int[n+1];
        arr[1]=1;
        arr[2]=2;
        arr[3]=3;
        for (int i=4;i<=n;i++){
            arr[i]=help(arr,i);
        }
        return arr[n];
    }

    private static int help(int[] arr,int i) {
        int left=1;
        int right=i-1;
        int max=0;
        for (;left<=right;max=Math.max(max,arr[left]*arr[right]),left++,right--);
        return max;
    }
    //方法二
    public static int cuttingRope1(int n){
        if(n<=3){
            return n-1;
        }
        int max=1;
        if (n%3==1){
            n-=4;
            max*=4;
        }
        if (n%3==2){
            n-=2;
            max*=2;
        }
        while(n!=0){
            max*=3;
            n=n-3;
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            System.out.println(cuttingRope(x));
            System.out.println(cuttingRope1(x));
        }
    }
}
