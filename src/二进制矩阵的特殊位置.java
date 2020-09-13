public class 二进制矩阵的特殊位置 {
    //链接:https://leetcode-cn.com/contest/weekly-contest-206/problems/special-positions-in-a-binary-matrix/
    public int numSpecial1(int[][] mat) {
        //存储行和列的和
        int[] rows=new int[mat.length];
        int[] cols=new int[mat[0].length];
        int cut=0;
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                rows[i]+=mat[i][j];
                cols[j]+=mat[i][j];
            }
        }
        for(int i=0;i<mat.length;i++){
            for(int j=0;j<mat[0].length;j++){
                //当前为1并且行列和均为1，即可确定是特殊位置
                if(mat[i][j]==1 && rows[i]==1 && cols[j]==1 ) {
                    cut++;
                    //一行不存在两个特殊位置
                    break;
                }
            }
        }
        return cut;
    }
}
