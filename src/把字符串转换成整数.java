public class 把字符串转换成整数 {
    //链接:https://leetcode-cn.com/problems/ba-zi-fu-chuan-zhuan-huan-cheng-zheng-shu-lcof/
    public int strToInt(String str) {
        str = str.trim();
        char[] chars = str.toCharArray();

        int res = 0;
        int sign = 1;
        int index = 0;
        int MAX = Integer.MAX_VALUE / 10;

        if (chars.length <= 0) {
            return 0;
        }

        if (chars[0] == '-') {
            sign = -1;
            index++;
        }

        for (; index < chars.length; index++) {
            char curChar = chars[index];
            if (curChar < '0' || curChar > '9') {
                break;
            }
            if (res > MAX || (res == MAX && curChar>'7')) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            res = res * 10 + curChar - '0';
        }

        return sign * res;
    }
}
