package patterns.inplacereversaloflinkedlist;

public class ReverseEveryKElementSublist {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    private ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode previous = null;
        ListNode current = head;

        for (int i=0; current != null && i<left-1; i++) {
            previous = current;
            current = current.next;
        }

        ListNode lastNodeOfFirstPart = previous;
        ListNode firstNodeOfSecondPart = current;

        for(int i=0; current != null && i<right-left+1; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if (lastNodeOfFirstPart != null) {
            lastNodeOfFirstPart.next = previous;
        } else {
            head = previous;
        }

        firstNodeOfSecondPart.next = current;

        return head;
    }

    public ListNode reverseEveryKElements(ListNode head, int k) {
        if (head == null || k <= 1) return head;

        int i=1;
        int size = 0;
        ListNode current = head;

        while(current != null) {
            size++;
            current = current.next;
        }

        while(size > 0) {
            head = reverseBetween(head, i, i+k-1);
            i = i+k;
            size = size - k;
        }

        return head;
    }

    public static void main(String[] args) {
        ReverseEveryKElementSublist r = new ReverseEveryKElementSublist();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(8);

        ListNode result = r.reverseEveryKElements(head, 2);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
