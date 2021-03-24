import java.util.Scanner;
import java.util.Stack;

public class 删除字符串中的所有相邻重复项 {
    //利用栈进行操作
    public static String removeDuplicates(String S) {
        Stack<Character> stack=new Stack<>();
        char[] arr =S.toCharArray();
        for (int i=0;i<arr.length;i++){
            if (stack.isEmpty()){
                stack.push(arr[i]);
            }else if(stack.peek()==arr[i]){
                stack.pop();
            }else{
                stack.push(arr[i]);
            }
        }
        S="";
        while(!stack.isEmpty()){
            S=stack.pop()+S;
        }
        return S;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        s=removeDuplicates(s);
        System.out.println(s);
    }
}
