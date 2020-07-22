public class 二进制中1的个数 {
    //链接:https://www.nowcoder.com/questionTerminal/8ee967e43c2c4ec193b040ea7fbb10b8
    public int NumberOf1(int n) {
        int sum=0;
        while(n!=0){
            n=n&(n-1);
            sum++;
        }
        return sum;
    }
}
