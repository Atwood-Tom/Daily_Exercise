import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class 最长递增子序列 {
    public static int[] LIS (int[] arr) {
        if (arr.length==0){
            return new int[0];
        }
        int maxIndex=0;
        int dp[]=new int[arr.length];
        for (int i=0;i<arr.length;i++){
            dp[i]=1;
            for (int j=0;j<i;j++){
                if (arr[i]>arr[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if (dp[i]>dp[maxIndex]){
                maxIndex=i;
            }else if (dp[i]==dp[maxIndex]&&arr[maxIndex]>arr[i]){
                maxIndex=i;
            }
        }
        int length=dp[maxIndex];
        int result[]=new int[length];
        result[length-1]=arr[maxIndex];
        for (int i=result.length-2;i>-1&&maxIndex>-1;maxIndex--){
            if (arr[maxIndex]<result[i+1]){
                result[i--]=arr[maxIndex];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int arr[]=new int[]{1,5,2,9,8,10};
        System.out.println(Arrays.toString(LIS1(arr)));
    }
    public static int[] LIS1 (int[] arr) {
        int n = arr.length;
// 列表的最大子序列 下标从1开始
        int[] end = new int[n + 1];
// 存储每个元素的最大子序列个数
        int[] dp = new int[n];
        int len = 1;
//子序列的第一个元素默认为数组第一个元素
        end[1] = arr[0];
//第一个元素的最大子序列个数肯定是1
        dp[0] = 1;
        for (int i = 0; i < n; i++) {
            if (end[len] < arr[i]) {
//当arr[i] > end[len] 时 arr[i]添加到 end后面
                end[++len] = arr[i];
                dp[i] = len;
            } else {
// 当前元素小于end中的最后一个元素 利用二分法寻找第一个大于arr[i]的元素
// end[l] 替换为当前元素 dp[]
                int l = 0;
                int r = len;
                while (l <= r) {
                    int mid = (l + r) >> 1;
                    if (end[mid] >= arr[i]) {
                        r = mid - 1;
                    } else l = mid + 1;
                }
                end[l] = arr[i];
                dp[i] = l;
            }
        }

        int[] res = new int[len];
        for (int i = n - 1; i >= 0; i--) {
            if (dp[i] == len) {
                res[--len] = arr[i];
            }
        }
        return res;
    }
}
