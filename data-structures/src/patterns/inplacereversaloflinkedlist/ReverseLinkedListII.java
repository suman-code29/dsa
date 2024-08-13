package patterns.inplacereversaloflinkedlist;

public class ReverseLinkedListII {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == right) {
            return head;
        }

        ListNode current = head;
        ListNode previous = null;

        for(int i=0; current != null && i<left-1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfLeft = previous;
        ListNode firstNodeOfSubList = current;
        ListNode next = null;

        for (int i=0; current != null && i < right-left+1; i++) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (lastNodeOfLeft != null) {
            lastNodeOfLeft.next = previous;
        } else {
            head = previous;
        }

        firstNodeOfSubList.next = current;
        return head;
    }

    public static void main(String[] args) {
        ReverseLinkedListII r = new ReverseLinkedListII();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = r.reverseBetween(head, 2, 4);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
