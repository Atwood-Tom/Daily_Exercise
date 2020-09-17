import java.util.*;

public class 最长不含重复字符的子字符串 {
    //链接:https://leetcode-cn.com/problems/zui-chang-bu-han-zhong-fu-zi-fu-de-zi-zi-fu-chuan-lcof/
    public static int lengthOfLongestSubstring(String s) {
        if (s.length()<=1){
            return s.length();
        }
        String result="";
        String helper="";
        for (int i=0;i<s.length();i++){
            Set<Character> set=new HashSet<>();
            helper+=s.charAt(i);
            set.add(s.charAt(i));
            int j=i+1;
            for (;j<s.length();j++){
                if (!set.add(s.charAt(j))){
                    if (helper.length()>result.length()){
                        result = helper;
                    }
                    helper="";
                    break;
                }else {
                    helper+=s.charAt(j);
                    set.add(s.charAt(j));
                }
            }
            if (j==s.length())break;
        }
        if (helper.length()>result.length()){
            result=helper;
        }
        return result.length();
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring(" "));
    }
}
