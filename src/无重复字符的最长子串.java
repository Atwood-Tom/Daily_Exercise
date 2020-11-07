import java.util.HashMap;

public class 无重复字符的最长子串 {
    //链接:https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/
    public static int lengthOfLongestSubstring(String s) {
        int result=0;
        int maxlength=0;
        int del=-1;
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (hashMap.containsKey(s.charAt(i))&&hashMap.get(s.charAt(i))>del){
                result=Math.max(maxlength,result);
                int x=hashMap.get(s.charAt(i));
                maxlength=i-hashMap.get(s.charAt(i));
                hashMap.put(s.charAt(i),i);
                del=x;
            }else {
                hashMap.put(s.charAt(i),i);
                maxlength++;
            }
        }
        return Math.max(result,maxlength);
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
