package common.algo.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class Solution988 {


    public static final class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public String smallestFromLeaf(TreeNode root) {
        if (root.left == null && root.right == null) {
            return valToString(root.val);
        }
        List<Integer> integers = smallestFromLeafR(root);
        return integers.stream().map(this::valToString).collect(Collectors.joining());
    }

    private List<Integer> smallestFromLeafR(TreeNode root) {
        List<Integer> result;
        if (root.left == null && root.right == null) {
            result = new ArrayList<>();
        }
        else if (root.left == null) {
            result = smallestFromLeafR(root.right);
        }
        else if (root.right == null) {
            result = smallestFromLeafR(root.left);
        }
        else {
            List<Integer> leftSmall = smallestFromLeafR(root.left);
            List<Integer> rightSmall = smallestFromLeafR(root.right);
            result = compare(leftSmall, rightSmall);
        }
        result.add(root.val);
        //System.out.println("result:" + root.val);
        return result;
    }

    private String valToString(int val) {
        return Character.toString ((char) (val+97));
    }

    private List<Integer> compare(List<Integer> left, List<Integer> right) {
        Iterator<Integer> leftIt = left.iterator();
        Iterator<Integer> rightIt = right.iterator();
        while (leftIt.hasNext() && rightIt.hasNext()) {
            Integer leftNext = leftIt.next();
            Integer rightNext = rightIt.next();
            if (leftNext < rightNext) {
                return left;
            } else if (leftNext > rightNext) {
                return right;
            }
        }
        return left.size() < right.size() ?left : right;
    }
}
