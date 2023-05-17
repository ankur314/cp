package src;

import java.util.*;

public class Cf1824A {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int left = 0, right = 0, visCount = 0;
            int leftSeats = 0, rightSeats = 0;
            boolean[] vis = new boolean[m + 1];
            for (int i = 0; i < n; i++) {
                int x = in.nextInt();
                if (x == -1) {
                    left++;
                } else if (x == -2) {
                    right++;
                } else {
                    if (!vis[x]) {
                        visCount++;
                        vis[x] = true;
                    }
                }
            }
            int ans = Math.max(left, right) + visCount;
            for (int i = 1; i <= m; i++) {
                if (!vis[i]) {
                    rightSeats++;
                }
            }

            for (int i = 1; i <= m; i++) {
                if (vis[i]) {
                    ans = Math.max(ans, Math.min(left, leftSeats) + Math.min(right, rightSeats) + visCount);
                } else {
                    leftSeats++;
                    rightSeats--;
                }
            }

            ans = Math.min(ans, m);
            System.out.println(ans);
        }
    }
}
