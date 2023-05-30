package src;

import java.util.*;

public class Cf1611D {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] b = new int[n];
            int root = -1;
            for (int i = 0; i < n; i++) {
                b[i] = in.nextInt();
                if (b[i] == i+1) {
                    root = i+1;
                }
            }
            int[] p = new int[n];
            for (int i = 0; i < n; i++) {
                p[i] = in.nextInt();
            }
            if (p[0] != root) {
                System.out.println(-1);
                continue;
            }
            int max = 0;
            int[] res = new int[n];
            Arrays.fill(res, -1);
            res[root-1] = 0;

            boolean chk = true;

            int[] d = new int[n];

            for (int i = 1; i < n; i++) {
                if (res[b[p[i]-1]-1] == -1) {
                    chk = false;
                    break;
                }
                res[p[i]-1] = max + 1 - d[b[p[i]-1]-1];
                d[p[i]-1] = max + 1;
                max += 2;
            }

            if (!chk) {
                System.out.println(-1);
                continue;
            }
            for (int i = 0; i < n; i++) {
                System.out.print(res[i] + " ");
            }
            System.out.println();
        }
    }
}
