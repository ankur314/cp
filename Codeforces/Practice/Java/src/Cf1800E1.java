package src;

import java.util.*;

public class Cf1800E1 {

    public static String swap (String s, int i, int j) {
        char[] ch = s.toCharArray();
        char temp = ch[i];
        ch[i] = ch[j];
        ch[j] = temp;
        return new String(ch);
    }

    public static String check (String s, String pat) {
        Queue<String> que = new LinkedList<>();
        que.add(s);

        Set<String> st = new HashSet<>();
        st.add(s);

        while (!que.isEmpty()) {
            String x = que.poll();
            if (x.equals(pat)) {
                return "YES";
            }
            for (int i = 0; i < x.length(); i++) {
                if (i + 3 < x.length()) {
                    String temp = swap(x, i, i+3);
                    if (!st.contains(temp)) {
                        que.add(temp);
                        st.add(temp);
                    }
                }
                if (i + 4 < x.length()) {
                    String temp = swap(x, i, i+4);
                    if (!st.contains(temp)) {
                        que.add(temp);
                        st.add(temp);
                    }
                }
            }
        }
        return "NO";
    }

    public static boolean isSameChars (String s, String t) {
        char[] s1 = s.toCharArray();
        Arrays.sort(s1);
        String sNew = new String(s1);

        char[] t1 = t.toCharArray();
        Arrays.sort(t1);
        String tNew = new String(t1);

        if (sNew.equals(tNew)) {
            return true;
        }
        return false;
    }

    public static void main (String[] args) {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        while (T-- > 0) {
            int n = in.nextInt();
            int k = in.nextInt();
            String s = in.next();
            String t = in.next();

            if (n >= 6) {
                if (isSameChars(s, t)) {
                    System.out.println("YES");
                } else {
                    System.out.println("NO");
                }
            } else {
                System.out.println(check(s, t));
            }
        }
    }
}
