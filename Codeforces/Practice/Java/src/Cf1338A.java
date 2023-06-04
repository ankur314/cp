package src;

import java.util.*;

public class Cf1338A {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int ans = 0;
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                if (temp > max) {
                    max = temp;
                } else {
                    int diff = max - temp;
                    int count = 0;
                    while (diff > 0) {
                        diff /= 2;
                        count++;
                    }
                    ans = Math.max(ans, count);
                }
            }
            System.out.println(ans);
        }
    }
}
