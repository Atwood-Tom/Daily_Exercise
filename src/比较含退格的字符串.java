import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class 比较含退格的字符串 {
    //链接:https://leetcode-cn.com/problems/backspace-string-compare/
    //方法一
    public boolean backspaceCompare1(String S, String T) {
        S=helper1(S);
        T=helper1(T);
        return S.equals(T);
    }

    private String helper1(String s) {
        String result="";
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='#'){
                if (result.length()>0){
                    result=result.substring(0,result.length()-1);
                }
                continue;
            }
            result+=s.charAt(i);
        }
        return result;
    }
    //方法二
    public boolean backspaceCompare(String S, String T){
        Stack<Character> s_result= new Stack<>();
        helper(S,s_result);
        Stack<Character> t_result=new Stack<>();
        helper(T,t_result);
        while(!s_result.isEmpty()&&!t_result.isEmpty()){
            if (s_result.pop()!=t_result.pop()){
                return false;
            }
        }
        return s_result.isEmpty()&&t_result.isEmpty();
    }
    private void helper(String s,Stack<Character> result){
        for (int i=0;i<s.length();i++){
            if (s.charAt(i)=='#'&&!result.isEmpty()){
                result.pop();
            }else if (s.charAt(i)!='#'){
                result.add(s.charAt(i));
            }
        }
    }
}
