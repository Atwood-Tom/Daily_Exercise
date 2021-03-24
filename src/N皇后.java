import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class N皇后 {
    //链接：https://leetcode-cn.com/problems/n-queens/
    public static List<List<String>> solveNQueens(int n) {
        String[][] checkerboard =new String[n][n];
        for (int i=0;i<n;i++){
            for (int j=0;j<n;j++){
                checkerboard[i][j]="Q";
            }
        }
        List<List<String>> res=new ArrayList<>();
        Solution(res,checkerboard,0);
        return res;
    }


    private static void Solution(List<List<String>> res, String[][] checkerboard, int row) {
        if (row==checkerboard.length){
            toAdd(res,checkerboard);
            return;
        }
        for (int i=0;i<checkerboard.length;i++){
            if (checkerboard[row][i].equals("Q")){
                String[][] a =new String[checkerboard.length][checkerboard.length];
                for (int x=0;x<checkerboard.length;x++){
                    for (int y=0;y<checkerboard.length;y++){
                        a[x][y]=checkerboard[x][y];
                    }
                }
                //落子，将对角线，行，列的Q换成.
                for (int x=row+1,y=i+1;x>=0&&x<checkerboard.length&&y<checkerboard.length&&y>=0;a[x][y]=".",x++,y++);
                for (int x=row+1,y=i-1;x>=0&&x<checkerboard.length&&y<checkerboard.length&&y>=0;a[x][y]=".",x++,y--);
                for (int x=0;x<checkerboard.length;x++){
                    if (x==i){
                        continue;
                    }
                    a[row][x]=".";
                }
                for (int x=0;x<checkerboard.length;x++){
                    if (x==row){
                        continue;
                    }
                    a[x][i]=".";
                }
                Solution(res,a,row+1);
            }
        }
    }

    private static void toAdd(List<List<String>> res, String[][] checkerboard) {
        List<String> help=new ArrayList<>();
        for (int i=0;i<checkerboard.length;i++){
            String x = "";
            for (int j=0;j<checkerboard.length;j++){
                x=x+checkerboard[i][j];
            }
            help.add(x);
        }
        res.add(help);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            List<List<String>> res=solveNQueens(sc.nextInt());
            Printf(res);
        }
    }

    private static void Printf(List<List<String>> res) {
        for (int i=0;i<res.size();i++){
            System.out.println("-------------"+i+"---------------");
            List<String> x=res.get(i);
            for (int j=0;j<x.size();j++){
                System.out.println(x.get(j));
            }
        }
    }
}
