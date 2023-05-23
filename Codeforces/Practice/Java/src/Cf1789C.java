package src;

import java.util.*;

public class Cf1789C {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int M = m+1;
            Map<Integer, Long> mp = new HashMap<>();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                mp.put(a[i], (long)M);
            }
            while (m-- > 0) {
                int pos = in.nextInt();
                int val = in.nextInt();
                pos--;
                long curr = mp.get(a[pos]);
                mp.put(a[pos], curr - (m+1));
                if (mp.get(val) != null) {
                    mp.put(val, mp.get(val) + (m+1));
                } else {
                    mp.put(val, (long)(m+1));
                }
                a[pos] = val;
            }
            long ans = 0;
            for (Integer key : mp.keySet()) {
                Long val = mp.get(key);
                ans += ((M - val) * val) + ((val * (val - 1)) / 2);
            }
            System.out.println(ans);
        }
    }
}
