class Node{
    int val;
    Node next;
    Node(int val){
        this.val = val;
    }
}
public class list_node_class {
    public static void print(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.println(temp.val);
            temp = temp.next;
        }
;    }
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(30);
        Node c = new Node(43);
        Node d = new Node(64);
        Node e = new Node(56);
        Node f = new Node(98);
        a.next = b; //linking = > a -> b
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        
        print(a);
        

        // System.out.println(a.val);
        // System.out.println(a.next.val);
        // System.out.println(a.next.next.val);
        // System.out.println(d.val);
        // System.out.println(d.next.val);
        // System.out.println(f.val);
    }
}