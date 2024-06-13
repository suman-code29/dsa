package doublelinkedlist.basic;

public class InsertNumberAtPositionDLL {

    void addNode(Node head_ref, int pos, int data) {
        Node temp = head_ref;
        Node newNode = new Node(data);
        int count =1;
        while(count <= pos) {
            temp = temp.next;
            count++;
        }

        Node ptr = temp.next;

        newNode.prev = temp;
        temp.next = newNode;
        newNode.next =ptr;
    }


    public static void main(String[] args) {
        Node first = new Node(2);
        Node second = new Node(4);
        Node third = new Node(6);

        first.next = second;
        second.prev = first;
        second.next = third;
        third.prev = second;

        InsertNumberAtPositionDLL atPositionDLL = new InsertNumberAtPositionDLL();
        atPositionDLL.addNode(first, 2, 7);
    }
}
