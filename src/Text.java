import java.util.Arrays;

public class Text {
    public static void main(String[] args) {
        int arr[]=new int[]{2,4,6,8,0,1,2,3};
        SolutionC(arr);
        for(int i=1;i<arr.length;i++){
            //有序区间[0,i)
            int v=arr[i];
            int j=i-1;
            for(;j>=0&&arr[j]>v;arr[j+1]=arr[j],j--);
            arr[j+1]=v;
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void SolutionC(int[] arr) {
        mergerSort(arr,0,arr.length);
        Arrays.toString(arr);
    }

    private static void mergerSort(int[] arr, int l, int r) {
        if(l>=r-1){
            return;
        }
        int mid=(l+r)/2;
        mergerSort(arr,l,mid);
        mergerSort(arr,mid,r);
        toOne(arr,l,mid,r);
    }

    private static void toOne(int[] arr, int l, int mid, int r) {
        int x[]=new int[r-l];
        int i=l;
        int j=mid;
        int time=0;
        for(;i<mid&&j<r;time++){
            if(arr[i]<arr[j]){
                x[time]=arr[i];
                i++;
            }else {
                x[time]=arr[j];
                j++;
            }
        }
        while(i<mid){
            x[time++]=arr[i++];
        }
        while(j<r){
            x[time++]=arr[j++];
        }
        for(time=0;time<x.length;time++){
            arr[l+time]=x[time];
        }
    }

    private static void SolutionB(int[] arr) {
        quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void quick(int[] arr, int start, int end) {
        if(start>=end){
            return;
        }
        int val=arr[start];
        int l=start;
        int r=end;
        while(l<r){
            for(;r>l&&arr[r]>=val;r--);
            for(;l<r&&arr[l]<=val;l++);
            swap(arr,l,r);
        }
        swap(arr,start,l);
        quick(arr,start,l-1);
        quick(arr,l+1,end);
    }

    private static void swap(int[] arr, int l, int r) {
        int mid=arr[l];
        arr[l]=arr[r];
        arr[r]=mid;
    }

    private static void SolutionA(int[] arr) {
        for(int i=0;i<arr.length;i++){
            boolean flag=true;
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]<arr[j+1]){
                    int mid=arr[j];
                    arr[j]=arr[j+1];
                    arr[j+1]=mid;
                    flag=false;
                }
            }
            if(flag){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void Solution(int[] arr) {
        int gap=arr.length;
        while(gap>1){
            Helper(arr,gap);
            gap=gap/3+1;
        }
        Helper(arr,1);
        System.out.println(Arrays.toString(arr));
    }

    private static void Helper(int[] arr, int gap) {
        for(int i=gap;i<arr.length;i+=gap){
            //有序区间[0,i)
            int v=arr[i];
            int j=i-1;
            for(;j>=0&&arr[j]>v;arr[j+gap]=arr[j],j--);
            arr[j+1]=v;
        }
    }
}
