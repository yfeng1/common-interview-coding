package common.algo.comply.wordm;

import org.junit.Test;

import static org.junit.Assert.*;

public class SolutionTest {

    @Test
    public void solution() {
        Solution wordM = new Solution();
        int solution = wordM.solution("13 DUP 4 POP 5 DUP + DUP + -");
        System.out.println(solution);
    }
}