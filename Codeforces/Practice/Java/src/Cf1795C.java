package src;

import java.util.*;

public class Cf1795C {

    public static int findIdx(long[] b, int idx, long ele, long[] pref) {
        int start = idx, end = b.length - 1, mid, res = idx;
        while (start <= end) {
            mid = (start + end) / 2;
            long sum = pref[mid+1] - pref[idx];
            if (sum <= ele) {
                res = Math.max(res, mid);
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        long sum1 = pref[res+1] - pref[idx];
        if (ele > sum1) {
            res++;
        }
        return res;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long[] a = new long[n];
            long[] b = new long[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextLong();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextLong();
            }
            long[] pref = new long[n+1];
            for (int i = 0; i < n; i++) {
                pref[i+1] = pref[i] + b[i];
            }
            Map<Integer, List<Integer>> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int idx = findIdx(b, i, a[i], pref);
                List<Integer> curr = mp.get(idx);
                if (curr == null) {
                    curr = new ArrayList<>();
                }
                curr.add(i);
                mp.put(idx, curr);
            }
            long[] res = new long[n];
            int currSum = 0;
            for (int i = 0; i < n; i++) {
                currSum++;
                long temp = 0;
                List<Integer> idxList = mp.get(i);
                if (idxList != null) {
                    for (Integer item : idxList) {
                        currSum--;
                        long leftVal = a[item] - (pref[i] - pref[item]);
                        temp += Math.min(b[i], leftVal);
                    }
                }
                temp += b[i] * currSum;
                res[i] = temp;
            }

            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
