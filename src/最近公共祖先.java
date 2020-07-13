import java.util.Scanner;

public class 最近公共祖先 {
    //链接:https://www.nowcoder.com/questionTerminal/70e00e490b454006976c1fdf47f155d9
    public static int getLCA(int a, int b) {
        // write code here
        for (;a!=b;){
            if (a>b){
                a=a/2;
            }else {
                b=b/2;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int a=sc.nextInt();
            int b=sc.nextInt();
            System.out.println(getLCA(a,b));
        }
    }
}
