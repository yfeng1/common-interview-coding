package common.algo.comply.treecut;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solution() {
        Solution treeCut = new Solution();
        int[] ints = new int[100000];
        for (int i = 0; i < 100000; i++) {
            ints[i] = 3;
        }
        int solution = treeCut.solution(ints);
        System.out.println(solution);
    }
}