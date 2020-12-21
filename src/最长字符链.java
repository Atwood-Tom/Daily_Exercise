import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class 最长字符链 {
    //链接:https://leetcode-cn.com/problems/longest-string-chain/
    public int longestStrChain(String[] words) {
        if (words.length==0||words.length==1){
            return words.length;
        }
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });
        int res=0;
        HashMap<String,Integer> hashMap=new HashMap<>();
        for (int i=0;i<words.length;i++){
            if (words[i].length()==1){
                hashMap.put(words[i],1);
                continue;
            }else {
                for (int j=0;j<words[i].length();j++){
                    String helper=words[i].substring(0,j)+words[i].substring(j+1,words[i].length());
                    if (hashMap.containsKey(helper)&&!hashMap.containsKey(words[i])){
                        hashMap.put(words[i],hashMap.get(helper)+1);
                    }else if (hashMap.containsKey(helper)&&hashMap.containsKey(words[i])){
                        hashMap.put(words[i],Math.max(hashMap.get(words[i]),hashMap.get(helper)+1));
                    }
                }
                if (!hashMap.containsKey(words[i])){
                    hashMap.put(words[i],1);
                }
            }
        }
        for (String x:hashMap.keySet()){
            if (hashMap.get(x)>res){
                res=hashMap.get(x);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String []arr=new String[]{"a","b","ba","bca","bda","bdca"};
        最长字符链 x=new 最长字符链();
        System.out.println(x.longestStrChain(arr));
    }
}
