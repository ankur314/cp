package src;

import java.util.*;

public class Cf1821C {

    public static int divide(int num) {
        int val = 0;
        while (num != 0) {
            num /= 2;
            val++;
        }
        return val;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            String str = in.next();
            int ans = Integer.MAX_VALUE;
            for (int p = 0; p < 26; p++) {
                char ch = (char) (p+'a');
                int cnt = 0;
                int temp = 0;
                for (int i = 0; i < str.length(); i++) {
                    if (str.charAt(i) == ch) {
                        temp = Math.max(temp, divide(cnt));
                        cnt = 0;
                    } else {
                        cnt++;
                    }
                }
                temp = Math.max(temp, divide(cnt));
                ans = Math.min(ans, temp);
            }
            System.out.println(ans);
        }
    }
}
