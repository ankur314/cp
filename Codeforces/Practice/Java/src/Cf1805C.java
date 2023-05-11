package src;

import java.util.*;

public class Cf1805C {

    public static int minVal (long[] ar, long ele) {
        int n = ar.length;
        int start = 0, end = n-1, mid;
        int idx = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (ar[mid] == ele) {
                return mid;
            } else if (ar[mid] < ele) {
                start = mid + 1;
            } else {
                if (idx == -1) {
                    idx = mid;
                } else {
                    idx = Math.min(idx, mid);
                }
                end = mid - 1;
            }
        }
        return idx;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextLong();
            }
            Arrays.sort(ar);
            for (int i = 0; i < m; i++) {
                long a = in.nextLong();
                long b = in.nextLong();
                long c = in.nextLong();

                if (a * c <= 0) {
                    System.out.println("NO");
                    continue;
                }

                double calc = b - 2 * Math.sqrt(a * c);
                long lower = (int)Math.ceil(calc);
                if ((double)lower == calc) {
                    lower++;
                }

                calc = b + 2 * Math.sqrt(a * c);
                long upper = (int)Math.floor(calc);
                if ((double)upper == calc) {
                    upper--;
                }

                int idx = minVal(ar, lower);
                if (idx == -1) {
                    System.out.println("NO");
                    continue;
                }
                long val = ar[idx];
                if (val <= upper) {
                    System.out.println("YES");
                    System.out.println(val);
                } else {
                    System.out.println("NO");
                }
            }
        }
    }
}
