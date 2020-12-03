import java.util.Scanner;

public class 计数质数 {
    //链接:https://leetcode-cn.com/problems/count-primes/
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            System.out.println(Solution2.countPrimes(x));
            System.out.println(Solution1.countPrimes(x));
        }
    }
    //枚举法
    static class Solution1 {
        public static int countPrimes(int n) {
            int ans = 0;
            for (int i = 2; i < n; ++i) {
                ans += isPrime(i) ? 1 : 0;
            }
            return ans;
        }
        //判断是否为质数
        public static boolean isPrime(int x) {
            for (int i = 2; i * i <= x; ++i) {
                if (x % i == 0) {
                    return false;
                }
            }
            return true;
        }
    }
    static class Solution2{
        public static int countPrimes(int x){
            int res=0;
            int arr[]=new int[x];
            for (int i=2;i*i<arr.length;i++){
                for (int j=2;i*j<arr.length;arr[i*j]=1,j++);
            }
            for (int i=2;i<arr.length;i++){
                if (arr[i]==0){
                    res++;
                }
            }
            return res;
        }
    }
}
