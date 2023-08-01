

class EmptyListE extends Exception{}

public class DoublyLinkedList<E> {

    private NodeDL<E> head;
    private NodeDL<E> tail;
    private int size;

    // TODO: default constructor
    public DoublyLinkedList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // TODO: secondary constructor
    public DoublyLinkedList(NodeDL<E> head, NodeDL<E> tail){
        this.head = head;
        this.tail = tail;
        this.size = (this.head.toString().length()) / 2;
    }

    public int size() {
        return this.size;
    }

    // TODO: Insert elem at the start of the DoublyLinkedList
    //NOTE: Done
    void insertAtHead(E elem){
        NodeDL<E> new_Node = new NodeDL<>(elem); //creates a new nodeDL
        NodeDL<E> tempNode;

        if (this.head == null) { //if the head node is null, then
            this.head = new_Node; //let head node become the new node added
        }

        else if (this.tail == null && size() == 1) {
            tempNode = this.head;
            this.head = new_Node;
            this.tail = tempNode;
            this.tail.prev = this.head;
            this.head.next = this.tail;
        }

        else {
            tempNode = this.head;
            tempNode.prev = new_Node;
            new_Node.next = tempNode; //next node is the head node beforehand
            new_Node.prev = null;
            this.head = new_Node; //head node becomes new node
        }
        size++;

        //The next node/s will be the head NodeDL list
        //previous is null, indicating the first

    }

    // TODO: Insert elem at the end of the DoublyLinkedList
    // DONE
    void insertAtTail(E elem){
        NodeDL<E> new_Node = new NodeDL<>(elem); //creates a new nodeDL
        NodeDL<E> tempNode;

        new_Node.next = null;
        //last node, so next node will be nothing

        if (tail == null) { //if DLL is empty, make new list with it at the tail
            this.tail = new_Node;
            this.tail.prev = this.head;
        }

        else if (this.head == null && size() == 1) {
            tempNode = this.tail;
            this.tail = new_Node;
            this.head = tempNode;
            this.head.next = this.tail;
            this.tail.prev = this.head;
        }

        else { //if not, proceed to do the usual
            tempNode = this.tail; //saves original last node
            tempNode.next = new_Node;
            new_Node.next = null;
            new_Node.prev = tempNode;
            this.tail = new_Node;

        }
        size++;

    }

    // TODO: Delete the element from the start of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    // NOTE: Do I return first element after deleting the head?
    E deleteAtHead() throws EmptyListE{

        NodeDL<E> deleted;
        if (size() == 0) { //if list is already empty
            throw new EmptyListE();
        }

        else if (size() == 1) {
            deleted = this.head;
            head = null; //it's an empty list
            size--;

        }

        else {
            deleted = this.head;
            this.head = this.head.next; //assign head to next node on list
            size--;
        }

        return deleted.data;

    }


    // TODO: Delete the element from the end of the DoublyLinkedList. Throw an EmptyListE if there's nothing to delete
    // Note: Do I return first element after deleting the tail?
    E deleteAtTail() throws EmptyListE{
        NodeDL <E> temp;
        E answer = this.tail.data;
        if (size() == 0) { //if list is already empty
            throw new EmptyListE();
        }

        else if (size() == 1) {
            head = null; //it's an empty list
            tail = null;
            size--;
        }

        else {
            temp = this.tail.prev; //point to new tail
            temp.next = null; //last one, so next one will show nothing
            this.tail = temp; //reverse assignment
            size--;
        }
        return answer;


    }

    // TODO: Get the element at some position. If it's not possible, throw an IndexOutOfBoundsException
    E get (int index) throws IndexOutOfBoundsException{

        int count;
        NodeDL<E> current;

        if (index < 0 || index >= this.size) { //if not possible, throw exception
            throw new IndexOutOfBoundsException("Index is unreachable.");
        }
        else if (size() == 1 && this.tail != null) {
            return this.tail.data;
        }

        else if (index <= this.size/2) { //if it's at first half of list, use head
            count = 0;
            current = this.head;

            while (count != index) {
                if (null != current.next) {
                    current = current.next;
                    count++;
                }
            }
            return current.data;
        }
        else { //or else start from tail, and go from there
            count = this.size - 1;
            current = this.tail;
            while (count != index) {
                if (null != current.prev) {
                    current = current.prev;
                    count--;
                }
            }
            return current.data;
        }

    }

    // TODO: Search the DoublyLinkedList for elem. If not found, return -1;
    public int search(E elem){
        NodeDL<E> current = this.head; //checking current node
        int pos;

        for (pos = 0; pos < size(); pos++) { //traverse through DLL
            if (current.data == elem) { //if element matches
                break; //leave loop
            }
            else if (pos == size() - 1) {
                //if at the end of the list and not found, return -1
                return -1;
            }
            else {
                //go to the next node
                current = current.next;
            }
        }
        return pos; //return position after breaking through
    }


    // TODO: When passed some object, return true if it's a DoublyLinkedList, has the same elements in the same order.
    //need help on equals for ALL CLASSES
    public boolean equals(Object o){
        if (o instanceof DoublyLinkedList) {
            DoublyLinkedList dll = new DoublyLinkedList<E>();
            if (dll.size() == this.size) {
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String ret = "";
        NodeDL<E> temp = head;
        for(int i = 0; i < size; i++){
            ret += temp.data + " ";
            temp = temp.next;
        }
        return ret;
    }
}
