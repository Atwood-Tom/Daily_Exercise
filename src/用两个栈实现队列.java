import java.util.Stack;

public class 用两个栈实现队列 {
    //链接:https://leetcode-cn.com/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof/
    Stack<Integer> mainStack=new Stack<>();
    Stack<Integer> helpStack=new Stack<>();

    public void appendTail(int value) {
        mainStack.add(value);
    }

    public int deleteHead() {
        if (mainStack.isEmpty()&&helpStack.isEmpty()){
            return -1;
        }
        if (helpStack.isEmpty()){
            while(!mainStack.isEmpty()){
                helpStack.add(mainStack.pop());
            }
        }
        return helpStack.pop();
    }
}
