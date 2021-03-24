import java.util.Arrays;

public class 合并两个有序数组 {
    public void merge(int[] A, int m, int[] B, int n) {
        //链接:https://www.nowcoder.com/practice/89865d4375634fc484f3a24b7fe65665?tpId=188&&tqId=35522&rp=1&ru=/activity/oj&qru=/ta/job-code-high-week/question-ranking
        int[] arr =new int[m+n];
        int i=0;int j=0;int k=0;
        for(;i<m&&j<n;k++){
            if(A[i]>B[j]){
                arr[k]=B[j];
                j++;
            }else{
                arr[k]=A[i];
                i++;
            }
        }
        if(i==m){
            for(;j<n;arr[k]=B[j],j++,k++);
        }
        if(j==n){
            for(;i<m;arr[k]=A[i],i++,k++);
        }
        for (int z=0;z<arr.length;z++){
            A[z]=arr[z];
        }
    }
}
