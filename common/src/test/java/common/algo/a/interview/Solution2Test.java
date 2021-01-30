package common.algo.a.interview;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;

public class Solution2Test {

    @Test
    public void minimumDistance() {

        Solution2 solution2 = new Solution2();
        List<Integer> list3 = Lists.newArrayList(1, 9, 1);
        List<Integer> list2 = Lists.newArrayList(1, 0, 0);
        List<Integer> list1 = Lists.newArrayList(1, 0, 0);
        List<List<Integer>> arrayLists = Lists.newArrayList(list1, list2, list3);
        System.out.println(solution2.minimumDistance(3,3, arrayLists));
    }

    @Test
    public void minimumDistance1() {

        Solution2 solution2 = new Solution2();
        List<Integer> list1 = Lists.newArrayList(1, 1,1,1);
        List<Integer> list2 = Lists.newArrayList(0,1, 1, 1);
        List<Integer> list3 = Lists.newArrayList(0,1, 0, 1);
        List<Integer> list4 = Lists.newArrayList(1,1, 9, 1);
        List<Integer> list5 = Lists.newArrayList(0,0, 1, 1);
        List<List<Integer>> arrayLists = Lists.newArrayList(list1, list2, list3,list4,list5);
        System.out.println(solution2.minimumDistance(5,4, arrayLists));
    }
}
