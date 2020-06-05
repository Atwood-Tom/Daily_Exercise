
import java.util.Scanner;

public class 最长数字串 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int max=0;
        int where=0;
        for (int i=0;i<s.length();){
            if (s.charAt(i)>='0'&&s.charAt(i)<='9'){
                int j=i;
                for (;j<s.length();){
                    if(s.charAt(j)>='0'&&s.charAt(j)<='9'){
                        j++;
                    }else{
                        break;
                    }
                }
                if(max<j-i){
                    max=j-i;
                    where=i;
                }
                i=j;
            }else {
                i++;
            }
        }
        System.out.println(s.substring(where,where+max));
    }
}
