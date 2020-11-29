import java.util.Scanner;

public class 不要二 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int W=sc.nextInt();
            int H=sc.nextInt();
            System.out.println(Solution(W, H));
        }
    }

    private static int Solution(int w, int h) {
        int x = (w / 4) * 2 + ((w % 4) <= 2 ? (w % 4) : 2);
        int y = ((w - 2) / 4) * 2 + (((w - 2) % 4) <= 2 ? ((w - 2) % 4) : 2);

        int count = (h / 4) * (x + y) * 2;

        if (h % 4 >= 1)
            count += x;
        if (h % 4 >= 2)
            count += x;
        if (h % 4 >= 3)
            count += y;

       return count;
    }
}
