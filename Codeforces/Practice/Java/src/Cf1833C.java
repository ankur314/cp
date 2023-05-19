package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Cf1833C {

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
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            Arrays.sort(a);
            boolean isEven = (a[0] % 2 == 0);
            boolean oddPresent = !isEven;

            String ans = "YES";
            for (int i = 1; i < n; i++) {
                if (isEven) {
                    if (a[i] % 2 != 0 && !oddPresent) {
                        ans = "NO";
                        break;
                    }
                } else {
                    if (a[i] % 2 == 0 && !oddPresent) {
                        ans = "NO";
                        break;
                    }
                }
                if (a[i] % 2 != 0) {
                    oddPresent = true;
                }
            }
            System.out.println(ans);
        }

    }
}
