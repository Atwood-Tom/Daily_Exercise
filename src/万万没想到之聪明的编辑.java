import java.util.Scanner;
import java.util.Stack;
//链接：https://www.nowcoder.com/questionTerminal/42852fd7045c442192fa89404ab42e92
public class 万万没想到之聪明的编辑 {
    public static void main(String[] args) {
        Stack<Character> stack=new Stack<>();
        Scanner sc= new Scanner(System.in);
        int i=sc.nextInt();
        for (;i>0;i--){
            String s=sc.next();
            boolean two=false;
            boolean three =false;
            for (int j = 0; j < s.length(); j++) {
                if (stack.isEmpty()){
                    stack.push(s.charAt(j));
                }else if (three&&stack.peek()==s.charAt(j)){
                    continue;
                }else if(!two&&stack.peek()==s.charAt(j)){
                    two=true;
                    three=true;
                    stack.push(s.charAt(j));
                }else if (!two&&stack.peek()!=s.charAt(j)){
                    three=false;
                    stack.push(s.charAt(j));
                }else if (two&&stack.peek()==s.charAt(j)){
                    three=false;
                    if (j+1<s.length()&&s.charAt(j+1)!=stack.peek()){
                        two=false;
                    }
                    continue;
                }else if (two&&s.charAt(j)!=stack.peek()){
                    three=false;
                    if (j+1<s.length()&&s.charAt(j+1)!=s.charAt(j)){
                        two=false;
                    }
                    stack.push(s.charAt(j));
                }
            }
            String x="";
            while(!stack.isEmpty()){
                x=stack.pop()+x;
            }
            System.out.println(x);

        }
    }
}
