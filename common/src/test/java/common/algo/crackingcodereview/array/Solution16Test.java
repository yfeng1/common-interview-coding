package common.algo.crackingcodereview.array;

import common.algo.crackingcodereview.array.Solution16;
import org.junit.Test;

public class Solution16Test {

    @Test
    public void test1(){
        int[][] matrix = {new int[]{11, 12},
                new int[]{21, 22}};
        print2Dmatrix(matrix);
        Solution16.rotate(matrix, 2);

        print2Dmatrix(matrix);
    }

    @Test
    public void test2(){
        int[][] matrix = {new int[]{11, 12, 13},
                new int[]{21, 22, 23},
                new int[]{31, 32, 33}};
        print2Dmatrix(matrix);
        Solution16.rotate(matrix, 3);

        print2Dmatrix(matrix);
    }

    @Test
    public void test3(){
        int[][] matrix = {new int[]{11, 12, 13, 14},
                new int[]{21, 22, 23, 24},
                new int[]{31, 32, 33, 34},
                new int[]{41, 42, 43, 44}};
        print2Dmatrix(matrix);
        Solution16.rotate(matrix, 4);

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