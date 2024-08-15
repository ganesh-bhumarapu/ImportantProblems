import java.util.*;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class AddOneToALinkedList {
    public static Node reverse(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Node newHead = reverse(head.next);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static Node addOne(Node head) {
        head = reverse(head);
        Node current = head;
        Node prev = head;
        int sum = current.data + 1;
        current.data = sum % 10;
        int carry = sum / 10;
        current = current.next;

        while (current != null) {
            sum = current.data + carry;
            current.data = sum % 10;
            carry = sum / 10;
            prev = current;
            current = current.next;
        }

        if (carry != 0) {
            prev.next = new Node(carry);
        }

        head = reverse(head);
        return head;
    }

    public static void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static Node createList(int[] values) {
        if (values.length == 0) {
            return null;
        }
        Node head = new Node(values[0]);
        Node current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();
        int[] values = new int[n];
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }
        Node head = createList(values);
        System.out.print("Original list: ");
        printList(head);

        head = addOne(head);
        System.out.print("List after adding one: ");
        printList(head);
    }
}
