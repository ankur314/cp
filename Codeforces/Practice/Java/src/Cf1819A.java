package src;

import java.util.*;

public class Cf1819A {

    public static int mex(int[] ar) {
        int[] tempAr = ar.clone();
        int n = tempAr.length;
        Arrays.sort(tempAr);;
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (tempAr[i] == res) {
                res++;
            }
        }
        return res;
    }

    public static boolean isPresent(int[] ar, int ele) {
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == ele) {
                return true;
            }
        }
        return false;
    }

    public static void handlePresentCase(int[] ar, int ele) {
        int left = -1, right = -1;
        for (int i = 0; i < ar.length; i++) {
            if (ar[i] == ele) {
                right = i;
                if (left == -1) {
                    left = i;
                }
            }
        }
        for (int i = left; i <= right; i++) {
            ar[i] = ele - 1;
        }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] ar = new int[n];
            int maxEle = 0;
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
                maxEle = Math.max(maxEle, ar[i]);
            }
            int m = mex(ar);
            String ans = "No";
            if (isPresent(ar, m + 1)) {
                handlePresentCase(ar, m + 1);
                if (mex(ar) == m + 1) {
                    ans = "Yes";
                }
            } else {
                if (maxEle > m + 1) {
                    ans = "Yes";
                } else {
                    if (n > m) {
                        ans = "Yes";
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
