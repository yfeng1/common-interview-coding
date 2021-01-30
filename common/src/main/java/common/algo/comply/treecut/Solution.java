package common.algo.comply.treecut;

import java.util.*;

class Solution {
    public int solution(int[] a) {
        // write your code in Java SE 8
        // iterate 1 times
        if (a.length == 1 ){
            return 0;
        }

        int treeCutCountFirstUp = 0;
        int treeCutCountFirstDown = 0;
        for (int i = 0 ; i < a.length; i++) {
            if (i % 2 == 0) {
                if (i == 0) {
                    if (a[i] >= a[i+1] ) {
                        treeCutCountFirstUp++;
                    }
                }
                else if (i == a.length -1) {
                    if (a[i] >= a[i-1] ) {
                        treeCutCountFirstUp++;
                    }
                }
                else if (a[i] >= a[i-1] || a[i] >= a[i+1] ) {
                    treeCutCountFirstUp++;
                }
            }

            if (i % 2 == 1) {
                if (i == a.length -1) {
                    if (a[i] >= a[i-1] ) {
                        treeCutCountFirstDown++;
                    }
                }
                else if (a[i] >= a[i-1] || a[i] >= a[i+1] ) {
                    treeCutCountFirstDown++;
                }
            }
        }
        return Math.min(treeCutCountFirstUp, treeCutCountFirstDown);
    }
}
