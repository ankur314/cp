package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cf1833A {

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

    public static void main (String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            String s = in.next();
            if (n == 2) {
                System.out.println(1);
                continue;
            }
            int ans = 0;
            Set <String> st = new HashSet<>();
            if (s.substring(0, 2).equals(s.substring(1, 3))) {
                ans = 1;
                st.add(s.substring(0, 2));
            } else {
                ans = 2;
                st.add(s.substring(0, 2));
                st.add(s.substring(1, 3));
            }
            for (int i = 2; i < n-1; i++) {
                if (!st.contains(s.substring(i, i+2))) {
                    ans++;
                    st.add(s.substring(i, i+2));
                }
            }
            System.out.println(ans);
        }
    }
}
