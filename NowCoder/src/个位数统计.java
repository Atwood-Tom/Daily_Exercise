import java.util.Scanner;

public class 个位数统计 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            int arr[]=Solution(sc.nextLine());
            for (int i=0;i<10;i++){
                if (arr[i]!=0)
                System.out.println(i+":"+arr[i]);
            }
        }
    }

    private static int[] Solution(String nextLine) {
        int arr[]=new int[10];
        for (int i=0;i<nextLine.length();i++){
            arr[(nextLine.charAt(i)-'0')]++;
        }
        return arr;
    }
}
