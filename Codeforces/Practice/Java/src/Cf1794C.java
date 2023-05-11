package src;

import java.util.*;

public class Cf1794C {

    public static int findIdx (int[] ar, int n) {
        int start = 0, end = n, mid;
        int res = n;
        while (start <= end) {
            mid = (start + end) / 2;
            int dist = n - mid + 1;
            if (dist > ar[mid]) {
                start = mid + 1;
            } else {
                res = Math.min(res, mid);
                end = mid - 1;
            }
        }
        return res;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                System.out.print((i - findIdx(ar, i) + 1) + " ");
            }
            System.out.println();
         }
    }
}
