package common.algo.crackingcodereview.array;

import java.util.List;

public class Solution12 {

    public String reverseString(List<Character> cStyle) {
        StringBuilder builder = new StringBuilder();
        for (int i = cStyle.size() - 2; i >= 0; i--) {
            builder.append(i);
        }
        return builder.toString();
    }

    public char[] inplaceReverse(char[] cStyle) {
        int start = 0;
        int end = cStyle.length - 1;
        while (start < end) {
            char temp = cStyle[start];
            cStyle[start] = cStyle[end];
            cStyle[end] = temp;
            start ++;
            end --;
        }
        return cStyle;
    }
}
