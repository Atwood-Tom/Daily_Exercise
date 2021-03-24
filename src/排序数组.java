import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class 排序数组 {
    //插入排序
    public static List<Integer> insertSort(int[] arr) {
        //待插入区间[0,i)
        for(int i=1;i<arr.length;i++){
            int find=arr[i];
            int j=i-1;
            for (;j>-1&&arr[j]>find;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=find;
        }
        return CreatList(arr);
    }
    //希尔排序
    public static List<Integer> shellSort(int[] arr){
        for (int i=arr.length;i>1;i=i/3+1){
            insertSortGroup(arr,i);
        }
        insertSortGroup(arr,1);
        return CreatList(arr);
    }
    public static  void insertSortGroup(int[] arr, int group){
        for (int i=group;i<arr.length;i++){
            int j=i-group;
            int find=arr[i];
            for (;j>=0&&arr[j]>find;j=j-group){
                arr[j+group]=arr[j];
            }
            arr[group+j]=find;
        }
    }
    //选择排序
    public static List<Integer> selectSort(int[] arr){
        //有序区间[arr.length-i,arr.length)
        for(int i=0;i<arr.length;i++){
            //无序区间[0,arr.length)
            int max=0;
            for(int j=0;j<arr.length-i;j++){
                if (arr[j]>arr[max]){
                    max=j;
                }
            }
            int mid=arr[max];
            arr[max]=arr[arr.length-i-1];
            arr[arr.length-i-1]=mid;
        }
        return CreatList(arr);
    }
    public static List<Integer> CreatList(int[] arr){
        List<Integer> array=new LinkedList<>();
        for (int i=0;i<arr.length;i++){
            array.add(arr[i]);
        }
        return array;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String[] s =sc.nextLine().split(",");
        int[] arr =new int[s.length];
        for (int i=0;i<arr.length;i++){
            arr[i]=Integer.parseInt(s[i]);
        }
        System.out.println(Arrays.toString(arr));
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
