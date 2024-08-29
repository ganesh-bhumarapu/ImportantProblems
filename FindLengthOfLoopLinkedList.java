import java.util.*;
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class FindLengthOfLoopLinkedList {

    // Function to find the length of the loop in the linked list.
    public static int loopLength(Node head) {
        Node fast = head;
        Node slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                int count = 1;
                fast = fast.next;
                while (fast != slow) {
                    count++;
                    fast = fast.next;
                }
                return count;
            }
        }
        return 0; // No loop
    }

    // Helper function to create a loop in the linked list.
    public static void createLoop(Node head, int k) {
        if (k == 0) return;

        Node temp = head;
        Node loopStart = null;

        // Traverse the list to the k-th node
        int count = 1;
        while (temp.next != null) {
            if (count == k) {
                loopStart = temp;
            }
            temp = temp.next;
            count++;
        }

        // Create the loop by connecting the last node to the k-th node
        temp.next = loopStart;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Create a linked list
        System.out.println("Enter the number of nodes:");
        int n = sc.nextInt();
        Node head = null, tail = null;

        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Create a loop in the linked list if required
        System.out.println("Enter the position (1-based) where you want to create a loop (0 for no loop):");
        int k = sc.nextInt();
        if (k > 0 && k <= n) {
            createLoop(head, k);
        }

        // Find the length of the loop
        int loopLen = loopLength(head);
        if (loopLen == 0) {
            System.out.println("No loop detected.");
        } else {
            System.out.println("Length of the loop is: " + loopLen);
        }

        sc.close();
    }
}