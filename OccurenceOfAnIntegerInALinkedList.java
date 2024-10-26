import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class OccurenceOfAnIntegerInALinkedList{
    public static int count(Node head, int key) {
        // code here
        Node temp = head;
        int count = 0;
        while(temp != null){
            if(temp.data == key) count++;
            temp = temp.next;
        }
        return count;
    }
    private static Node createLinkedList(int[] list){
        if(list.length == 0) return null;

        Node head = new Node(list[0]);
        Node curr = head;
        for(int i = 1; i < list.length; i++){
            curr.next = new Node(list[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] list = new int[n];
        for(int i = 0; i < n; i++){
            list[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        Node head = createLinkedList(list);
        System.out.println(count(head, key));
    }
}