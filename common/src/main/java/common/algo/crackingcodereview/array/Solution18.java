package common.algo.crackingcodereview.array;

public class Solution18 {

    public static  boolean isRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        return isSubstring(s1+s1, s2);
    }

    public static boolean isSubstring(String s1, String s2) {
        return s1.contains(s2);
    }
}
