package src;

import java.util.*;

public class Cf1774B {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int m = in.nextInt();
            int k = in.nextInt();
            int limit = n / k;
            int extra = 0;
            extra = n % k;
            String ans = "YES";
            while (m-- > 0) {
                int temp = in.nextInt();
                if (temp > limit) {
                    if (extra > 0 && temp == limit + 1) {
                        extra--;
                    } else {
                        ans = "NO";
                    }
                }
            }
            System.out.println(ans);
        }
    }
}
