package src;

import java.util.*;

public class Cf1823C {

    public static void increment (Map<Integer, Integer> mp, int key) {
        if (mp.containsKey(key)) {
            int prev = mp.get(key);
            mp.put(key, prev + 1);
        } else {
            mp.put(key, 1);
        }
    }

    public static void getPrimeFactors(Map<Integer, Integer> mp, int num) {
        while (num % 2 == 0) {
            num /= 2;
            increment(mp, 2);
        }
        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            while (num % i == 0) {
                num /= i;
                increment(mp, i);
            }
        }
        if (num > 2) {
            increment(mp, num);
        }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] ar = new int[n];
            for (int i = 0; i < n; i++) {
                ar[i] = in.nextInt();
            }
            Map<Integer, Integer> mp = new HashMap<>();
            for (int i = 0; i < n; i++) {
                getPrimeFactors(mp, ar[i]);
            }
            int sumLeft = 0;
            int ans = 0;
            for (Map.Entry<Integer, Integer> me : mp.entrySet()) {
                int val = me.getValue();
                int factor = val / 2;
                ans += factor;
                val -= factor * 2;
                sumLeft += val;
            }
            ans += (sumLeft / 3);
            System.out.println(ans);
        }
    }
}
