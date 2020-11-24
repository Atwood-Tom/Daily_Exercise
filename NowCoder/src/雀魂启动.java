import java.util.Arrays;
import java.util.Scanner;

public class 雀魂启动 {
    //链接:https://www.nowcoder.com/practice/448127caa21e462f9c9755589a8f2416?tpId=137&&tqId=33897&rp=1&ru=/ta/exam-bytedance&qru=/ta/exam-bytedance/question-ranking
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String x[]=sc.nextLine().split(" ");
        int arrays[]=new int[x.length];
        int times[]=new int[10];
        for (int i=0;i<x.length;i++){
            arrays[i]=Integer.parseInt(x[i]);
            times[arrays[i]]+=1;
        }
        Solution(times);
    }

    private static void Solution(int[] times) {
        int result[]=new int[15];
        int j=0;
        for (int i=1;i<times.length;i++){
            //1~9依次++;
            //并判断是否成立,若成立保存至数组中
            int arr[]=Arrays.copyOf(times,times.length);
            if (times[i]==4){
                continue;
            }
            arr[i]++;
            if (judge(arr)){
                result[j++]=i;
            }
            arr[i]--;
        }
        //完成遍历后输出答案
        //若没有符合条件则输出0
        if (j==0){
            System.out.println(0);
        }
        for (int k=0;k<j;k++){
            if (k==j-1){
                System.out.println(result[k]);
            }else {
                System.out.print(result[k]+" ");
            }
        }
    }
    private static boolean judge(int[] times) {
        for (int i=1;i<times.length;i++){
            int arr[]=Arrays.copyOf(times,times.length);
            if (arr[i]>=2){
                arr[i]-=2;
                if (helper(arr)){
                    return true;
                }
                arr[i]+=2;
            }
        }
        return false;
    }

    private static boolean helper(int[] times) {
        for (int i=1;i<times.length;i++){
            if (times[i]>=3){
                times[i]-=3;
                if (helper(times)){
                    return true;
                }
                times[i]+=3;
            }
        }
        for (int i = 1; i <= 7; ++i) {
            while (times[i] >= 1) {
                --times[i];
                --times[i + 1];
                --times[i + 2];
            }
        }
        for (int i = 1; i <= 9; ++i) {
            if (times[i] != 0) {
                return false;
            }
        }
        return true;
    }
}
