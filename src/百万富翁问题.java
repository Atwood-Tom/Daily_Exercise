import javax.swing.*;

public class 百万富翁问题 {
    public static void main(String[] args) {
        int a=10;
        int b=1;
        int sumb=1;
        for (int i=1;i<30;i++){
            b*=2;
            sumb+=b;
        }
        System.out.println(30*a+" "+sumb);
    }
}
