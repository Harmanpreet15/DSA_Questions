// ---------------------138 : Copy List with Random Pointer------------------------


import java.util.*;

class Node {
    int val;
    Node next;
    Node random;

    Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class LeetCode138 {

    public static Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        HashMap<Node, Node> map = new HashMap<>();

        Node curr = head;
        while(curr != null){
            map.put(curr, new Node(curr.val));
        }

        curr = head;

        while(curr != null){
            Node copy = map.get(curr);
            copy.random = map.get(curr.random);
            copy.next = map.get(curr.next);
            curr = curr.next;
        }

        return map.get(head);
    }

    public static void printList(Node head) {
        Node curr = head;

        while (curr != null) {
            System.out.print("Value: " + curr.val);

            if (curr.random != null) {
                System.out.print(", Random: " + curr.random.val);
            } else {
                System.out.print(", Random: null");
            }

            System.out.println();
            curr = curr.next;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(7);
        head.next = new Node(13);
        head.next.next = new Node(11);
        head.next.next.next = new Node(10);
        head.next.next.next.next = new Node(1);

        head.random = null;
        head.next.random = head;
        head.next.next.random = head.next.next.next.next;
        head.next.next.next.random = head.next.next;
        head.next.next.next.next.random = head;

        System.out.println("Original List:");
        printList(head);

        Node copied = copyRandomList(head);

        System.out.println("\nCopied List:");
        printList(copied);
    }
}
