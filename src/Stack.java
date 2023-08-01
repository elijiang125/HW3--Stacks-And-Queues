class EmptyStackE extends Exception{}

public class Stack<E>{
    private DoublyLinkedList<E> st;
    private int size;

    // TODO: default constructor
    public Stack(){
        st = new DoublyLinkedList<>(); //brand new doubly linked list
        size = st.size();
    }

    // TODO: Push the element to the top of stack
    public void push(E elem){
        st.insertAtHead(elem);
        size++;
    }

    // TODO: Pop the element off the top of the stack. If nothing to pop, throw EmptyStackE
    public E pop() throws EmptyStackE {
        E first;
        if (this.size == 0) {
            throw new EmptyStackE();
        }
        try {
            first = this.st.deleteAtHead();
        } catch (EmptyListE e) {
            throw new RuntimeException(e);
        }

        size--; //deleted
        return first;
    }

    // TODO: Without affecting the stack, return the element at the top of the stack
    public E peek() throws IndexOutOfBoundsException{
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.st.get(0);
    }

    public int size() {
        return this.size;
    }

    // TODO: Check if some other object is the same Stack
    public boolean equals(Object o){
        if (o instanceof Stack<?>) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        return st.toString();
    }

}
