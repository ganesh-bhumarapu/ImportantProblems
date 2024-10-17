import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class SplitLinkedListAlternatingly{
    public static Node[] split(Node head){
        Node head1 = head;
        Node head2 = head.next;
        Node curr1 = head1;
        Node curr2 = head2;

        while(curr1 != null && curr1.next != null && curr2 != null && curr2.next != null){
            curr1.next = curr1.next.next;
            curr1 = curr1.next;

            curr2.next = curr2.next.next;
            curr2 = curr2.next;
        }
        // to handle last node if they are not null we should point next to null
        if(curr1 != null){
            curr1.next = null;
        }
        if(curr2 != null){
            curr2.next = null;
        }

        Node[] heads = new Node[2];
        heads[0] = head1;
        heads[1] = head2;

        return heads;
    }
    public static Node createLinkedList(int[] list){
        if(list.length == 0) return null;

        Node head = new Node(list[0]);
        Node curr = head;
        for(int i = 1; i < list.length; i++){
            curr.next = new Node(list[i]);
            curr = curr.next;
        }
        return head;
    }
    public static void printList(Node head){
        Node curr = head;
        while(curr != null){
            System.out.println(curr.data + " ");
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }
        Node head = createLinkedList(list);
        Node[] res = split(head);
        System.out.println(res[0] + " " + res[1]);
    }
}