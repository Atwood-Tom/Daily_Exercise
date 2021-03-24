import java.util.HashMap;
import java.util.Scanner;

public class 青蛙跳台阶问题 {
    //链接;https://leetcode-cn.com/problems/qing-wa-tiao-tai-jie-wen-ti-lcof/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int n=sc.nextInt();
            System.out.println(numWays(n));
            System.out.println(numWays2(n));
        }
    }
    public static int numWays(int n){
        int pre=1;
        int next=1;
        int sum=1;
        if (n<=1){
            return sum;
        }
        for (int i=2;i<=n;i++){
            sum=(pre+next)%1000000007;
            pre=next;
            next=sum;
        }
        return next;
    }
    public static int numWays1(int n){
        HashMap<Integer,Integer> hashMap=new HashMap<>();
        hashMap.put(0,1);
        hashMap.put(1,1);
        for (int i=2;i<=n;i++){
            int x=(hashMap.get(i-1)+hashMap.get(i-2))%1000000007;
            hashMap.put(i,x);
        }
        return hashMap.get(n);
    }
    public static int numWays2(int n){
        if (n==0){
            return 1;
        }
        if (n<=2){
            return n;
        }
        int[] arr =new int[n+1];
        arr[0]=1;
        arr[1]=1;
        arr[2]=2;
        for (int i=3;i<arr.length;i++){
            arr[i]=(arr[i-1]+arr[i-2])%1000000007;
        }
        return arr[n];
    }
}
