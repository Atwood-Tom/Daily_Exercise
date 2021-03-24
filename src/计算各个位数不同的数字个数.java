import java.util.Scanner;

public class 计算各个位数不同的数字个数 {
    //链接:https://leetcode-cn.com/problems/count-numbers-with-unique-digits/
    public static int countNumbersWithUniqueDigits(int n) {
        if (n==0){
            return 1;
        }
        int[] arr =new int[n+1];
        arr[0]=1;
        arr[1]=9;
        int result=10;
        for (int i=1;i<Math.min(n,10);i++){
           arr[i+1]=arr[i]*(10-i);
            result+=arr[i+1];
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println(countNumbersWithUniqueDigits(sc.nextInt()));
    }
}
