import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] arr =new int[]{5,5,5,5,5};
        System.out.println(Arrays.toString(arr));
        //插入排序
        System.out.print("插入排序:");
        int[] result1 =arr.clone();
                result1=insertSort(arr);
        System.out.println(Arrays.toString(result1));
        //选择排序
        System.out.print("选择排序:");
        int[] result2 =arr.clone();
                result2=selectSort(arr);
        System.out.println(Arrays.toString(result2));
        //堆排序
        System.out.print(" 堆排序:");
        int[] result3 =arr.clone();
                result3=heapSort(arr);
        System.out.println(Arrays.toString(result3));
        //希尔排序
        System.out.print("希尔排序:");
        int[] result4 =arr.clone();
            result4=shellSort(arr);
        System.out.println(Arrays.toString(result4));
        //快速排序
        System.out.print("快速排序:");
        int[] result5 =arr.clone();
        quickSort(result5);
        System.out.println(Arrays.toString(result5));
        //正确答案
        System.out.print("正确答案:");
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    //快速排序
    private static void quickSort(int[] arr) {
        partition(arr,0,arr.length-1);
    }

    private static void partition(int[] arr, int start, int end) {
        if (start>=end){
            return;
        }
        int value=arr[start];
        int mintime=0;
        int x=start+1;
        int y=end;
        while(x<y){
            for (;x<y&&arr[x]<=value;x++,mintime++);
            for (;x<y&&arr[y]>value;y--);
            if (x==y){
                break;
            }else {
                int mid=arr[x];
                arr[x]=arr[y];
                arr[y]=mid;
            }
        }
        arr[start]=arr[mintime+start];
        arr[start+mintime]=value;
        partition(arr,start,start+mintime-1);
        partition(arr,start+mintime+1,end);
    }

    //堆排序
    private static int[] heapSort(int[] arr) {
       creatHeap(arr);
       for (int i=0;i<arr.length;i++){
           swap(arr,0,arr.length-i-1);
           shiftdown(arr,arr.length-i-2,0);
       }
       return arr;
    }

    private static void swap(int[] arr, int i, int j) {
       int mid=arr[i];
       arr[i]=arr[j];
       arr[j]=mid;
    }

    private static void creatHeap(int[] arr) {
        for (int i=(arr.length-1)/2;i>=0;i--){
            shiftdown(arr,arr.length,i);
        }
    }

    private static void shiftdown(int[] arr, int size, int index) {
        while(2*index+1<size){
            int maxIndex=2*index+1;
            if (maxIndex+1<size&&arr[maxIndex+1]>arr[maxIndex]){
                maxIndex++;
            }
            if (arr[maxIndex]<=arr[index]){
                break;
            }

            swap(arr,maxIndex,index);

            index=maxIndex;
        }
    }

    //选择排序
    private static int[] selectSort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            //有序区间[0,i)
            int min=i;
            for (int j=i+1;j<arr.length;j++){
                if (arr[min]>arr[j]){
                    min=j;
                }
            }
            int mid=arr[min];
            arr[min]=arr[i];
            arr[i]=mid;
        }
        return arr;
    }

    //插入排序
    private static int[] insertSort(int[] arr) {
        for (int i=1;i<arr.length;i++){
            //有序区间:[0,i)
            int j=i-1;
            int value=arr[i];
            for (;j>-1&&arr[j]>value;j--){
                arr[j+1]=arr[j];
            }
            arr[j+1]=value;
        }
        return arr;
    }
    //希尔排序
    private static int[] insertSort(int[] arr,int gap){
        for (int i=gap;i<arr.length;i++){
            int value=arr[i];
            int j=i-gap;
            for (;j>=0&&arr[j]>value;j-=gap){
                arr[j+gap]=arr[j];
            }
            arr[j+gap]=value;
        }
        return arr;
    }
    private static int[] shellSort(int[] arr) {
        int gap=arr.length;
        for (;gap>1;gap=gap/3+1){
            insertSort(arr,gap);
        }
        insertSort(arr,1);
        return arr;
    }
}
