import java.util.Scanner;

public class 汽水瓶 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            if (x!=0){
                System.out.println(Solution(x));
            }else {
                break;
            }
        }
    }

    private static int Solution(int x) {
        int res=0;
        while(x>=3){
            res+=1;
            x-=3;
            x+=1;
        }
        if (x==2){
            res++;
        }
        return res;
    }
}
