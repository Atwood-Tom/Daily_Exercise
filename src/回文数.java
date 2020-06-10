import java.util.Deque;
import java.util.LinkedList;

public class 回文数 {
    //链接:https://leetcode-cn.com/problems/palindrome-number/
    //方法一
    public boolean isPalindrome(int x) {
        Deque<String> deque=new LinkedList<>();
        if (x<0){
           return false;
        }
        for (;x>0;){
            deque.addLast(""+x%10);
            x=x/10;
        }
        while(!deque.isEmpty()){
            String y=deque.pollFirst();
            if (deque.isEmpty()){
                return true;
            }
            String z=deque.pollLast();
            if (y.equals(z)){
                continue;
            }else{
                return false;
            }
        }
        return true;
    }
    //方法二
    public boolean isPalindrome2(int x){
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int y=0;
        int z=x;
        while (z>0){
            y=z%10+y*10;
            z=z/10;
        }
        return x==y;
    }
}
