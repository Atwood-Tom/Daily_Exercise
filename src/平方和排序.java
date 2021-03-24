import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 *  平方和排序
 *     输入int类型范围内的N个非负整数，要求按各个整数的各数位上数字的平方和从小到大排序，若平方和相等则按数值从小到大排序。
 *     例如，三个整数9，31，13，各数位上数字的平方和分别为81、10、10，则排序结果为 13、31、9
 */
public class 平方和排序 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int nums=sc.nextInt();
            int[][] arr =new int[nums][2];
            for (int i=0;i<nums;i++){
                arr[i][0]=sc.nextInt();
                arr[i][1]=squares(arr[i][0]);
            }
            Arrays.sort(arr, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    if (o1[1]==o2[1]){
                        return o1[0]-o2[0];
                    }
                    return o1[1]-o2[1];
                }
            });
            for (int i=0;i<arr.length;i++){
                System.out.println(arr[i][0]);
            }
        }
    }

    private static int squares(int x) {
        int res=0;
        for (;x>0;x=x/10){
            res+=(x%10)*(x%10);
        }
        return res;
    }
}
