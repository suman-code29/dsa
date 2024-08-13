package patterns.inplacereversaloflinkedlist;

public class ReverseFirstKElements {
    static class ListNode {
        int val;
        ReverseLinkedList.ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseFirstKElements(ListNode head) {
        return head;
    }
}
