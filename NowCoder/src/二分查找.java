public class 二分查找 {
    //链接:https://www.nowcoder.com/practice/7bc4a1c7c371425d9faa9d1b511fe193?tpId=188&&tqId=35513&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
    public int upper_bound_ (int n, int v, int[] a) {
        if(a[n-1]<v){
            return n+1;
        }
        int left=0;
        int right=n-1;
        int result=0;
        while(left<right){
            int mid=(left+right)/2;
            if (a[mid]>v){
                right=mid-1;
            }else if (a[mid]<v){
                left=mid+1;
            }else {
                for (int i=mid;i>-1;i--){
                    if (a[mid]==a[i]){
                        result=i;
                    }
                }
                return result+1;
            }
        }
        result=a[left]>=v?left:right;
        return result+1;
    }
}
