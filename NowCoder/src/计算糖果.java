import java.util.Scanner;

public class 计算糖果 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int x=sc.nextInt();
            int y=sc.nextInt();
            int z=sc.nextInt();
            int h=sc.nextInt();
            int A=x+z;
            int B=y+h;
            if (A%2!=0||A<0||B%2!=0||B<0||(h-B/2)<0){
                System.out.println("NO");
            }else {
                System.out.println((A/2)+" "+(B/2)+" "+(h-B/2));
            }
        }
    }
}
