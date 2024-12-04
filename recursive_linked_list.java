public class recursive_linked_list {
    public static void display(Node head){
        if(head == null) return;
        display(head.next);
        System.out.print(head.val+ " ");
    }
    
    public static void display_recursive(Node head){
        if(head==null) return; //base case
        System.out.println(head.val);
        display_recursive(head.next);
    }
    public static void main(String[] args) {
        Node a = new Node(10);
        Node b = new Node(30);
        Node c = new Node(43);
        Node d = new Node(64);
        Node e = new Node(56);
        Node f = new Node(98);
        a.next=b;
        b.next=c;
        c.next=d;
        d.next=e;
        e.next=f;
        display_recursive(a);
        display(a);
    }
}
