import java.util.Scanner;

public class 统计回文 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String A=sc.nextLine();
            String B=sc.nextLine();
            int result=0;
            for (int i=0;i<=A.length();i++){
                String helper=A.substring(0,i)+B+A.substring(i);
                if (Solution(helper)){
                    result++;
                }
            }
            System.out.println(result);
        }
    }

    private static boolean Solution(String helper) {
        int i=0;
        int j=helper.length()-1;
        while (i<j){
            if (helper.charAt(i)!=helper.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}
