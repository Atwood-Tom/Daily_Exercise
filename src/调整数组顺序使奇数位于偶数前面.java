import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 调整数组顺序使奇数位于偶数前面 {
    //链接:https://www.nowcoder.com/questionTerminal/beb5aa231adc45b2a5dcc5b62c93f593
    //用空间换时间
    public static void reOrderArrayb(int [] array) {
       int arr[]=new int[array.length];
       int j=0;
       for (int i=0;i<array.length;i++){
           if (array[i]%2==1){
               arr[j++]=array[i];
           }
       }
        for (int i=0;i<array.length;i++){
            if (array[i]%2==0){
                arr[j++]=array[i];
            }
        }
        for (int i=0;i<arr.length;array[i]=arr[i],i++);
    }
    //插入排序
    
    public static void reOrderArraya(int [] array){
        for (int i=0;i<array.length;i++){
            if (array[i]%2==1){
                continue;
            }
            int j=i+1;
            for (;j<array.length&&array[j]%2!=1;j++);
            if (array.length==j){
                break;
            }
            int mid=array[j];
            for (int z=j;z>i;array[z]=array[z-1],z--);
            array[i]=mid;
        }
    }
}
