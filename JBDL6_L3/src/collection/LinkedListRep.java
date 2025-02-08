package collection;

public class LinkedListRep {

    public static void main(String[] args) {
        Node node = new Node(1);
        Node node1 = new Node(2);
        Node node2 = new Node(3);

        node.nextPointer = node1;
        node1.nextPointer = node2;
        node2.nextPointer = null;
    }
}
