import java.util.HashMap;
import java.util.Scanner;

public class Broken_keyboard {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String input=sc.nextLine();
            String output=sc.nextLine();
            input=input.toUpperCase();
            output=output.toUpperCase();
            String end="";
            int i=0,j=0;
            for (;j<output.length()&&i<input.length();){
                if(input.charAt(i)==output.charAt(j)){
                    j++;
                    i++;
                }else {
                    if (!end.contains(""+input.charAt(i))){
                        end+=input.charAt(i);
                    }
                    i++;
                }
            }
            for (;i<input.length();i++){
                if (!end.contains(""+input.charAt(i))){
                    end+=input.charAt(i);
                }
            }
            System.out.println(end);
        }
    }
}
