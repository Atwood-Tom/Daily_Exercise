import java.util.ArrayList;
import java.util.List;

public class 查找常用字符 {
    //链接:https://leetcode-cn.com/problems/find-common-characters/
    //方法一
    public static List<String> commonChars1(String[] A) {
        List<String> result=new ArrayList<>();
        for (int i=0;i<A[0].length();i++){
            char mid=A[0].charAt(i);
            int j=1;
            for (;j<A.length;j++){
                int x=A[j].indexOf(mid);
                if (x!=-1){
                    A[j]=A[j].substring(0,x)+A[j].substring(x+1,A[j].length());
                }else {
                    break;
                }
            }
            if (j==A.length){
                String x=String.valueOf(mid);
                result.add(x);
            }
        }
        return result;
    }
    //方法二
    public static List<String> commonChars(String[] A){
        List<String> res=new ArrayList<>();
        int main[]=new int[26];
        for (int i=0;i<A[0].length();i++){
            main[A[0].charAt(i)-'a']++;
        }
        for (int j=1;j<A.length;j++){
            int helper[]=new int[26];
            for (int k=0;k<A[j].length();k++){
                helper[A[j].charAt(k)-'a']++;
            }
            for (int i=0;i<main.length;i++){
                main[i]=Math.min(main[i],helper[i]);
            }
        }
        for (int i=0;i<main.length;i++){
            while(main[i]>0){
                res.add(String.valueOf((char)(i+'a')));
                main[i]--;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String arr[]=new String[]{"cool","lock","cook"};
        List<String> x=commonChars(arr);
        for (String y:x){
            System.out.println(y);
        }
    }
}
