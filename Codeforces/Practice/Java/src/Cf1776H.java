package src;

import java.util.*;

public class Cf1776H {

    public static boolean check (int[] a, int[] b, int mid) {
        int n = a.length;
        int idx = 0;
        for (int i = mid; i < n; i++) {
            while (idx < n && a[idx] != b[i]) {
                idx++;
            }
            if (idx >= n || a[idx] != b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }

            int start = 0, end = n-1, mid, res = n-1;
            while (start <= end) {
                mid = (start + end) / 2;
                if (check(a, b, mid)) {
                    res = Math.min(res, mid);
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println(res);
        }
    }
}
