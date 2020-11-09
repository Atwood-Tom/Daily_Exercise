public class 岛屿数量 {
    //链接:https://leetcode-cn.com/problems/number-of-islands/
    public static int solve (char[][] grid) {
        // write code here
        int sum=0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0;j < grid[0].length; j++){
                if (grid[i][j]=='1'){
                    sum++;
                    clearSurround(grid,i,j);
                }
            }
        }
        return sum;
    }

    private static void clearSurround(char[][] grid, int i, int j) {
        if (i>=grid.length||i<0||j<0||j>=grid[0].length||grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        clearSurround(grid,i+1,j);
        clearSurround(grid,i-1,j);
        clearSurround(grid,i,j+1);
        clearSurround(grid,i,j-1);
    }

    public static void main(String[] args) {
        char x[][]=new char[1][1];
        x[0][0]=1;
        System.out.println(solve(x));
    }
}
