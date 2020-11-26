import java.util.Scanner;

public class 买苹果 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            int result=Solution(num);
            System.out.println(result);
        }
    }

    private static int Solution(int num) {
        if (num==0){
            return 0;
        }
        int res=0;
        if (num==6){
            return 1;
        }
        for (int i=0;i<=num/8;i++){
            if ((num-8*i)%6==0){
                res=i+(num-8*i)/6;
            }
        }
        return res==0?-1:res;
    }
}
