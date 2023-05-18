package src;

import java.util.*;

public class Cf1792C {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                mp.put(temp, i);
            }

            int k = n / 2;
            while (k > 0) {
                if (mp.get(k) < mp.get(k+1) && mp.get(n - k + 1) > mp.get(n - k)) {
                    k--;
                } else {
                    break;
                }
            }
            System.out.println(Math.max(k , 0));

        }
    }
}
