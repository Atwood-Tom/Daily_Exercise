import java.util.Scanner;

public class 守形数 {
    
    //链接:https://acm.nowcoder.com/questionTerminal/99e403f8342b4d0e82f1c1395ba62d7b?commentTags%3DJavaScript
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            int x=sc.nextInt();
            int y=x*x;
            if (Solution(x,y)){
                System.out.println("Yes!");
            }else {
                System.out.println("No!");
            }
        }
    }

    private static boolean Solution(int x, int y) {
        while (x>0){
            if (x%10==y%10){
                x=x/10;
                y=y/10;
                continue;
            }else {
                return false;
            }
        }
        return true;
    }
}
