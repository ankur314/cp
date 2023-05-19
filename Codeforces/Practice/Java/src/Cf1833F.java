package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cf1833F {

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader()
        {
            br = new BufferedReader(
                    new InputStreamReader(System.in));
        }

        String next()
        {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                }
                catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() { return Integer.parseInt(next()); }

        long nextLong() { return Long.parseLong(next()); }

        double nextDouble()
        {
            return Double.parseDouble(next());
        }

        String nextLine()
        {
            String str = "";
            try {
                if(st.hasMoreTokens()){
                    str = st.nextToken("\n");
                }
                else{
                    str = br.readLine();
                }
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

    static long modInverse(long a, long m)
    {
        long m0 = m, t, q;
        long x0 = 0, x1 = 1;

        if (m == 1)
            return 0;

        while (a > 1)
        {
            q = a / m;
            t = m;
            m = a % m;
            a = t;
            t = x0;
            x0 = x1 - q * x0;
            x1 = t;
        }

        if (x1 < 0)
            x1 += m0;

        return x1 % m;
    }


    public static void main (String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            long[] a = new long[n];
            long[] prod = new long[n+1];
            Map<Long, Long> mp = new HashMap<>();
            Set<Long> st = new HashSet<>();
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                if (mp.containsKey(a[i])) {
                    long val = mp.get(a[i]);
                    mp.put(a[i], val + 1);
                } else {
                    mp.put(a[i], 1L);
                }

                st.add(a[i]);
            }
            List<Long> temp = new ArrayList<>(st);
            Collections.sort(temp);

            prod[0] = 1;
            int x = temp.size();

            for (int i = 0; i < x; i++) {
                prod[i+1] = (prod[i] * mp.get(temp.get(i))) % 1000_000_007L;
            }

            long ans = 0;
            for (int i = 0; i < x; i++) {
                if (i + m - 1 < x) {
                    if (temp.get(i + m - 1) == temp.get(i) + m - 1) {
                        ans += (prod[i + m] * modInverse(prod[i], 1000_000_007L)) % 1000_000_007L;
                        ans %= 1000_000_007L;
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
