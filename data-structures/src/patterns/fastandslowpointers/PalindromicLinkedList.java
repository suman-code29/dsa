package patterns.fastandslowpointers;


public class PalindromicLinkedList {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }

        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode reverseHead = reverse(slow);
        ListNode captureReverseHead = reverseHead;

        while(head != null && reverseHead != null) {
            if (head.val != reverseHead.val) {
                break;
            }
            head = head.next;
            reverseHead = reverseHead.next;
        }

        reverse(captureReverseHead);
        if (head == null || reverseHead == null) {
            return true;
        }
        return false;
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
        PalindromicLinkedList palindromicLinkedList = new PalindromicLinkedList();

        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);

        System.out.println(palindromicLinkedList.isPalindrome(head));
    }
}
