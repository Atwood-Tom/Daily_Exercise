import java.util.Scanner;
//链接:https://leetcode-cn.com/problems/largest-rectangle-in-histogram/
public class 柱状图中最大的矩形 {
    //暴力法解决
    public static int MAX(int[] heights, int max, int i){
        int width=1;
        int height=heights[i];
        for (int j=i+1;j>=0&&j<heights.length;j++){
            if (height<=heights[j]){
                width++;
            }else {
                break;
            }
        }
        for (int j=i-1;j>=0&&j<heights.length;j--){
            if (height<=heights[j]){
                width++;
            }else {
                break;
            }
        }
        if (width*heights[i]>max){
            max=width*height;
        }
        return max;
    }
    public static int largestRectangleArea(int[] heights) {
        int max=0;
        for (int i=0;i<heights.length;i++){
            if (heights[i]==0){
                continue;
            }
            max=MAX(heights,max,i);
            if (i+1<heights.length&&heights[i]>heights[i+1]){
                int mid=heights[i];
                heights[i]=heights[i+1];
                max=MAX(heights,max,i);
                heights[i]=mid;
            }
            if (i-1>=0&&heights[i-1]<heights[i]){
                int mid=heights[i];
                heights[i]=heights[i-1];
                max=MAX(heights,max,i);
                heights[i]=mid;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s =sc.nextLine().split(" ");
        int[] arr =new int[s.length];
        for (int i=0;i<s.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        int max=largestRectangleArea(arr);
        System.out.println(max);
    }
}
