package src;

import java.util.*;

public class Cf1809C {

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            int num = 1;
            while (((num * (num + 1)) / 2) <= k) {
                num++;
            }
            if (((num * (num + 1)) / 2) > k) {
                num--;
            }
            int[] ar = new int[n];
            for (int i = 0; i < num; i++) {
                ar[i] = 1;
            }
            for (int i = num; i < n; i++) {
                ar[i] = -999;
            }
            int diff = k - ((num * (num + 1)) / 2);
            if (diff > 0) {
                ar[diff - 1] = 1000;
            }
            for (int item : ar) {
                System.out.print(item + " ");
            }
            System.out.println();
        }
    }
}
