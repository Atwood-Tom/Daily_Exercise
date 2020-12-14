import java.util.*;

public class 合并区间 {
    //链接:https://leetcode-cn.com/problems/merge-intervals/
    public int[][] merge(int[][] intervals) {
        if (intervals.length==0){
            return new int[0][2];
        }
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        List<int[]> res=new ArrayList<>();
        for (int i=0;i<intervals.length;i++){
          int left=intervals[i][0];
          int right=intervals[i][1];
          if (res.size()==0){
              res.add(new int[]{left,right});
          }else if (res.get(res.size()-1)[1]<=left){
              res.add(new int[]{left,right});
          }else if (res.get(res.size()-1)[1]<right){
              res.get(res.size()-1)[1]=right;
          }
        }
        return res.toArray(new int[res.size()][]);
    }

    public static void main(String[] args) {
        合并区间 x=new 合并区间();
        int arr[][]=new int[][]{{1,3},{2,6},{8,10},{15,18}};
        arr=x.merge(arr);
        for (int i=0;i<arr.length;i++){
            System.out.println(arr[i][0]+" "+arr[i][1]);
        }
    }
}
