import java.util.Scanner;

public class 字符串中找出连续最长的数字串 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String s=sc.nextLine();
            if (s.length()==0){
                System.out.println();
                continue;
            }
            String res=Solution(s);
            System.out.println(res);
        }
    }

    private static String Solution(String s) {
        String res="";
        int start=0;
        int end=0;
        for (int i=0;i<s.length();){
            if (s.charAt(i)>'9'||s.charAt(i)<'0'){
                end++;
                start++;
                i++;
            }else {
                for (;end<s.length();end++){
                    if (end+1<s.length()&&s.charAt(end)+1!=s.charAt(end+1)){
                        break;
                    }
                }
                if (end-start>res.length()&&end!=s.length()){
                    res=s.substring(start,end+1);
                }else if (end-start>res.length()){
                    res=s.substring(start,end);
                }
                end++;
                start=end;
                i=end;
            }
        }
        return res;
    }
}
