class EmptyQueueE extends Exception{}

public class Queue<E> {
    private DoublyLinkedList<E> q;
    private int size;

    // TODO: default constructor
    public Queue(){
        q = new DoublyLinkedList<>();
        size = q.size();
    }

    // TODO: Put element at end of queue
    public void enqueue(E elem){
        q.insertAtTail(elem);
        size++;
    }

    // TODO: Return the head of the queue; If there's nothing to return then throw EmptyQueueE
    public E dequeue() throws EmptyQueueE {
        E last;
        if (this.size == 0) {
            throw new EmptyQueueE();
        }
        try {
            last = this.q.deleteAtTail();
        } catch (EmptyListE e) {
            throw new RuntimeException(e);
        }

        size--; //deleted
        return last;
    }

    // TODO: Without affecting the queue, return the element at the top of the queue
    public E peek() throws IndexOutOfBoundsException{
        if (this.size == 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.q.get(0);
    }

    public int size() {
        return this.size;
    }

    // TODO: Checks if inputted is the same Queue
    public boolean equals(Object o){
        if (o instanceof Queue) {
            return true;
        }
        else {
            return false;
        }
    }

    public String toString(){
        return "" + q.size();
    }
}
