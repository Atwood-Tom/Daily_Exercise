import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int solution[][]=new int[x][2];
        int arr[]=new int[x];
        for (int i=0;i<arr.length;i++){
            arr[i]=sc.nextInt();
        }
        Solution(solution,arr);
    }

    private static void Solution(int[][] solution, int[] arr) {
        for (int i=0;i<arr.length;i++){
            int left=i-1;
            int right=i+1;
            for (;left>=0&&arr[left]>arr[i];left--);
            if (left==-1){
                left=-1;
            }
            for (;right<arr.length&&arr[right]>arr[i];right++);
            if (right==arr.length){
                right=-1;
            }
            solution[i][0]=left;
            solution[i][1]=right;
        }
        for (int i=0;i<solution.length;i++){
            System.out.println(solution[i][0]+" "+solution[i][1]);
        }
    }
}
