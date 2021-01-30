package common.algo.crackingcodereview.array;

import java.util.HashSet;
import java.util.Set;

public class Solution17 {

    public static void rotate(int[][] matrix, int m, int n) {
        Set<Integer> toZeroRows = new HashSet<>();
        Set<Integer> toZeroColumns = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    toZeroRows.add(i);
                    toZeroColumns.add(j);
                }
            }
        }

        for (Integer toZeroRow : toZeroRows) {
            matrix[toZeroRow] = new int[n];
        }
        for (Integer toZeroColumn : toZeroColumns) {
            for (int i = 0; i < m; i++) {
                matrix[i][toZeroColumn] = 0;
            }
        }
    }
}
