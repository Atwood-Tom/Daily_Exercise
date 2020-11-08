import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class 无重叠区间 {
    //链接:https://leetcode-cn.com/problems/non-overlapping-intervals/
    public static int eraseOverlapIntervals(int[][] intervals) {
        int min=0;
        int right=0;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0]==o2[0]){
                    return o1[1]-o2[1];
                }else {
                    return o1[0]-o2[0];
                }
            }
        });
       for (int i=0;i<intervals.length;i++){
           if (intervals[i][0]>=right){
               right=intervals[i][1];
           }else {
               if (intervals[i][1]<right){
                   right=intervals[i][1];
               }
               min++;
           }
       }
        return min;
    }

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{-100, -25}, {-25, 3}, {3, 4}, {1, 3}}));
    }
}
