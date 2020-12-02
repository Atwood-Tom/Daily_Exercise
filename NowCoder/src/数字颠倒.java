import java.util.Scanner;

public class 数字颠倒 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String x=sc.nextLine();
            System.out.println(Solution(x));
        }
    }

    private static String Solution(String x) {
        StringBuilder sb=new StringBuilder();
        for (int i=x.length()-1;i>=0;i--){
            sb.append(x.charAt(i));
        }
        return sb.toString();
    }
}
