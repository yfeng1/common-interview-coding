package common.algo.crackingcodereview.array;

public class Solution14 {
    public static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }
        else {
            int j;
            for (int i = 0; i < a.length(); i++) {
                j = a.length() - 1 - i;
                if (a.charAt(i) != b.charAt(j)){
                    return false;
                }
            }
            return true;
        }
    }
}
