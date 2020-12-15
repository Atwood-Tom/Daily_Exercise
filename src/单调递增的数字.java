import java.util.Scanner;

public class 单调递增的数字 {
    //链接:https://leetcode-cn.com/problems/monotone-increasing-digits/submissions/

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        单调递增的数字 x=new 单调递增的数字();
        while(sc.hasNextInt()){
            int a=sc.nextInt();
            System.out.println(x.monotoneIncreasingDigits(a));
            System.out.println(x.monotoneIncreasingDigits1(a));
        }
    }

    //暴力法
    public int monotoneIncreasingDigits1(int N) {
        if (N<=10){
            return N-1;
        }
        int left;
        int right;
        int i=N;
        while(i>=10){
            int j=i;
            for (;j>0;j/=10){
                right=j%10;
                left=(j/10)%10;
                if (right>=left){
                    continue;
                }else {
                    break;
                }
            }
            if (j==0){
                break;
            }
            i--;
        }
        return i;
    }
    //方法二
    private int monotoneIncreasingDigits(int N) {
        if (N<=10){
            return N-1;
        }
       String helper=String.valueOf(N);
       String res=new String();
       int right=helper.charAt(helper.length()-1)-'0';
       int left;
       for (int i=helper.length()-2;i>=0;i--){
           left=helper.charAt(i)-'0';
           if (left<=right){
               res=right+res;
               if (i==0){
                   res=left+res;
               }
               right=left;
           }else {
               res="";
               for (int j=i+1;j<helper.length();j++){
                   res+='9';
               }
               right=left-1;
               if (i==0){
                   res=right+res;
               }
           }
       }
       return Integer.parseInt(res);
    }
}
