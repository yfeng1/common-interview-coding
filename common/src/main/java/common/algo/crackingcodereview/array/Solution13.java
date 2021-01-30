package common.algo.crackingcodereview.array;

import java.util.Arrays;

public class Solution13 {
    public static char[] removeDuplicate(char[] s) {
        int tail = 1;

        for (int i = 1; i < s.length; i++) {
            int j;
            for (j = 0; j < tail; j++) {
                if (s[i] == s[j]) break;
            }
            if (j == tail) {
                s[tail] = s[i];
                tail++;
            }
        }
        String s1 = String.copyValueOf(s, 0, tail);
        return s1.toCharArray();
    }
}
