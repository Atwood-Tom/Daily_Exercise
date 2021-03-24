public class 单词搜索 {
    //链接:https://leetcode-cn.com/problems/word-search/
    public boolean exist(char[][] board, String word) {
        char[][][] helper =new char[board.length][board[0].length][2];
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                char mid=board[i][j];
                helper[i][j][0]=mid;
                helper[i][j][1]='0';
            }
        }
        for (int i=0;i<board.length;i++){
            for (int j=0;j<board[0].length;j++){
                int time=0;
                if (Solution(helper,i,j,time,word,board.length,board[0].length)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean Solution(char[][][] board,int i, int j, int time, String word,int xlength,int ylength) {
        if (time>=word.length()){
            return true;
        }else if (i<0||j<0||i>=xlength||j>=ylength){
            return false;
        }else if (board[i][j][1]=='*'){
            return false;
        }
        if (board[i][j][0]==word.charAt(time)){
            board[i][j][1]='*';
           if (Solution(board,i+1,j,time+1,word,xlength,ylength)||
                   Solution(board,i-1,j,time+1,word,xlength,ylength)||
                   Solution(board,i,j+1,time+1,word,xlength,ylength)||
                   Solution(board,i,j-1,time+1,word,xlength,ylength)){
               return true;
           }
           board[i][j][1]='0';
        }
        return false;
    }

    public static void main(String[] args) {
        单词搜索 x=new 单词搜索();
        System.out.println(x.exist(new char[][]{{'a'}},"a"));
    }
}
