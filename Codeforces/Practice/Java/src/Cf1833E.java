package src;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Cf1833E {

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

    public static void dfs (ArrayList<ArrayList<Integer>> g, boolean[] vis, int u, int[] color, int par) {
        vis[u] = true;
        color[u] = par;
        for (Integer v : g.get(u)) {
            if (!vis[v]) {
                dfs(g, vis, v, color, par);
            }
        }
    }

    public static void main (String[] args) {
        FastReader in = new FastReader();
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            ArrayList<ArrayList<Integer>> undir = new ArrayList<ArrayList<Integer>>();
            ArrayList<ArrayList<Integer>> dir = new ArrayList<ArrayList<Integer>>();

            for (int i = 0; i <= n; i++) {
                undir.add(new ArrayList<Integer>());
                dir.add(new ArrayList<Integer>());
            }
            int[] color = new int[n+1];
            for (int i = 1; i <= n; i++) {
                color[i] = i;
                int temp = in.nextInt();
                undir.get(temp).add(i);
                undir.get(i).add(temp);

                dir.get(i).add(temp);
            }

            boolean[] vis = new boolean[n+1];
            int max = 0;
            for (int i = 1; i <= n; i++) {
                if (!vis[i]) {
                    dfs(undir, vis, i, color, i);
                    max++;
                }
            }
            int min = max;
            Set<Integer> st = new HashSet<>();
            for (int i = 1; i <= n; i++) {
                int y = dir.get(i).get(0);
                if (dir.get(y).get(0) == i) {
                    st.add(color[i]);
                }
            }
            if (st.size() > 0) {
                min -= st.size();
                min++;
            }
            System.out.println(min + " " + max);
        }
    }
}
