package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Cf1833D {

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

    public static boolean compare (int[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            if (a[i] > b[i]) {
                return true;
            } else if (a[i] < b[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            int[] res = new int[n];
            for (int i = 0; i < n; i++) {
                int rt = i;
                for (int j = i; j < n; j++) {
                    if (p[j] > p[rt]) {
                        rt = j;
                    }
                }
                if (rt != i) {
                    rt--;
                }
                int[] temp = new int[n];
                int idx = 0;
                for (int j = rt+1; j < n; j++) {
                    temp[idx] = p[j];
                    idx++;
                }
                for (int j = rt; j >= i; j--) {
                    temp[idx] = p[j];
                    idx++;
                }
                for (int j = 0; j <= i-1; j++) {
                    temp[idx] = p[j];
                    idx++;
                }

                if (res[0] == 0 || compare(temp, res)) {
                    res = temp;
                }
            }
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}