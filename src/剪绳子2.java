public class 剪绳子2 {
    public static int cuttingRope(int n) {
        if(n<=3){
            return n-1;
        }
        long max=1;
        int mod=(int) 1e9+7;
        while(n>4){
            max*=3;
            max%=mod;
            n=n-3;
        }
        return (int)(max*n%mod);
    }
}
