public class 最长递增子序列 {
    public static void main(String[] args) {
       int arr[]=new int[]{0,1,2,3,4,5,6,7,8,10};
       int find=7;
       int left=0;
       int right=arr.length-1;
       int mid=0;
       while (left<right){
           mid=(left+right)/2;
           if(arr[mid]>find){
               right=mid-1;
           }else if(arr[mid]<find){
               left=mid+1;
           }else {
               break;
           }
       }
        System.out.println(left);
        System.out.println(helper(arr,0,arr.length-1,8));
    }
    public static int helper(int arr[],int l,int r,int find){
        while(l<r){
            int mid=(l+r)/2;
            if(arr[mid]>find){
                r=mid-1;
            }else if(arr[mid]<find){
                l=mid+1;
            }else {
                return mid;
            }
        }
        return l;
    }
}
