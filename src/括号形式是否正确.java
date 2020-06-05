import java.util.*;

public class 括号形式是否正确 {
    public static boolean chkParenthesis(String s, int n) {
            // write code here
        Stack<String> myStack=new Stack<>();
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='('){
                myStack.push("(");
                continue;
            }else if(s.charAt(i)==')'){
                if (!myStack.isEmpty()&&myStack.peek()=="("){
                    myStack.pop();
                    continue;
                }else{
                    return false;
                }
            }
        }
        if (myStack.isEmpty()){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        int x=sc.nextInt();
        System.out.println(chkParenthesis(s,x));
    }
}

