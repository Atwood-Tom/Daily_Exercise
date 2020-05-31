import java.util.Stack;
//链接:https://leetcode-cn.com/problems/implement-queue-using-stacks-lcci/
public class 化栈为队 {
    Stack<Integer> myStack=new Stack<>();
    Stack<Integer> helper =new Stack<>();
    /** Push element x to the back of queue. */
    public void push(int x) {
        myStack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        while(!myStack.isEmpty()){
            helper.push(myStack.pop());
        }
        Integer x=helper.pop();
        while (!helper.isEmpty()){
            myStack.push(helper.pop());
        }
        return x;
    }

    /** Get the front element. */
    public int peek() {
        while(!myStack.isEmpty()){
            helper.push(myStack.pop());
        }
        Integer x=helper.peek();
        while (!helper.isEmpty()){
            myStack.push(helper.pop());
        }
        return x;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return myStack.isEmpty();
    }
}
