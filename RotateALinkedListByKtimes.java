import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class RotateALinkedListByKtimes{
    public static Node rotate(int k, Node head){
        if(head == null || head.next == null || k == 0){
            return head;
        }
        Node current = head;
        int count = 1;
        while(current.next != null){
            current = current.next;
            count++;
        }
        k = k % count;
        if(k == 0){
            return head;
        }
        current.next = head;
        for(int i = 0; i < k; i++){
            current = current.next;
        }
        head = current.next;
        current.next = null;

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

    public static Node constructLinkedList(int[] arr) {
        if (arr.length == 0) {
            return null;
        }
        Node head = new Node(arr[0]);
        Node current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new Node(arr[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of elements in the linked list:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the linked list:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Enter the value of k:");
        int k = sc.nextInt();

        Node head = constructLinkedList(arr);
        System.out.println("Original List:");
        printList(head);

        head = rotate(k, head);
        System.out.println("Rotated List:");
        printList(head);
    }
}