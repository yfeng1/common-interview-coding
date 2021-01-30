package common.algo.crackingcodereview.array;

import common.algo.crackingcodereview.array.Solution17;
import org.junit.Test;


public class Solution17Test {

    @Test
    public void test(){
        int[][] matrix = {new int[]{11, 12, 13, 14, 15},
                new int[]{21, 22, 23, 0, 25},
                new int[]{31, 32, 0, 34, 36},
                new int[]{41, 42, 43, 44, 45}};
        print2Dmatrix(matrix);
        Solution17.rotate(matrix, 4, 5);

        print2Dmatrix(matrix);
    }

    private void print2Dmatrix(int[][] matrix) {
        System.out.println("--------------");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}