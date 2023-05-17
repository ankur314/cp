package src;

import java.util.*;

public class Cf1811E {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            long k = in.nextLong();
            String ans = "";
            while (k > 0) {
                long val = k % 9;
                if (val >= 4) {
                    val++;
                }
                ans += String.valueOf(val);
                k /= 9;
            }
            StringBuffer sbr = new StringBuffer(ans);
            sbr.reverse();
            System.out.println(sbr);
        }
    }
}
