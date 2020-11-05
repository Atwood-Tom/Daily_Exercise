import java.util.HashMap;
import java.util.HashSet;

public class 同构字符串 {
    //链接:https://leetcode-cn.com/problems/isomorphic-strings/
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()){
            return false;
        }
        HashSet<Character> hashSet=new HashSet<>();
        HashMap<Character,Character> hashmap=new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (hashmap.containsKey(s.charAt(i))){
                if (hashmap.get(s.charAt(i))!=t.charAt(i)){
                    return false;
                }
            }else {
                if (!hashSet.contains(t.charAt(i))){
                    hashmap.put(s.charAt(i),t.charAt(i));
                    hashSet.add(t.charAt(i));
                }else {
                    return false;
                }
            }
        }
        return true;
    }
}
