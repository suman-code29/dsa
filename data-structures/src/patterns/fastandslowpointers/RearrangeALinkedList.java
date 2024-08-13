package patterns.fastandslowpointers;

public class RearrangeALinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public void reorderList(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverseSecondHalf = reverse(slow);
        slow.next = null;


        ListNode first = head;
        while(first != null && reverseSecondHalf != null) {
            ListNode next = first.next;
            ListNode sNext = reverseSecondHalf.next;
            first.next = reverseSecondHalf;
            reverseSecondHalf.next = next;
            first = next;
            reverseSecondHalf = sNext;
        }

        if (first != null){
            first.next = null;
        }
    }

    private ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    public static void main(String[] args) {
        RearrangeALinkedList rearrangeALinkedList = new RearrangeALinkedList();
        ListNode head =  new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(12);

        rearrangeALinkedList.reorderList(head);

        while(head != null) {
            System.out.println(head.val + " ");
            head = head.next;
        }
    }
}
