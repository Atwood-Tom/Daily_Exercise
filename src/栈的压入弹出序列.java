import java.util.Stack;
//链接：https://leetcode-cn.com/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof/
public class 栈的压入弹出序列 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        int i=0,j=0;
        for (;i<pushed.length;){
            if (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }else {
                stack.push(pushed[i]);
                i++;
            }
        }
        for (;j<popped.length;){
            if (!stack.isEmpty()&&stack.peek()==popped[j]){
                stack.pop();
                j++;
            }else {
                return false;
            }
        }
        return true;
    }
}
