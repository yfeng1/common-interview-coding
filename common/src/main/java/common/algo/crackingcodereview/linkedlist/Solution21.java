package common.algo.crackingcodereview.linkedlist;

import java.util.HashSet;
import java.util.Set;

public class Solution21 {

    private static final Set<Integer> alreadySet = new HashSet<>();
    public static void removeDuplicate(Node head){

        alreadySet.add(head.data);
        if (head.next == null) {
            //
        } else {
            removeDuplicatef(head);
        }
    }

    public static void removeDuplicatef(Node head) {
        Node current = head;
        while (current.next != null) {
            if (alreadySet.contains(current.next.data)) {
                current.next = current.next.next;
            }
            else {
                alreadySet.add(current.next.data);
                current = current.next;
            }
        }
    }
}
