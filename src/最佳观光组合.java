public class 最佳观光组合 {
    //链接：https://leetcode-cn.com/problems/best-sightseeing-pair/
    //暴力法:超出时间限制
    public int maxScoreSightseeingPair(int[] A) {
        int sum=0;
        for (int i=0;i<A.length-1;i++){
            for (int j=i+1;j<A.length;j++){
                if (A[i]+A[j]+i-j>sum){
                    sum=A[i]+A[j]+i-j;
                }
            }
        }
        return sum;
    }
    //枚举
    public int maxScoreSightseeingPair2(int[] A){
        int end=0;
        int max=A[0]+0;
        for (int i=1;i<A.length;i++){
            if (end<max+A[i]-i){
                end=max+A[i]-i;
            }
            if (max<A[i]+i){
                max=A[i]+i;
            }
        }
        return end;
    }
}
