package common.algo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution989 {

    public List<Integer> addToArrayForm(int[] A, int K) {
        int [] a = A;
        int k = K;
        List<Integer> result = new LinkedList<>();

        for (int i = a.length - 1; i >= 0; i--) {
            result.add(0, (a[i] + k) % 10);
            k = (a[i] + k) % 10;
        }

        while (k > 0) {
            result.add(0, k % 10);
            k = k / 10;
        }
        return result;
    }


}
