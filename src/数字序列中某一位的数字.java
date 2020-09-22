public class 数字序列中某一位的数字 {
    //链接:https://leetcode-cn.com/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof/
    public int findNthDigit(int n) {
        if(n<0) return 0;
        else if(n>=0 && n<=9) return n;
        else {
            long m = n;
            long temp = 0;
            long base = 1;
            long num = 9;
            char res = '0';
            while((temp+base*num) < m) {
                temp += base*num;
                base += 1;
                num *= 10;
            }
            long a = (m-temp)/base;
            long b = (m-temp)%base;
            if(b!=0) {
                long c = (long) (Math.pow(10, base-1) + a);
                res = String.valueOf(c).charAt((int)b-1);
            }else {
                long c = (long) (Math.pow(10, base-1) + a - 1);
                res = String.valueOf(c).charAt((int)base-1);
            }
            return Integer.parseInt(String.valueOf(res));
        }
    }
}
