package common.algo.crackingcodereview.array;

import common.algo.crackingcodereview.array.Solution13;
import org.junit.Test;

public class Solution13Test {

    @Test
    public void removeDuplicate1() {
        char[] s = {'a', 'b', 'c', 'c', 'd'};
        System.out.println(Solution13.removeDuplicate(s));
    }

    @Test
    public void removeDuplicate2() {
        char[] s = {'a', 'b', 'c', 'd', 'd'};
        System.out.println(Solution13.removeDuplicate(s));
    }

}