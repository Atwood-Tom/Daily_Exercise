import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            String helper=sc.nextLine();
            String res=Solution(helper);
            System.out.println(res);
        }
    }

    private static String Solution(String helper) {
        StringBuffer sb=new StringBuffer("");
        int remove=0;
        if(helper.charAt(0)>='A'&&helper.charAt(0)<='Z'){
            remove=helper.charAt(0)-'A';
            remove++;
        }else if(helper.charAt(0)>='0'&&helper.charAt(0)<='9'){
            remove=helper.charAt(0)-'0';
        }else {
            remove=1;
        }
        for(int i=0;i<helper.length();i++){
            char x=helper.charAt(i);
            if(x>='A'&&x<='Z'){
                char add=(char) (((x-'A'+remove)%26)+'A');
                sb.append(add);
            }else if(x>='0'&&x<='9'){
                char add=(char) (((x-'0'+remove)%10)+'0');
                sb.append(add);
            }else {
                sb.append(x);
            }
        }
        return sb.toString();
    }
}
