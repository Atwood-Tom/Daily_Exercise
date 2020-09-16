public class 矩阵对角线元素的和 {
    //链接:https://leetcode-cn.com/problems/matrix-diagonal-sum/
    public int diagonalSum(int[][] mat) {
        int x=mat[0].length;
        int y=mat.length;
        int j=0;
        int k=y-1;
        int result=0;
        for (;j<x&&k>=0;j++,k--){
            result+=mat[j][j];
            result+=mat[k][j];
        }
        if (x%2!=0){
            return result-mat[x/2][y/2];
        }
        return result;
    }
}
