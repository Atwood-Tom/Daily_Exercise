import java.util.Scanner;
import java.util.Stack;

public class 棒球比赛 {
    public static int calPoints(String[] ops) {
        Stack<Integer> stack=new Stack<>();
        for (int i=0;i<ops.length;i++){
            if ("+".equals(ops[i])){
                int a=stack.pop();
                int b=stack.pop();
                stack.push(b);
                stack.push(a);
                stack.push(a+b);
            }else if ("c".equals(ops[i])||"C".equals(ops[i])){
                stack.pop();
            }else if ("d".equals(ops[i])||"D".equals(ops[i])){
                stack.push(stack.peek()*2);
            }else {
                stack.push(Integer.parseInt(ops[i]));
            }
        }
        int x=0;
        while (!stack.isEmpty()){
            x=x+stack.pop();
        }
        return x;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s =sc.nextLine().split(" ");
        int x=calPoints(s);
        System.out.println(x);
    }
}
