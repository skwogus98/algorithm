import java.util.*;

public class B11444 {
    static long mod  = 1000000007;
    static Map<Long, Long> memo = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        memo.put(0l, 0l);
        memo.put(1l, 1l);
        memo.put(2l, 1l);
        memo.put(3l, 2l);
        long answer = 0;
        answer = fibo(N);
        System.out.println(Long.valueOf(answer).intValue());
    }
    public static long fibo(long N){
        if (memo.containsKey(N)){
            return memo.get(N);
        }

        long a, b, c;
        if (N % 2 == 1) {
            a = fibo(N / 2 + 1);
            b = fibo(N / 2);
            memo.put(N, ((a % mod) * (a % mod) % mod + (b % mod) * (b % mod) % mod) % mod);
        } else {
            a = fibo(N / 2 + 1);
            b = fibo(N / 2);
            c = fibo(N / 2 - 1);
            memo.put(N, ((a % mod) * (b % mod) % mod + (b % mod) * (c % mod) % mod) % mod);
        }

        return memo.get(N);
    }
}
