import java.util.Scanner;

public class 机器人走方格 {
    public static int countWays(int x, int y) {
        // write code here
        if (x+y>12){
            return 0;
        }
        int arr[][]=new int[x][y];
        for (int j=0;j<y;j++){
            arr[0][j]=1;
        }
        for (int j=0;j<x;j++){
            arr[j][0]=1;
        }
        for (int i=1;i<x;i++){
            for (int j=1;j<y;j++){
                arr[i][j]=arr[i-1][j]+arr[i][j-1];
            }
        }
        return arr[x-1][y-1];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            countWays(sc.nextInt(),sc.nextInt());
        }
    }
}
