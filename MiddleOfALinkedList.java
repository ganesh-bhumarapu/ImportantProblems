import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        next = null;
    }
}
class MiddleOfALinkedList{
    public static int getMiddle(Node head) {
        if(head == null){
            return -1;
        }
        Node fast = head;
        Node slow = head;
        while (fast.next != null && fast != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow.data;
    }
    public static Node createLinkedList(int[] values){
        if(values.length == 0){
            return null;
        }
        Node head = new Node(values[0]);
        Node current = head;

        for(int i = 0; i < values.length; i++){
            current.next = new Node(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] values = new int[n];

        for(int i = 0; i < n; i++){
            values[i] = sc.nextInt();
        }
        Node head = createLinkedList(values);
        System.out.println(getMiddle(head));
    }
}