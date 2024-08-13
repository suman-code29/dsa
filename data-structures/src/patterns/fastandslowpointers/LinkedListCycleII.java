package patterns.fastandslowpointers;

public class LinkedListCycleII {

    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public ListNode detectCycle(ListNode head) {

        ListNode pointer = getSlowPointerIfCycleDetected(head);
        if (pointer == null) {
            return pointer;
        }
        ListNode newPointer = head;
        while(newPointer != pointer) {
            newPointer = newPointer.next;
            pointer = pointer.next;
        }
        return newPointer;
    }

    private ListNode getSlowPointerIfCycleDetected(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return slow;
            }
        }
        return null;
    }
}
