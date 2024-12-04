class dNode {
    int val;
    dNode next;
    dNode prev;
    dNode (int val){
        this.val = val;
    }
}

class DLL{
    dNode head;
    dNode tail;
    int size;
    void display(){
        dNode temp = head;
        while (temp!=null) {
            System.out.print(temp.val+ " ");
            temp = temp.next;
        }
        System.out.println();
    }

    void insertAtTail(int val){
        dNode temp = new dNode(val);
        if(size==0) head = tail = temp;
        else{
            tail.next = temp; 
            temp.prev = tail;
            tail = tail.next;
        }
        size++;
    }

    void insertAtHead(int val){
        dNode temp = new dNode(val);
        if(size==0) head = tail = temp;
        else{
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        size++;
    }

    void insert(int idx, int val){
        if(idx==0){
            insertAtHead(val);
            return;
        }
        if(idx==size){
            insertAtTail(val);
            return;
        }
        if(idx>size || idx<0){
            System.out.println("Invalid Index!");
            return;
        }
        dNode temp = new dNode(val);
        dNode x = head;
        for(int i=1 ; i<=idx-1 ; i++){
            x = x.next;
        }
        dNode y = x.next;
        x.next = temp; temp.prev = x;
        y.prev = temp; temp.next = y;
        size++;
    }

    void deleteAtHead() throws Error{
        if(head==null) throw new Error("List is Empty");
        head = head.next;
        head.prev = null;
        size--;
    }

    void deleteAtTail() throws Error{
        if(head==null) throw new Error("List is Empty");
        tail = tail.prev; 
        tail.next=null;
        size--;
    }

    void delete(int idx) throws Error{
        if(idx==0){
            deleteAtHead();
            return;
        }
        if(idx==size-1){
            deleteAtTail();
            return;
        }
        if(idx<0 || idx>=size){
            throw new Error("Invalid Index");
        }
        dNode temp = head;
        for(int i=1 ; i<=idx-1 ; i++){
            temp = temp.next;
        }
        temp.next = temp.next.next;
        temp = temp.next;
        temp.prev = temp.prev.prev;
        size--;
    }

    int get(int idx) throws Error{
        if(idx==size-1) return tail.val;
        if(idx>=size || idx<0){
            System.out.println("Bhi ERROR!");
            return -1;
        }
        dNode temp = head;
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
        dNode temp = head;
        for(int i=1 ; i<=idx  ; i++){
            temp = temp.next;
        }
        temp.val = val;
    }
}

public class doublyLinkedList {
    public static void print(dNode head){
        dNode temp = head;
        while (temp!=null) {
            System.out.println(temp.val+ " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void printReverse(dNode tail){
        dNode temp = tail;
        while (temp!=null) {
            System.out.println(temp.val+ " ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public static void display(dNode node){
        dNode temp = node;
        while (temp.prev!=null) {
            temp = temp.prev;
        }
        // now temp is at head
        print(temp);
    }
    public static void main(String[] args) {
        DLL list = new DLL();
        list.display();
        list.insertAtTail(10);
        list.insertAtTail(20);
        list.insertAtTail(30);
        list.display();
        list.insertAtHead(50);
        list.display();
        list.insert(2, -80);
        list.display();
        list.delete(3);
        list.display();;
        System.out.println(list.get(3));
        list.set(2, 73);
        list.display();
    }
}