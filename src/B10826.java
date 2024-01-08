import java.math.BigInteger;
import java.util.*;

public class B10826 {
    static Map<Long, BigInteger> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        memo.put(0L, BigInteger.valueOf(0));
        memo.put(1L, BigInteger.valueOf(1));
        memo.put(2L, BigInteger.valueOf(1));
        memo.put(3L, BigInteger.valueOf(2));
        BigInteger answer;
        answer = fibo(N);
        System.out.println(answer);
    }

    public static BigInteger fibo(long N) {
        if (memo.containsKey(N)) {
            return memo.get(N);
        }

        BigInteger a, b, c;
        if (N % 2 == 1) {
            a = fibo(N / 2 + 1);
            b = fibo(N / 2);
            memo.put(N, a.multiply(a).add(b.multiply(b)));
        } else {
            a = fibo(N / 2 + 1);
            b = fibo(N / 2);
            c = fibo(N / 2 - 1);
            memo.put(N, a.multiply(b).add(b.multiply(c)));
        }

        return memo.get(N);
    }
}
