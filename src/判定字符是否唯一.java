import java.util.HashSet;
import java.util.Set;

public class 判定字符是否唯一 {
    //链接:https://leetcode-cn.com/problems/is-unique-lcci/
    public boolean isUnique(String astr) {
        Set<Character> set=new HashSet<>();
        for (int i=0;i<astr.length();i++){
            if (!set.add(astr.charAt(i))){
                return false;
            }
        }
        return true;
    }
}
