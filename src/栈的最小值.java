import java.util.Stack;

public class 栈的最小值 {
    //链接：https://leetcode-cn.com/problems/min-stack-lcci/
    Stack<Integer> main=new Stack<>();
    Stack<Integer> min=new Stack<>();
    public void push1(int x) {
        main.push(x);
        if(min.size() <= 0) {
            min.push(x);
        }else {
            if(min.peek() < x) {
                min.push(min.peek());
            }else {
                min.push(x);
            }
        }
    }
    public void pop1() {
        min.pop();
        main.pop();
    }
    public int top1() {
       return main.peek();
    }
    public int getMin1() {
        return min.peek();
    }
}
