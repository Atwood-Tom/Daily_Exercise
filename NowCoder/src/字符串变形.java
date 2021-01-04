import java.util.Scanner;

public class 字符串变形 {
    //链接:https://www.nowcoder.com/questionTerminal/c3120c1c1bc44ad986259c0cf0f0b80e
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextLine()){
            res=new StringBuilder();
            String main=sc.nextLine();
            System.out.println(trans(main,main.length()));
            System.out.println(trans(main,main.length()).length());
        }
    }
    public static StringBuilder res;
    public static String trans(String s, int n) {
        res=new StringBuilder();
        Solution(s,0,n-1);
        return res.toString();
    }

    private static void Solution(String s, int start, int end) {
        int x=s.indexOf(" ",start);
        if (x!=-1){
            Solution(s,x+1,end);
            end=x-1;
        }
        StringBuilder helper=new StringBuilder();
        for (int i=start;i<=end;i++){
            if (s.charAt(i)>='a'&&s.charAt(i)<='z'){
                char y= (char) (s.charAt(i)-'a'+'A');
                helper.append(y);
            }else {
                char y= (char) (s.charAt(i)-'A'+'a');
                helper.append(y);
            }
        }
        res.append(helper);
        if (start==0){
            return;
        }
        res.append(" ");
    }
}
