package src;

import java.util.*;

public class Cf1778B {

    public static boolean checkIsValid (int[] a, int[] pos, int i, int d) {
        return (pos[a[i]] < pos[a[i+1]] && pos[a[i+1]] <= pos[a[i]] + d);
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int d = in.nextInt();
            int[] pos = new int[n+1];
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                pos[temp] = i;
            }
            int[] a = new int[m];
            for (int i = 0; i < m; i++) {
                a[i] = in.nextInt();
            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < m-1; i++) {
                if (!checkIsValid(a, pos, i, d)) {
                    ans = 0;
                } else {
                    int p1 = pos[a[i]];
                    int p2 = pos[a[i+1]];
                    int currDist = p2 - p1;
                    int target = (d + 1 - currDist);
                    ans = Math.min(ans, p2 - p1);
                    if (p1 + (n - p2 - 1) >= target) {
                        ans = Math.min(ans, target);
                    }

                }
            }
            System.out.println(ans);
        }
    }
}
