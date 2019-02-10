package common.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        if (K <= 0) {
            return intAddInt(A, new int[]{0});
        }
        return intAddInt(A, intToArray(K));
    }

    private int[] intToArray(int k) {
        if (k == 1) {
            return new int[]{1};
        }
        int v = (int) Math.floor(Math.log10(k))+1 ;
        //System.out.println("v" + v);
        int[] result = new int[v];
        int tempK = k;
        for (int i = v - 1; i >= 0; i--) {
            result[i] =  tempK % 10;
            //System.out.println("result[i] " + result[i]);
            tempK = tempK / 10;
        }
        return result;
    }

    private List<Integer> intAddInt(int[] a, int[] b) {

        int[] c;
        if (a.length < b.length) {
            c = b;
            b = a;
            a = c;
        }
        int abOffset = a.length - b.length;
        int j, bDigit;

        LinkedList<Integer> result = new LinkedList<>();
        int nextDigit = 0;
        for (int i = a.length - 1; i >=0; i--) {
            j = i - abOffset;
            bDigit = j >= 0 ? b[j] : 0;
            result.push((a[i] + bDigit + nextDigit)%10);
            nextDigit = (a[i] + bDigit + nextDigit)/10;
            //System.out.println("a[i]: " + a[i] + " j: " + j + " bDigit: " + bDigit + " nextDigit: " + nextDigit);
        }
        if (nextDigit != 0) {
            result.push(nextDigit);
        }
        return result;
    }
}
