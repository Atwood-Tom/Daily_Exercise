import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class 验证回文字符串2 {
    //链接:https://leetcode-cn.com/problems/valid-palindrome-ii/
    public static boolean validPalindrome(String s) {
        int start=0;
        int end=s.length()-1;
        for (;start<end;){
            if (s.charAt(start)==s.charAt(end)){
                start++;
                end--;
                continue;
            }else{
                boolean flag1 = true, flag2 = true;
                for (int i = start, j = end - 1; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag1 = false;
                        break;
                    }
                }
                for (int i = start+ 1, j = end; i < j; i++, j--) {
                    char c3 = s.charAt(i), c4 = s.charAt(j);
                    if (c3 != c4) {
                        flag2 = false;
                        break;
                    }
                }
                return flag1 || flag2;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println(validPalindrome("ebcbbececabbacecbbcbe"));
    }
}
