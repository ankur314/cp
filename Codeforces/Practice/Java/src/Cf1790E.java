package src;

import java.util.*;

public class Cf1790E {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int x = in.nextInt();
            int a = x / 2;
            int b = (3 * x) / 2;
            if ((a + b == 2 * x) && ((a ^ b) == x)) {
                System.out.println(a + " " + b);
            } else {
                System.out.println(-1);
            }
        }
    }
}
