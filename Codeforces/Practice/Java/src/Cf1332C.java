package src;

import java.util.*;

public class Cf1332C {

    static class Graph {
        ArrayList<Integer> adj[];
        boolean[] vis;

        Graph(int n) {
            adj = new ArrayList[n+1];
            for (int i = 0; i <= n; i++) {
                adj[i] = new ArrayList<Integer>();
            }
            vis = new boolean[n+1];
        }

        public void addEdge(int u, int v) {
            adj[u].add(v);
            adj[v].add(u);
        }

        public void dfs(int u, Map<Character, Integer> mp, String s) {
            vis[u] = true;
            if (mp.containsKey(s.charAt(u-1))) {
                int curr = mp.get(s.charAt(u-1));
                mp.put(s.charAt(u-1), curr + 1);
            } else {
                mp.put(s.charAt(u-1), 1);
            }
            for (Integer v : adj[u]) {
                if (!vis[v]) {
                    dfs(v, mp, s);
                }
            }
        }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            Graph g = new Graph(n+1);
            for (int i = 1; i <= k; i++) {
                for (int j = i+k; j <= n; j += k) {
                    g.addEdge(i, j);
                }
            }
            for (int i = 1; i <= (n + 1) / 2; i++) {
                g.addEdge(i, n-i+1);
            }
            int ans = 0;
            for (int i = 1; i <= n; i++) {
                if (!g.vis[i]) {
                    Map<Character, Integer> mp = new HashMap<>();
                    g.dfs(i, mp, s);
                    int count = 0;
                    int max = 0;
                    for (Character ch : mp.keySet()) {
                        int val = mp.get(ch);
                        count += val;
                        max = Math.max(max, val);
                    }
                    count -= max;
                    ans += count;
                }
            }
            System.out.println(ans);
        }
    }
}
