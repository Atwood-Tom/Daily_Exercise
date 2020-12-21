import java.math.BigInteger;

public class 斐波那契数列最大公约数 {
    /**
     *斐波那契数列满足F1=F2=1,从F3开始有Fn=Fn-1+Fn-2,请你计算
     * GCD(F2020,F520),其中gcd(a,b)表示a,b的最大公约数
     */
    public static void main(String[] args) {
        BigInteger F520 = BigInteger.ZERO;
        BigInteger F1 = BigInteger.ONE, F2 = BigInteger.ONE, F3 = BigInteger.ZERO;
        for (int i = 3; i <= 2020; i++) {
            F3 = F1.add(F2);
            F1 = F2;
            F2 = F3;
            if (i == 520) F520 = F3;
        }
        System.out.println(gcd(F3, F520));
    }

    static BigInteger gcd (BigInteger a, BigInteger b) {
        return b.compareTo(BigInteger.ZERO) == 0? a: gcd(b, a.mod(b));
    }
}
