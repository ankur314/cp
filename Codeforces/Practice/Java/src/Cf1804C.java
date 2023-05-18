package src;

import java.util.*;

public class Cf1804C {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int x = in.nextInt();
            int p = in.nextInt();

            long k = n - x;
            if (k == 0) {
                k += n;
            }
            String ans = "NO";
            for (int i = 0; i < 10 * (n+1); i++) {
                long val = (long) Math.sqrt(1 + 8 * k);
                val--;
                if ((val + 1) * (val + 1) == (1 + 8*k) && val % 2 == 0 && (val / 2) <= p) {
                    ans = "YES";
                    break;
                }
                k += n;
            }
            System.out.println(ans);

        }
    }
}
