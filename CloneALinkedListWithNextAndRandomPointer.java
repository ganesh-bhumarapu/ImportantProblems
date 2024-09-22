import java.util.*;

class Node {
    int data;
    Node next, random;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.random = null;
    }
}

class CloneALinkedListWithNextAndRandomPointer {

    // Method to copy the list with next and random pointers
    public static Node copyList(Node head) {
        insertCopyInBetween(head);
        connectRandomPointers(head);
        return getDeepCopyList(head);
    }

    // Step 1: Insert copy of each node in between original nodes
    public static void insertCopyInBetween(Node head) {
        Node temp = head;
        while (temp != null) {
            Node nextElement = temp.next;
            Node copy = new Node(temp.data);
            copy.next = nextElement;
            temp.next = copy;
            temp = nextElement;
        }
    }

    // Step 2: Connect random pointers for the copied nodes
    public static void connectRandomPointers(Node head) {
        Node temp = head;
        while (temp != null) {
            Node copyNode = temp.next;
            if (temp.random != null) {
                copyNode.random = temp.random.next;
            } else {
                copyNode.random = null;
            }
            temp = temp.next.next;
        }
    }

    // Step 3: Separate the copied list from the original list
    public static Node getDeepCopyList(Node head) {
        Node temp = head;
        Node dummyNode = new Node(-1);
        Node res = dummyNode;
        while (temp != null) {
            res.next = temp.next;
            res = res.next;
            temp.next = temp.next.next;
            temp = temp.next;
        }
        return dummyNode.next;
    }

    // Method to create a linked list from user input
    public static Node createLinkedList(int[] values, int[] randomIndices) {
        Node head = null, tail = null;
        Node[] nodes = new Node[values.length];

        // Create all nodes
        for (int i = 0; i < values.length; i++) {
            Node newNode = new Node(values[i]);
            nodes[i] = newNode;
            if (head == null) {
                head = newNode;
                tail = head;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        // Assign random pointers
        for (int i = 0; i < randomIndices.length; i++) {
            if (randomIndices[i] != -1) {
                nodes[i].random = nodes[randomIndices[i]];
            }
        }

        return head;
    }

    // Helper method to print the list along with random pointers
    public static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print("Data: " + temp.data);
            if (temp.random != null) {
                System.out.println(", Random points to: " + temp.random.data);
            } else {
                System.out.println(", Random points to: null");
            }
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input the number of nodes
        System.out.print("Enter the number of nodes: ");
        int n = sc.nextInt();

        // Input the data for each node
        int[] values = new int[n];
        System.out.println("Enter the data for each node:");
        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        // Input the random pointer indices
        int[] randomIndices = new int[n];
        System.out.println("Enter the index of the random pointer for each node (enter -1 for null):");
        for (int i = 0; i < n; i++) {
            randomIndices[i] = sc.nextInt();
        }

        // Create the linked list
        Node head = createLinkedList(values, randomIndices);

        // Print the original list
        System.out.println("Original list:");
        printList(head);

        // Create a deep copy of the list
        Node clonedHead = copyList(head);

        // Print the cloned list
        System.out.println("Cloned list:");
        printList(clonedHead);

        sc.close();
    }
}
