import java.util.HashMap;

public class 字符串中的第一个唯一字符 {
    //链接:https://leetcode-cn.com/problems/first-unique-character-in-a-string/
    //方法一
    public static int firstUniqChar(String s) {
        int result=0;
        for(;result<s.length();result++){
            char x=s.charAt(result);
            if (s.indexOf(x,result+1)==-1&&s.indexOf(x,0)==result){
                return result;
            }
        }
        return -1;
    }
    //方法二
    public static int firstUniqChar1(String s){
        HashMap<Character,Integer> hashMap=new HashMap<>();
        for (int i=0;i<s.length();i++){
            hashMap.put(s.charAt(i),hashMap.getOrDefault(s.charAt(i),0)+1);
        }
        for (int i=0;i<s.length();i++){
            if (hashMap.get(s.charAt(i))==1){
                return i;
            }
        }
        return -1;
    }
}
