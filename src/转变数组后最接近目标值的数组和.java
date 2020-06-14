import java.util.Arrays;

public class 转变数组后最接近目标值的数组和 {
    public static int findBestValue(int[] arr, int target) {
        Arrays.sort(arr);
        int min=Integer.MAX_VALUE;
        int j=0;
        for (int i=0;i<=target;i++){
            int x=helper(arr,target,i);
            if (x-target<=0){
                x=-1*(x-target);
            }else {
                x=x-target;
            }
            if (x<min){
                min=x;
                j=i;
            }
        }
        return j;
    }

    private static int helper(int[] arr, int target, int i) {
        int sum=0;
        for (int j=0;j<arr.length;j++){
            if (arr[j]<=i){
                sum+=arr[j];
            }else {
                sum=sum+(arr.length-j)*i;
                break;
            }
        }
        return sum;
    }

    public static int findBestValue2(int[] arr, int target) {
        Arrays.sort(arr);
        int len=arr.length;
        for(int i=0;i<len;i++){
            if(arr[i]*(len-i)>target){
                int ans=target/(len-i);
                return Math.abs(ans*(len-i)-target)>Math.abs((ans+1)*(len-i)-target)?ans+1:ans;
            }
            else{
                target-=arr[i];
            }
        }
        return arr[len-1];
    }
    public static void main(String[] args) {
        int arr[]=new int[]{4,9,3};
        int x=findBestValue(arr,10);
        System.out.println(x);
    }
}
