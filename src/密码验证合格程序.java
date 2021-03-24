import java.util.Scanner;

public class 密码验证合格程序 {
    //链接:https://www.nowcoder.com/questionTerminal/184edec193864f0985ad2684fbc86841?commentTags=Java
    static class passWord{
        passWord next;
        String password;
        passWord(String x){
            this.password=x;
        }
    }
    public static passWord head=new passWord("0");
    public static passWord tail=head;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String mypassword=sc.nextLine();
            if (qualified(mypassword)){
                if (repeat(mypassword)){
                    System.out.println("NG");
                }else {
                    System.out.println("OK");
                }
            }else {
                System.out.println("NG");
            }
        }
    }

    private static boolean qualified(String mypassword) {
        int symbolNumber=0;
        boolean a,b,c,d;
        a=b=c=d=false;
        for (int i=0;i<mypassword.length();i++){
            if (mypassword.charAt(i)>='0'&&mypassword.charAt(i)<='9'&&!a){
                a=true;
                symbolNumber++;
            }else if (mypassword.charAt(i)>='a'&&mypassword.charAt(i)<='z'&&!b){
                b=true;
                symbolNumber++;
            }else if (mypassword.charAt(i)>='A'&&mypassword.charAt(i)<='Z'&&!c){
                c=true;
                symbolNumber++;
            }else if(!d){
                d=true;
                symbolNumber++;
            }
        }
        if (mypassword.length()>8&&symbolNumber>=3){
            return qualified2(mypassword);
        }
        return false;
    }

    private static boolean qualified2(String mypassword) {
        for (int i=0;i<mypassword.length()-2;i++){
            String x=mypassword.substring(i,i+3);
            if (mypassword.substring(i+1).contains(x)){
                return false;
            }
        }
        return true;
    }

    private static boolean repeat(String mypassword) {
        for (passWord p=head.next;p!=null;p=p.next){
            if (mypassword.equals(p.password)){
                return true;
            }
        }
        return false;
    }
}
