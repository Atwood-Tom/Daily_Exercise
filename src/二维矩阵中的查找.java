public class 二维矩阵中的查找 {
    //链接:https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/submissions/
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for(int i=0,j=0;i<matrix.length&&j<matrix[0].length;){
            if (matrix[i][matrix[0].length-1]<target){
                i++;
                continue;
            }
            if (matrix[matrix.length-1][j]<target){
                j++;
                continue;
            }
            for (int x=i,y=j;x<matrix.length&&y<matrix[0].length;x++){
                if (matrix[x][y]==target){
                    return true;
                }
            }
            for (int x=i,y=j;x<matrix.length&&y<matrix[0].length;y++){
                if (matrix[x][y]==target){
                    return true;
                }
            }
            i++;
            j++;
        }
        return false;
    }
}
