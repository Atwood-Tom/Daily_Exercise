import java.util.HashMap;

public class 找不同 {
    //链接:https://leetcode-cn.com/problems/find-the-difference/
    public static char findTheDifference(String s, String t) {
        HashMap<Character,Integer> hashmap=new HashMap<>();
        for (int i=0;i<s.length();i++){
            hashmap.put(s.charAt(i),hashmap.getOrDefault(s.charAt(i),0)+1);
        }
        int i=0;
        for (;i<t.length();i++){
            int x=hashmap.getOrDefault(t.charAt(i),0);
            x=x-1;
            if (x==-1){
                break;
            }
            hashmap.put(t.charAt(i),x);
        }
        return t.charAt(i);
    }

    public static char findTheDifference1(String s, String t){
        char ans = t.charAt(t.length()-1);
        for(int i = 0; i < s.length(); i++) {
            ans ^= s.charAt(i);
            ans ^= t.charAt(i);
        }
        return ans;
    }
}
