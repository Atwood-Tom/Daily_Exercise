public class 子数组最大累加和问题 {
    //链接：https://www.nowcoder.com/practice/554aa508dd5d4fefbf0f86e5fe953abd?tpId=117&tab=answerKey
    public int maxsumofSubarray (int[] arr) {
        int res=0;
        int sum=0;
        for(int i=0;i<arr.length;i++){
            sum+=arr[i];
            res=Math.max(res,sum);
            if(sum<0){
                sum=0;
            }
        }
        return res;
    }
}
