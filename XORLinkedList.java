import java.util.*;
//npx -> next previous xor
class Node{
    int data;
    Node npx;
    Node(int data){
        this.data = data;
        this.npx = null;
    }
}
class XORLinkedList{
    public static Node insert(Node head, int data){
        Node newNode = new Node(data);
        newNode.npx = head;
        return newNode;
    }
    public static ArrayList<Integer> getList(Node head){
        ArrayList<Integer> res = new ArrayList<>();

        while(head != null){
            res.add(head.data);
            head = head.npx;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Node head = null;

        // Input: Reading number of elements
        System.out.println("Enter the number of elements:");
        int n = sc.nextInt();

        // Input: Reading elements and inserting them into the XOR linked list
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            head = insert(head, data);
        }

        // Output: Printing the XOR linked list
        ArrayList<Integer> result = getList(head);
        System.out.println("XOR Linked List elements: " + result);
    }
}