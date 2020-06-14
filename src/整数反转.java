public class 整数反转 {
    //链接：https://leetcode-cn.com/problems/reverse-integer/
    public int reverse(int x) {
        int y=0;
        for(;x!=0;){
            int tmp = x%10;
            if (y>214748364 || (y==214748364 && tmp>7)) {
                return 0;
            }
            if (y<-214748364 || (y==-214748364 && tmp<-8)) {
                return 0;
            }
            y = y*10 + tmp;
            x /= 10;
        }
        return y;
    }
}
