import java.util.HashMap;
import java.util.Map;

public class TinyURL的加密与解密 {
    //链接：https://leetcode-cn.com/problems/encode-and-decode-tinyurl/
    //方法一：通过MAP结构储存
    Map<Integer,String> mapA=new HashMap<>();
    static Integer num=0;
    //加密
    public String encode1(String longUrl) {
        num++;
        int begin=longUrl.indexOf("//");
        String res=longUrl.substring(begin+2);
        System.out.println(res);
        mapA.put(num,res);
        return longUrl.substring(0,begin)+"//tinyurl.com/"+num;
    }

    //解密
    public String decode1(String shortUrl) {
        int i=shortUrl.lastIndexOf("/");
        i=Integer.parseInt(shortUrl.substring(i+1));
        return shortUrl.substring(0,shortUrl.indexOf("//")+2)+mapA.get(i);
    }



    //方法二：通过hashcode
    Map<Integer, String> map = new HashMap<>();

    public String encode(String longUrl) {
        map.put(longUrl.hashCode(), longUrl);
        return "http://tinyurl.com/" + longUrl.hashCode();
    }

    public String decode(String shortUrl) {
        return map.get(Integer.parseInt(shortUrl.replace("http://tinyurl.com/", "")));
    }


    public static void main(String[] args) {
        TinyURL的加密与解密 x=new TinyURL的加密与解密();
        String res=x.encode(" https://leetcode.com/problems/design-tinyurl");
        System.out.println(res);
        System.out.println(x.decode(res));
    }
}