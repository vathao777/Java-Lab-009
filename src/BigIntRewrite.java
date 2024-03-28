import java.math.BigInteger;

public class BigIntRewrite {

    public static BigInteger pow(int x, int n) {
        if (n == 0) return BigInteger.ONE;
        // find x to the n/2 recursively
        BigInteger t = pow(x, n / 2);
        // if n is even, the result is t squared
        // if n is odd, the result is t squared times x
        if (n % 2 == 0) {
            return t.multiply(t);
        } else {
            return t.multiply(t).multiply(BigInteger.valueOf(x));
        }
    }

    public static void main(String[] args) {
        int x = 2;
        int n = 10;
        BigInteger result = pow(x, n);
        System.out.println(result);
    }
}
