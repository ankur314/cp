package src;

import java.util.*;

public class Cf1814C {

    static class Pair {
        int x;
        int y;

        Pair(int _x, int _y) {
            x = _x;
            y = _y;
        }
    }

    static class PairComparator implements Comparator<Pair> {

        @Override
        public int compare(Pair o1, Pair o2) {
            if (o1.x < o2.x) {
                return 1;
            } else {
                return -1;
            }
        }
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int s1 = in.nextInt();
            int s2 = in.nextInt();

            List<Pair> r = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int temp = in.nextInt();
                r.add(new Pair(temp, i + 1));
            }

            Collections.sort(r, new PairComparator());
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();

            for (Pair item : r) {
                long t1 = (long) (a.size() + 1) * (long) s1 * (long) item.x;
                long t2 = (long) (b.size() + 1) * (long) s2 * (long) item.x;
                if (t1 < t2) {
                    a.add(item.y);
                } else {
                    b.add(item.y);
                }
            }

            System.out.print(a.size());
            for (Integer item : a) {
                System.out.print(" " + item);
            }
            System.out.println();

            System.out.print(b.size());
            for (Integer item : b) {
                System.out.print(" " + item);
            }
            System.out.println();
        }
    }
}
