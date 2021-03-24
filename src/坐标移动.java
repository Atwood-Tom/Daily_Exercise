import java.util.Arrays;
import java.util.Scanner;

public class 坐标移动 {
    //链接:https://www.nowcoder.com/questionTerminal/119bcca3befb405fbe58abe9c532eb29?toCommentId=427807
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext()){
            String[] arr =sc.nextLine().split(";");
            String end=Solution(arr);
            System.out.println(end);
        }
    }

    private static String Solution(String[] arr) {
        int x=0,y=0;
        String end="";
        for (int i=0;i<arr.length;i++){
            if (arr[i].equals("")){
                continue;
            }
            String add=arr[i].substring(1);
            if (!Check(add)){
                continue;
            }else {
                int move=Integer.parseInt(add);
                if (arr[i].charAt(0)=='W'){
                    y+=move;
                } else if (arr[i].charAt(0)=='S'){
                    y-=move;
                } else if (arr[i].charAt(0)=='A'){
                    x-=move;
                } else if (arr[i].charAt(0)=='D'){
                    x+=move;
                }
            }
        }
        end=end+x+","+y;
        return end;
    }

    private static boolean Check(String add) {
        if (add.equals("")){
            return false;
        }
        for (int j=0;j<add.length();j++){
            if (add.charAt(j)<'0'||add.charAt(j)>'9'){
               return false;
            }
        }
        return true;
    }
}
