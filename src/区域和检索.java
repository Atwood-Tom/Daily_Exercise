public class 区域和检索 {
    //链接：https://leetcode-cn.com/problems/range-sum-query-immutable/
    int[] arr;
    public void NumArray(int[] nums) {
        arr=nums;
    }

    public int sumRange(int i, int j) {
        int sum=0;
        for (;i<=j;i++){
            sum+=arr[i];
        }
        return sum;
    }
}
