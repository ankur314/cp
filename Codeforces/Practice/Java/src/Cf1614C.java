package src;

import java.util.*;

public class Cf1614C {

    static long MOD = 1000_000_007L;

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        long[] pow = new long[200005];
        pow[0] = 1;
        for (int i = 1; i < 200005; i++) {
            pow[i] = (pow[i-1] * 2L) % MOD;
        }
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();

            long cum_or = 0L;
            int l = in.nextInt();
            int r = in.nextInt();
            long x = in.nextLong();
            cum_or = (cum_or|x);
            long ans = (pow[n-1] * cum_or) % MOD;
            System.out.println(ans);
        }
    }
}
