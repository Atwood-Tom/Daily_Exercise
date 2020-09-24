import java.util.Stack;

public class 逆波兰表达式求值 {
    //链接:https://leetcode-cn.com/problems/evaluate-reverse-polish-notation/
    public static int evalRPN(String[] tokens) {
        Stack<String> stack=new Stack<>();
        for (int i = 0; i < tokens.length; i++) {
            if (tokens[i].equals("+")||tokens[i].equals("-")||tokens[i].equals("*")||tokens[i].equals("/")){
                int a=Integer.valueOf(stack.pop());
                int b=Integer.valueOf(stack.pop());
                if (tokens[i].equals("+")){
                    stack.add(String.valueOf(b+a));
                }else if (tokens[i].equals("-")){
                    stack.add(String.valueOf(b-a));
                }else if (tokens[i].equals("*")){
                    stack.add(String.valueOf(a*b));
                }else {
                    stack.add(String.valueOf(b/a));
                }
            }else {
                stack.add(tokens[i]);
            }
        }
        return Integer.valueOf(stack.pop());
    }

    public static void main(String[] args) {
        System.out.println(evalRPN(new String[]{"4","13","5","/","+"}));
    }
}
