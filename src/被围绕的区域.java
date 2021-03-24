public class 被围绕的区域 {
    //链接：https://leetcode-cn.com/problems/surrounded-regions/
    public void solve(char[][] board) {
        if (board.length==0){
            return;
        }
        for (int i=0;i<board.length;i++){
            if (board[i][0]=='O'){
                dfs(i,0,board);
            }
        }
        for (int i=0;i<board.length;i++){
            if (board[i][board[0].length-1]=='O'){
                dfs(i,board[0].length-1,board);
            }
        }
        for (int i=0;i<board[0].length;i++){
            if (board[0][i]=='O'){
                dfs(0,i,board);
            }
        }
        for (int i=0;i<board[0].length;i++){
            if (board[board.length-1][i]=='O'){
                dfs(board.length-1,i,board);
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                if (board[i][j]=='A'){
                    board[i][j]='O';
                }else {
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs(int i, int j, char[][] board) {
        if (i<0||j<0||i>=board.length||j>=board[0].length){
            return;
        }
        if (board[i][j]=='O'){
            board[i][j]='A';
            dfs(i-1,j,board);
            dfs(i+1,j,board);
            dfs(i,j-1,board);
            dfs(i,j+1,board);
        }
    }

    public static void main(String[] args) {
        char[][] arr =new char[2][2];
        arr[0][0]='O';
        arr[0][1]='O';
        arr[1][0]='O';
        arr[1][1]='O';
        被围绕的区域 x=new 被围绕的区域();
        x.solve(arr);
    }
}
