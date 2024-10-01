import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class MultiplyTwoLinkedLists {
    static final int MOD = 1000000007;

    public static long multiplyLinkedList(Node first, Node second) {
        long n1 = 0;
        long n2 = 0;

        // Build the first number from the first linked list
        while (first != null) {
            n1 = (n1 * 10 + first.data) % MOD;
            first = first.next;
        }

        // Build the second number from the second linked list
        while (second != null) {
            n2 = (n2 * 10 + second.data) % MOD;
            second = second.next;
        }

        // Multiply the two numbers and return the result modulo MOD
        return (n1 * n2) % MOD;
    }

    // Helper method to create a linked list from an array of integers
    public static Node createLinkedList(int[] arr) {
        Node head = null;
        Node tail = null;

        for (int num : arr) {
            Node newNode = new Node(num);
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = tail.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input for the first linked list
        System.out.println("Enter the number of nodes in the first linked list:");
        int n1 = sc.nextInt();
        System.out.println("Enter the elements of the first linked list:");
        int[] arr1 = new int[n1];
        for (int i = 0; i < n1; i++) {
            arr1[i] = sc.nextInt();
        }

        // Input for the second linked list
        System.out.println("Enter the number of nodes in the second linked list:");
        int n2 = sc.nextInt();
        System.out.println("Enter the elements of the second linked list:");
        int[] arr2 = new int[n2];
        for (int i = 0; i < n2; i++) {
            arr2[i] = sc.nextInt();
        }

        // Create linked lists from the input arrays
        Node first = createLinkedList(arr1);
        Node second = createLinkedList(arr2);

        // Multiply the two linked lists and print the result
        long result = multiplyLinkedList(first, second);
        System.out.println("The product of the two linked lists is: " + result);

        sc.close();
    }
}
