package common.algo.ogury;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void test1() {
        Solution solution = new Solution();
        String cba = solution.solution("CBA");
        System.out.println(cba);
    }

}