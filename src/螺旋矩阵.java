import java.util.ArrayList;
import java.util.List;
public class 螺旋矩阵 {
    //链接:https://leetcode-cn.com/problems/spiral-matrix/
    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<Integer>();
        int i=matrix.length;
        int j=matrix[0].length;
        //定义上下左右边界
        int up=0;
        int down=i-1;
        int left=0;
        int right=j-1;
        while(true){
            for (int x=left;x<=right;x++){
                res.add(matrix[up][x]);
            }
            up++;
            if (up>down){
                break;
            }
            for (int x=up;x<=down;x++){
                res.add(matrix[x][right]);
            }
            right--;
            if (right<left){
                break;
            }
            for (int x=right;x>=left;x--){
                res.add(matrix[down][x]);
            }
            down--;
            if (down<up){
                break;
            }
            for (int x=down;x>=up;x--){
                res.add(matrix[x][left]);
            }
            left++;
            if (left>right){
                break;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int arr[][]=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        System.out.println(spiralOrder(arr));
    }
}
