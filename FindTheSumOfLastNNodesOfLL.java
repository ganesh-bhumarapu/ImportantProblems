import java.util.*;
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next = null;
    }
}
class FindTheSumOfLastNNodesOfLL{
    public static int sumOfLastNnode(Node head, int n){
        int Tcount = 0;
        Node curr = head;
        while(curr != null){
            Tcount++;
            curr = curr.next;
        }
        int sum = 0;
        int count = 0;
        curr = head;
        while(curr != null){
            count++;
            if(count <= Tcount - n){
                curr = curr.next;
            }else{
                sum += curr.data;
                curr = curr.next;
            }
        }
        return sum;
    }
    public static Node createLinkedList(int[] arr){
        if(arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node curr = head;
        for(int i = 1; i < arr.length; i++){
            curr.next = new Node(arr[i]);
            curr = curr.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int[] arr = new int[x];
        for(int i = 0; i < x; i++){
            arr[i] = sc.nextInt();
        }
        int n = sc.nextInt();
        Node head = createLinkedList(arr);
        System.out.println(sumOfLastNnode(head, n));
    }
}