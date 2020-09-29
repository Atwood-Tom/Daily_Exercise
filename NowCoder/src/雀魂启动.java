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
            //注意:若值为4则证明所有的牌已经发完.则不能继续发牌
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
        //遍历 找到雀头
        for (int i=1;i<10;i++){
            int arr[]=Arrays.copyOf(times,times.length);
            //只有值大于等于2的值才可以为雀头
            if (arr[i]>=2){
                //找到雀头后-2;将剩下进行判断检查是否可以凑成4对顺子或刻子
                arr[i]-=2;
                if (helper(arr)){//若成立则返回true
                    return true;
                }
                //回溯
                arr[i]+=2;
            }
        }
        //遍历完没有符合条件的即返回false
        return false;
    }

    private static boolean helper(int[] times) {
        for (int i=1;i<10;i++){
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
        for (int i = 1; i < 10; ++i) {
            if (times[i] != 0) {
                return false;
            }
        }
        return true;
    }
}