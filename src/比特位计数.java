public class 比特位计数 {
    //链接:https://leetcode-cn.com/problems/counting-bits/
    public int[] countBits(int num) {
        int[] result =new int[num+1];
        for (int i=0;i<result.length;i++){
            result[i]=time(i);
        }
        return result;
    }

    private int time(int i) {
        int sum=0;
        while(i!=0){
            i=i&(i-1);
            sum++;
        }
        return sum;
    }
}
