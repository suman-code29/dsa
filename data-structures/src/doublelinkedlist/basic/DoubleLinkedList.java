package doublelinkedlist.basic;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        next = prev = null;
    }

    Node(int data, Node next, Node prev) {
        this.data = data;
        this.next = next;
        this.prev = prev;
    }
}

public class DoubleLinkedList {
    private Node convertArrayToDLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;
        for (int i=1; i<arr.length; i++) {
            Node temp = new Node(arr[i], null, prev);
            prev.next = temp;
            prev = prev.next;
        }
        return head;
    }

    void print(Node head) {
        while(head != null) {
            System.out.println(head.data);
            head = head.next;
        }
    }

    // insert at the start
    private Node insertAtTheHead(Node head, int element) {
        Node temp = new Node(element);
        temp.next = head;
        head.prev = temp;
        return temp;
    }

    // insert at the end
    private Node insertAtTheTail(Node head, int element) {
        Node newNode = new Node(element);
        if (head.next == null) {
            head.next = newNode;
            newNode.prev = head;
        } else {
            Node temp = head;
            while(temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
            newNode.prev = temp;
        }
        return head;
    }

    // insert at the kth position
    private Node insertAtKthPosition(Node head, int pos, int element) {
        Node temp = head;
        int ptr = 0;
        while(temp.next != null) {
            ptr++;
            if (ptr == pos) break;
            temp = temp.next;
        }
        Node prev = temp.prev;
        Node newNode = new Node(element, temp, prev);
        prev.next = newNode;
        temp.prev = newNode;
        return head;
    }

    // insert before the Node
    private void insertBeforeANode(Node node, int val) {
        Node prev = node.prev;
        Node newNode = new Node(val, node, prev);
        prev.next = newNode;
        node.prev = newNode;
    }

    // delete at the start
    private void deleteAtTheStart(Node head) {
        Node next = head.next;
        head.next = null;
        next.prev = null;
    }

    // delete at the end
    private void deleteAtEnd(Node head) {
        Node prev = head;
        Node temp = head;
        while(temp.next != null) {
            prev = temp;
            temp = temp.next;
        }
        prev.next = null;
        temp.prev = null;
    }

    // delete the kth position
    private void deleteAtTheKthPosition(Node head, int pos) {
        int ptr = 0;
        Node temp = head;
        while(temp != null) {
            ptr++;
            if (ptr == pos) break;
            temp = temp.next;
        }


        Node prev = temp.prev;
        Node next = temp.next;


        if (prev == null && next == null) {
            return;
        } else if (prev == null){
            deleteAtTheStart(head);
        } else if (next == null) {
            deleteAtEnd(head);
        }

        prev.next = next;
        next.prev = prev;
        temp.next = null;
        temp.prev = null;
    }

    // delete after the kth position

    public static void main(String[] args) {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        Node result = doubleLinkedList.convertArrayToDLL(new int[]{12, 6, 5, 8});
        Node insertAtTheHead = doubleLinkedList.insertAtTheHead(result, 7);
        Node insertAtTheTail = doubleLinkedList.insertAtTheTail(insertAtTheHead, 0);
        Node insertAtKthPosition = doubleLinkedList.insertAtKthPosition(insertAtTheTail, 2, 3);
        doubleLinkedList.print(insertAtKthPosition);
    }
}
