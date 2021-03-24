public class 三步问题 {
    //链接：https://leetcode-cn.com/problems/three-steps-problem-lcci/
    public int waysToStep(int n) {
        int[] arr =new int[1000000];
        arr[0]=1;
        arr[1]=2;
        arr[2]=4;
        arr[3]=7;
        if (n<=4){
            return arr[n-1]%1000000007;
        }
        for (int i=4;i<n;i++){
            arr[i]=(arr[i-1]+(arr[i-2]+arr[i-3])%1000000007)%1000000007;
        }
        return arr[n-1];
    }
}
