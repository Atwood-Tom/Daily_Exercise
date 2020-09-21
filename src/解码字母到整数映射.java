import java.util.HashMap;

public class 解码字母到整数映射 {
    //链接:https://leetcode-cn.com/problems/decrypt-string-from-alphabet-to-integer-mapping/
    //方法一:
    public static String freqAlphabets(String s) {
        char arr[]=s.toCharArray();
        HashMap<String,Character> hashMap=new HashMap<>();
        char x='a';
        for (int i=1;i<=26;i++,x++){
            hashMap.put(""+i,x);
        }
        StringBuffer sb=new StringBuffer();
        for (int i=arr.length-1;i>-1;){
            if (arr[i]=='#'){
                String newstring=""+arr[i-2]+arr[i-1];
                sb.append(hashMap.get(newstring));
                i-=3;
            }else {
                sb.append(hashMap.get(""+s.charAt(i)));
                i--;
            }
        }
        return reverse(sb.toString());
    }
    private static String reverse(String ans) {
        char[] res = ans.toCharArray();
        int left = 0;
        int right = ans.length() - 1;
        while(left < right){
            char temp = res[left];
            res[left] = res[right];
            res[right] = temp;
            left++;
            right--;
        }
        return String.valueOf(res);
    }
    //方法二:
    public String freqAlphabets2(String s) {
        int len=s.length();
        String res="";
        char sb[]=s.toCharArray();
        for (int i = 0; i <sb.length ;) {
            if(len-i>2 && sb[i+2]=='#'){
                int c=(sb[i]-'0')*10+(sb[i+1]-'0');
                res+=(char)(c+96);
                i=i+3;
            }else{
                int c=sb[i]-'0';
                res+=(char)(c+96);
                i=i+1;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        String s="10#11#12";
        System.out.println(freqAlphabets(s));
    }
}
