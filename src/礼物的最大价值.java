public class 礼物的最大价值 {
    //礼物的最大价值
    //链接:https://leetcode-cn.com/problems/li-wu-de-zui-da-jie-zhi-lcof/
    public int maxValue(int[][] grid) {
        int x,y;
        x=grid.length;
        y=grid[0].length;
        for (int i=0;i<x;i++){
            for (int j=0;j<y;j++){
                if (i==0&&j==0){
                    continue;
                } else if (i==0&&j>0){
                    grid[i][j]=grid[i][j]+grid[i][j-1];
                } else if (i>0&&j==0){
                    grid[i][j]+=grid[i-1][j];
                }else {
                    grid[i][j]+=Math.max(grid[i][j-1],grid[i-1][j]);
                }
            }
        }
        return grid[x-1][y-1];
    }
}
