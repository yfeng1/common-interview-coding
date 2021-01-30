package common.algo.crackingcodereview.array;

public class Solution16 {
    public static void rotate(int[][] matrix, int n) {
        //In place rotation
        for (int layer = 0; layer < n / 2; layer++) {
            int last = n - 1 - layer;
            int first = layer;

            for (int i = first; i < last; i++) {
                // Rotation
                int offset = i - first;
                int temp = matrix[first][first + offset];

                matrix[first][first + offset] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[first + offset][last];
                matrix[first + offset][last] = temp;

            }
        }
    }
}
