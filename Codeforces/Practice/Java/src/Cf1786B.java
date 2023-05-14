package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cf1786B {

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

    public static int[] getLimits (int a, int b, int w, int h) {
        int a_new1 = b + w - h;
        int a_new2 = b - w + h;
        int diff1 = a_new1 - a;
        int diff2 = a_new2 - a;
        if (diff1 > diff2) {
            int temp = diff1;
            diff1 = diff2;
            diff2 = temp;
        }
        return new int[]{diff1, diff2};
    }

    public static void main (String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int w = in.nextInt();
            int h = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
            }
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
            }
            int left = Integer.MIN_VALUE;
            int right = Integer.MAX_VALUE;
            String ans = "YES";
            for (int i = 0; i < n; i++) {
                int[] res = getLimits(a[i], b[i], w, h);
                if (res[0] > right || res[1] < left) {
                    ans = "NO";
                    break;
                } else {
                    if (left == Integer.MIN_VALUE) {
                        left = res[0];
                    } else{
                        left = Math.max(left, res[0]);
                    }

                    if (right == Integer.MAX_VALUE) {
                        right = res[1];
                    } else {
                        right = Math.min(right, res[1]);
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
