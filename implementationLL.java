class SLL{// User define data structure
    private Node head;
    private Node tail;
    private int size;

    void insertAtTail(int val){ // T.C.= O(1) &&  S.C.= O(1)
        Node temp = new Node(val); //if tail is not provided T.C.=O(n)
        if(head==null) head = tail = temp;
        else{
            tail.next = temp;
            tail = temp;
        }
        size++;
    }

    void insertAtHead(int val){ // T.C.= O(1) &&  S.C.= O(1)
        Node temp = new Node(val);
        if(head==null) head = tail = temp;
        else{
            temp.next  = head;
            head = temp;
        }
        size++;
    }

    void insert(int idx, int val){ // T.C.= O(1) &&  S.C.= O(1)
        if(idx==0){ //T.C. = O(1)
            insertAtHead(val);
            return;
        }
        if(idx==size){ //T.C. = O(1)
            insertAtTail(val);
            return;
        }
        if(idx>size || idx<0){ //T.C. = O(1)
            System.out.println("Invalid Index!");
            return;
        }
        Node temp = new Node(val);
        Node x = head;
        for(int i=1 ; i<=idx-1 ; i++){
            x = x.next;
        }
        //insertion
        temp.next = x.next;
        x.next =  temp;
        size++;
    }

    int get(int idx) throws Error{
        if(idx==size-1) return tail.val;
        if(idx>=size || idx<0){
            System.out.println("Bhi ERROR!");
            return -1;
        }
        Node temp = head;
        for(int i=1 ; i<=idx  ; i++){
            temp = temp.next;
        }
        return temp.val;
    }

    void set(int idx, int val)throws Error{
        if(idx==size-1){
            tail.val = val;
        } 
        if(idx>=size || idx<0) System.out.println("Bhi ERROR!");
        Node temp = head;
        for(int i=1 ; i<=idx  ; i++){
            temp = temp.next;
        }
        temp.val = val;
    }

    void deleteAtHead()throws Error{
        if(head==null) throw new Error("List is Empty!");
        head =  head.next;
        size--;
    }

    void delete(int idx)throws Error{
        if(idx==0){
            deleteAtHead();
            return;
        }
        if(idx<0 || idx>=size){
            throw new Error("Invalid Index!");
        }
        Node temp = head;
        for(int i=1 ; i<=idx-1 ; i++){
            temp = temp.next;
        }
        if(temp.next==tail) tail = temp;
        
        temp.next = temp.next.next;
        size--;
    }

    void display(){ // T.C.= O(n) &&  S.C.= O(1)
        Node temp = head;
        while (temp!=null) {
            System.out.print(temp.val+ " ");
            temp = temp.next;
        }
        
        System.out.println();
    }

    void size(){  //T.C. = O(1) //if only head is provided T.C.=O(n)
        System.out.println("Length of Linked List is : " + size);
    }
}


public class implementationLL {
    public static void main(String[] args) {
        SLL list  = new SLL();
        list.insertAtTail(10);
        list.insertAtTail(34);

        list.display();
        
        list.insertAtHead(89);
        list.display();
        list.insertAtHead(93);
        list.insert(2, 54);
        list.display();
        list.insertAtHead(23);
        list.display();
        list.size();
        list.insertAtHead(-87);
        list.insert(10, 67);
        list.display();

        System.out.println(list.get(3));
        System.out.println(list.get(-6));

        list.set(2, 90);
        list.display();
        list.deleteAtHead();
        list.display();
        list.size();
        list.delete(4);
        list.display();
    }
}
