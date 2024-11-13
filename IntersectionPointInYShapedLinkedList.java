import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class IntersectionPointInYShapedLinkedList {

    // Static function to find intersection point in Y-shaped Linked Lists.
    static int intersectPoint(Node head1, Node head2) {
        int count1 = 0, count2 = 0;
        Node curr1 = head1, curr2 = head2;

        while (curr1 != null) {
            count1++;
            curr1 = curr1.next;
        }

        while (curr2 != null) {
            count2++;
            curr2 = curr2.next;
        }

        int diff = Math.abs(count1 - count2);
        curr1 = head1;
        curr2 = head2;

        if (count1 > count2) {
            for (int i = 0; i < diff; i++) {
                curr1 = curr1.next;
            }
        } else {
            for (int i = 0; i < diff; i++) {
                curr2 = curr2.next;
            }
        }

        while (curr1 != null && curr2 != null) {
            if (curr1 == curr2) {
                return curr1.data;
            }
            curr1 = curr1.next;
            curr2 = curr2.next;
        }

        return -1;
    }

    private static Node appendNode(Node head, int data) {
        if (head == null) {
            return new Node(data);
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(data);
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of nodes in List 1: ");
        int n1 = sc.nextInt();
        Node head1 = null;
        System.out.println("Enter elements of List 1:");
        for (int i = 0; i < n1; i++) {
            int data = sc.nextInt();
            head1 = appendNode(head1, data);
        }

        System.out.print("Enter number of nodes in List 2: ");
        int n2 = sc.nextInt();
        Node head2 = null;
        System.out.println("Enter elements of List 2:");
        for (int i = 0; i < n2; i++) {
            int data = sc.nextInt();
            head2 = appendNode(head2, data);
        }

        System.out.print("Enter the position to create intersection (1-based index in List 1): ");
        int pos = sc.nextInt();
        if (pos > 0) {
            Node temp1 = head1;
            for (int i = 1; i < pos && temp1 != null; i++) {
                temp1 = temp1.next;
            }

            if (temp1 != null) {
                Node temp2 = head2;
                while (temp2.next != null) {
                    temp2 = temp2.next;
                }
                temp2.next = temp1;
            }
        }

        int intersectionData = intersectPoint(head1, head2);
        if (intersectionData != -1) {
            System.out.println("Intersection point data: " + intersectionData);
        } else {
            System.out.println("No intersection point found.");
        }

        sc.close();
    }
}
