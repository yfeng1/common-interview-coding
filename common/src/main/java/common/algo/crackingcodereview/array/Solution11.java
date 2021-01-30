package common.algo.crackingcodereview.array;

import java.util.HashSet;
import java.util.Set;

public class Solution11 {

    Set<Character> characterSet = new HashSet<>();

    boolean isUnique(String s) {
        for (char c : s.toCharArray()) {
            if (characterSet.contains(c)) {
                return false;
            } else {
                characterSet.add(c);
            }
        }
        return true;
    }
}
