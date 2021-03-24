import java.util.Arrays;
import java.util.Scanner;

public class 机器人跳跃问题 {
    //链接:https://www.nowcoder.com/practice/7037a3d57bbd4336856b8e16a9cafd71?tpId=137&&tqId=33901&rp=1&ru=/ta/exam-bytedance&qru=/ta/exam-bytedance/question-ranking
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int[] arr =new int[x];
        int result=0;
        for (int y=0;y<x;y++){
            arr[y]=sc.nextInt();
        }
        for (int y = x-1;y > -1; y--){
            result=(result+arr[y]+1)/2;
        }
        System.out.println(result);
    }
}
