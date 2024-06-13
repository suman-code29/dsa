package linkedlist.basic;
class Node {
    int val;
    Node next;
    Node(int x) {
        val = x;
    }
}

public class LinkedList {
    // create LL from array
    private Node convertArrayToLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i=1; i<arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // insert at the start
    private Node insertAtHead(Node head, int value) {
        Node temp = new Node(value);
        temp.next = head;
        return temp;
    }

    // insert at the end
    private Node insertAtTail(Node head, int value) {
        Node newNode = new Node(value);
        Node temp = head;
        while(temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        return head;
    }

    // insert at the kth position
    private Node insertAtKthPosition(Node head, int value, int pos) {
        Node newNode = new Node(value);
        Node temp = head;
        int ptr= 0;
        while(temp.next != null) {
            if (ptr == pos) {
                Node next = temp.next;
                temp.next = newNode;
                newNode.next = next;
            }
            ptr++;
            temp = temp.next;
        }
        return head;
    }

    // insert after the value
    private Node insertAfterTheValue(Node head, int element, int value) {
        Node newNode = new Node(element);
        Node temp = head;
        while(temp.next != null) {
            if (temp.val == value) {
                Node next = temp.next;
                temp.next = newNode;
                newNode.next = next;
            }
            temp = temp.next;
        }
        return head;
    }

    // delete at the start
    private void deleteTheHead(Node head) {
        Node temp = head;
        Node next = temp.next;
        temp.next = null;
    }

    // delete at the end
    private void deleteTheTail(Node head) {
        Node temp = head;
        while(temp.next.next != null) {
            temp = temp.next;
        }
        temp.next = null;
    }

    // Deletion of the Kth element of LL
    private void deleteTheKthElement(Node head, int pos) {
        Node temp = head;
        Node prev=null;
        int ptr = 0;
        if (head == null) return;
        if (pos == 1) {
            Node te = head;
            head = head.next;
            return;
        }
        while(temp != null) {
            ptr++;
            if (ptr == pos) {
                prev.next = prev.next.next;
                break;
            }
            prev = temp;
            temp = temp.next;
        }
    }

    // Delete the element with value X
    private void deleteTheValueX(Node head, int element) {
        Node temp = head;
        if (head.next == null) return;
        Node prev = null;
        while (temp.next != null) {
            if (temp.val == element) {
                prev.next = temp.next;
                temp.next = null;
                break;
            }
            prev = temp;
            temp=temp.next;
        }
    }

    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        Node result = linkedList.convertArrayToLL(new int[]{12,6,5,8});
        Node insertAtHead = linkedList.insertAtHead(result, 9);
        Node insertAtTail = linkedList.insertAtTail(insertAtHead, 10);
        Node insertAtKthPosition = linkedList.insertAtKthPosition(insertAtTail, 2, 2);
        Node insertAfterTheValue = linkedList.insertAfterTheValue(insertAtKthPosition, 7, 8);
        linkedList.deleteTheHead(insertAfterTheValue);
        linkedList.deleteTheTail(result);
        linkedList.deleteTheKthElement(result, 3);
        linkedList.deleteTheValueX(result, 6);

    }


}
