package patterns.inplacereversaloflinkedlist;

public class ReverseLLWithNNodes {
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

    public ListNode reverseNodes(ListNode head) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }

        head = reverseBetween(head, 1, size/2);
        if (size % 2 != 0) {
            head = reverseBetween(head, size/2+2, size);
        } else {
            head = reverseBetween(head, size/2+1, size);
        }
        return head;
    }

    public static void main(String[] args) {
        ReverseLLWithNNodes r = new ReverseLLWithNNodes();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);


        ListNode result = r.reverseNodes(head);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
