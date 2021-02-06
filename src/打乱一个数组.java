import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class 打乱一个数组 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNextInt()){
            int num=sc.nextInt();
            int arr[]=new int[num];
            for (int i=0;i<num;i++){
                arr[i]=sc.nextInt();
            }
            arr=Solution1(arr);
            Solution2(arr);
            for (int i=0;i<arr.length;i++){
                System.out.print(arr[i]+" ");
            }
            System.out.println();
        }
    }



    //使用Collection.shuffle方法打乱数组
    private static int[] Solution1(int[] arr) {
        ArrayList<Integer> arrayList=new ArrayList<>();
        for (int i=0;i<arr.length;i++){
            arrayList.add(arr[i]);
        }
        Collections.shuffle(arrayList);
        for (int i=0;i<arr.length;i++){
            arr[i]=arrayList.get(i);
        }
        return arr;
    }
    //使用全排列

    private static void Solution2(int[] arr) {
        int res[][]=new int[arr.length][2];
        for (int i=0;i<arr.length;i++){
            res[i][0]=arr[i];
            res[i][1]=0;
        }
        ArrayList<Integer> x=new ArrayList<>();
        Helper(x,res);
    }

    private static void Helper(ArrayList<Integer> x, int[][] res) {
        if (x.size()==res.length){
            for (int i=0;i<x.size();i++){
                System.out.print(x.get(i)+" ");
            }
            System.out.println();
            return;
        }
        for (int i=0;i<res.length;i++){
            if (res[i][1]==0){
                x.add(res[i][0]);
                res[i][1]=1;
                Helper(x,res);
                x.remove(x.size()-1);
                res[i][1]=0;
            }
        }
    }
}
