import java.util.Stack;

public class 合法括号序列判断 {
    public boolean chkParenthesis(String A, int n) {
        // write code here
        Stack<Character> stack=new Stack<>();
        for (int i=0;i<n;i++){
            if (A.charAt(i)=='('){
                stack.add('(');
            }else if (A.charAt(i)==')'&&!stack.isEmpty()){
                stack.pop();
            }else {
                return false;
            }
        }
        if (stack.isEmpty()){
            return true;
        }
        return false;
    }
}
