package src;

import java.util.*;

public class Cf1807E {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            int[] pref = new int[n+1];
            for (int i = 0; i < n; i++) {
                pref[i+1] = pref[i] + a[i];
            }
            int start = 0, end = n-1, mid;
            while (start < end) {
                mid = (start + end) / 2;
                int leftSum = pref[mid + 1] - pref[start];
                System.out.print("? " + (mid - start + 1));
                for (int i = start; i <= mid; i++) {
                    System.out.print(" " + (i + 1));
                }
                System.out.println();
                System.out.flush();
                int leftWt = in.nextInt();

                if (leftWt > leftSum) {
                    end = mid;
                } else {
                    start = mid + 1;
                }
            }
            System.out.println("! " + (start + 1));
            System.out.flush();
        }
    }
}
