public class Shallow_copy_of_a_node {
    public static void main(String[] args) {
        Node a = new Node(10);
        Node temp = a; //shallow copy
        //Node temp = new Node(100);  // deep copy
        temp.val =12;
        System.out.println(a.val);
        System.out.println(temp.val);
    }
}
