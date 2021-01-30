package common.algo.ogury;

import java.util.*;
import java.util.stream.IntStream;

class Solution {
    public String solution(String T) {
        // write your code in Java SE 8

        char[] chars = T.toCharArray();
        int sNumber = 0;
        int mNumber = 0;
        int lNumber = 0;

        for (char c : chars) {
            if ('S' == c ) {
                sNumber ++;
            } else if ('M' == c) {
                mNumber ++;
            } else if ('L' == c) {
                lNumber ++;
            }
        }
        StringBuilder builder = new StringBuilder();
        IntStream.range(0, sNumber).forEach(i->builder.append('S'));
        IntStream.range(0, mNumber).forEach(i->builder.append('M'));
        IntStream.range(0, lNumber).forEach(i->builder.append('L'));
        return builder.toString();
    }


}
