package src;

import java.util.*;

public class Cf1815A {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextLong();
            }
            long[] b = new long[n-1];
            if (n % 2 != 0) {
                System.out.println("YES");
                continue;
            }
            for (int i = 0; i < n-1; i++) {
                b[i] = ar[i+1] - ar[i];
            }
            long sum = 0;
            for (int i = 0; i < n-1; i += 2) {
                sum += b[i];
            }
            if (sum >= 0) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
