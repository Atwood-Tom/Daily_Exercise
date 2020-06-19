import java.util.Deque;
import java.util.LinkedList;

public class 验证回文串 {
    //链接:https://leetcode-cn.com/problems/valid-palindrome/
    public static boolean isPalindrome(String s) {
        s=s.toUpperCase();
        if (s.length()==0&&s.length()==1){
            return true;
        }
        Deque<Character> deque=new LinkedList<>();
        for (int i=0;i<s.length();i++){
            if ((s.charAt(i)<='Z'&&s.charAt(i)>='A')||(s.charAt(i)>='0'&&s.charAt(i)<='9')){
                deque.addLast(s.charAt(i));
            }
        }
        while(!deque.isEmpty()){
            char x=deque.pollFirst();
            if (deque.isEmpty()){
                return true;
            }
            char y=deque.pollLast();
            if (x!=y){
               return false;
            }
        }
        return true;
    }
    public static boolean isPalindrome2(String s){
        s=s.toUpperCase();
        int end = s.length() - 1;
        int begin = 0;
        while (begin < end) {
            for (;begin<end;begin++){
                if ((s.charAt(begin)<='Z'&&s.charAt(begin)>='A')||(s.charAt(begin)>='0'&&s.charAt(begin)<='9')){
                    break;
                }
            }
            boolean x=false;
            for (;begin<end;end--){
                if ((s.charAt(end)<='Z'&&s.charAt(end)>='A')||(s.charAt(end)>='0'&&s.charAt(end)<='9')){
                    x=true;
                    break;
                }
            }
            if (!x){
                return true;
            } else if (s.charAt(end)!=s.charAt(begin)) {
                return false;
            }
            begin++;
            end--;
        }
        return true;
    }
}
