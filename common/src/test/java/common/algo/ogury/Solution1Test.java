package common.algo.ogury;

import org.junit.Test;

import static org.junit.Assert.*;

public class Solution1Test {

    @Test
    public void solution() {
        int solution = Solution1.solution(new int[]{0, 9, 0, 2, 6, 8, 0, 8, 3, 0});
        System.out.println(solution);
    }

    @Test
    public void solution1() {
        int solution = Solution1.solution(new int[]{0, 0, 0, 1, 6, 1, 0, 0});
        System.out.println(solution);
    }


    @Test
    public void solution2() {
        int[] tree = new int[100000];

        for (int i = 1; i < 100000; i++) {
            if (i % 2 == 0) {
                tree[i] = i - 2;
            } else {
                tree[i] = 0;
            }
        }
        int solution = Solution1.solution(tree);
        System.out.println(solution);
    }
}