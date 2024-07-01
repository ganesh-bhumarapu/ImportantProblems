import java.util.*;
class Tree{
    int data;
    Tree left;
    Tree right;
    Tree(int d){
        data = d;
        left = null;
        right = null;
    }
}
class Node{
    int data;
    Node next;
    Node(int d){
        data = d;
        next = null;
    }
}
class MakeBinaryTreeFromLinkedList{
    public static Tree convert(Node head){
        if(head == null){
            return null;
        }
        Tree root = new Tree(head.data);
        head = head.next;
        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(head != null){
            Tree current = q.poll();
            Tree leftChild = new Tree(head.data);
            current.left = leftChild;
            q.add(leftChild);

            if(head == null) break;

            Tree rightChild = new Tree(head.data);
            current.right = rightChild;
            q.add(rightChild);
            head = head.next;
        }
        return root;
    }

    public static void levelOrder(Tree root){
        if(root == null) return;

        Queue<Tree> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Tree current = q.poll();
            System.out.println(current.data + " ");
            if(current.left != null) q.add(current.left);
            if(current.right != null) q.add(current.right);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n <= 0){
            return;
        }
        Node head = new Node(sc.nextInt());
        Node current = head;
        for(int i = 1; i < n; i++){
            current.next = new Node(sc.nextInt());
            current = current.next;
        }
        Tree root = convert(head);
        System.out.print("Level order traversal: ");
        levelOrder(root);
    }
}