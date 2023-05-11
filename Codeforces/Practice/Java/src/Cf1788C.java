package src;

import java.util.*;

public class Cf1788C {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            if (n % 2 == 0) {
                System.out.println("NO");
            } else {
                System.out.println("YES");
                int temp = 2 * n;
                for (int i = 1; i <= n; i += 2) {
                    System.out.println(i + " " + temp);
                    temp--;
                }
                for (int i = 2; i <= n; i += 2) {
                    System.out.println(i + " " + temp);
                    temp--;
                }
            }
        }
    }
}
