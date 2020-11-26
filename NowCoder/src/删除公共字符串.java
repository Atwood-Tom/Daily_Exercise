import java.util.Scanner;

public class 删除公共字符串 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String a=sc.nextLine();
            String b=sc.nextLine();
            System.out.println(Solution(a, b));
        }
    }

    private static String Solution(String a, String b) {
        for (int i=0;i<b.length();i++){
            char x=b.charAt(i);
            while(a.indexOf(x)!=-1){
                int j=a.indexOf(x);
                a=a.substring(0,j)+a.substring(j+1,a.length());
            }
        }
        return a;
    }
}
