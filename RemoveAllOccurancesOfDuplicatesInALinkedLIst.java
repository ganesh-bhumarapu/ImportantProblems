import java.util.Scanner;

class RemoveAllOccurancesOfDuplicatesInALinkedLIst {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node removeAllDuplicates(Node head) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        while (head != null) {
            boolean isDuplicate = false;
            while (head.next != null && head.data == head.next.data) {
                isDuplicate = true;
                head = head.next;
            }
            if (isDuplicate) {
                prev.next = head.next;
            } else {
                prev = prev.next;
            }
            head = head.next;
        }
        return dummy.next;
    }

    public static Node readLinkedListFromInput() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the elements of the linked list, separated by spaces:");

        String[] input = scanner.nextLine().split(" ");
        if (input.length == 0) {
            return null; // If no input, return null (empty list)
        }

        Node head = new Node(Integer.parseInt(input[0]));
        Node current = head;

        for (int i = 1; i < input.length; i++) {
            current.next = new Node(Integer.parseInt(input[i]));
            current = current.next;
        }

        return head;
    }

    public static void printLinkedList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = readLinkedListFromInput();
        System.out.println("Original linked list:");
        printLinkedList(head);

        head = removeAllDuplicates(head);
        System.out.println("Linked list after removing all duplicates:");
        printLinkedList(head);
    }
}
