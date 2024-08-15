package patterns.inplacereversaloflinkedlist;

public class ReverseFirstKElements {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public ListNode reverseFirstKElements(ListNode head, int k) {

        ListNode previous = null;
        ListNode current = head;
        ListNode firstPointOfSubList = head;

        for(int i=0; current != null && i<k; i++) {
            ListNode next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        firstPointOfSubList.next = current;

        return previous;
    }

    public static void main(String[] args) {
        ReverseFirstKElements r = new ReverseFirstKElements();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode result = r.reverseFirstKElements(head,  3);
        while(result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }
}
