package src;

import java.util.*;

public class Cf1810C {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            long c = in.nextLong();
            long d = in.nextLong();
            long[] ar = new long[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            Arrays.sort(ar);
            long ans = Long.MAX_VALUE;
            Set<Long> s = new HashSet<>();
            for (int i = 0; i < n; i++) {
                long ele = ar[i];
                if (s.contains(ele)) {
                    s.remove(ele);
                }
                int exist = s.size();
                long reqCnt = ele - 1 - exist;
                long del = Math.max(0, n + reqCnt - ele);
                ans = Math.min(ans, del * c + reqCnt * d);
                s.add(ele);
            }
            ans = Math.min(ans, d + n * c);
            System.out.println(ans);
        }
    }
}
